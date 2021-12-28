package br.com.zup;

import br.com.zup.domain.Cliente;
import br.com.zup.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Márcio");
            clientesRepository.salvar(cliente);
        };
    }

   public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
