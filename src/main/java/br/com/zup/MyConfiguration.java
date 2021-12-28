package br.com.zup;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }
}
