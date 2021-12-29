package br.com.zup.repository;

import br.com.zup.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "select * from cliente";
    private static String UPDATE = "UPDATE cliente SET nome = ? WHERE id = ?";
    private static String DELETE = "DELETE from cliente where id = ?";

    private final JdbcTemplate jdbcTemplate;

    public ClientesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()} );
        return cliente;
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL.concat("WHERE nome like ?"), new Object[]{"%" + nome + "%"} ,getClienteRowMapper() );
    }

    public List<Cliente> listarTodosClientes(){
        return jdbcTemplate.query(SELECT_ALL, getClienteRowMapper());
    }

    private RowMapper<Cliente> getClienteRowMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }
    public void deletar(Integer id){
       jdbcTemplate.update(DELETE, new Object[]{id});
    }
}
