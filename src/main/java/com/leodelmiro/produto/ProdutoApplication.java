package com.leodelmiro.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoApplication.class, args);
    }
   /* TODO ADICIONAR COBERTURA DE TESTES 80% NA PIPELINE PARA DEV E INTEGRAÇÃO RODANDO PÓS DEV, GITHUB ACTIONS E INFRA DB*/
}
