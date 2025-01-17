package com.leodelmiro.produto.config.produto;

import com.leodelmiro.produto.dataprovider.gateway.produto.BuscaProdutoGatewayImpl;
import com.leodelmiro.produto.core.usecase.produto.impl.BuscaProdutoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscaProdutoConfig {

    @Bean
    public BuscaProdutoUseCaseImpl buscaProdutoUseCase(
            BuscaProdutoGatewayImpl buscaProdutoGatewayImpl
    ) {
        return new BuscaProdutoUseCaseImpl(buscaProdutoGatewayImpl);
    }
}
