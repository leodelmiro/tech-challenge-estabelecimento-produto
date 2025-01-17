package com.leodelmiro.produto.config.produto;

import com.leodelmiro.produto.dataprovider.gateway.produto.CadastraProdutoGatewayImpl;
import com.leodelmiro.produto.core.usecase.produto.impl.CadastraProdutoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastraProdutoConfig {

    @Bean
    public CadastraProdutoUseCaseImpl cadastraProdutoUseCase(
            CadastraProdutoGatewayImpl cadastraProdutoGatewayImpl
    ) {
        return new CadastraProdutoUseCaseImpl(cadastraProdutoGatewayImpl);
    }
}
