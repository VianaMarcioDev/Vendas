package br.com.zup;

import br.com.zup.domain.Cliente;
import br.com.zup.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Márcio");
            clientesRepository.salvar(cliente);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Aldilene");
            clientesRepository.salvar(cliente2);

            List<Cliente> todosClientes = clientesRepository.listarTodosClientes();
            todosClientes.forEach(System.out::println);
        };
    }

   public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
