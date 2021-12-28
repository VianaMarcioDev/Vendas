package br.com.zup.repository;

import br.com.zup.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {

    private static String INSERT = "insert into clientes (nome) values (?)";

    private final JdbcTemplate jdbcTemplate;

    public ClientesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()} );
        return cliente;
    }
}
