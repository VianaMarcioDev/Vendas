package br.com.zup;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyConfiguration {

    @Bean
    public String applicationName(){
        return "Sistema de Vendas";
    }
}
