package com.leodelmiro.produto.config.produto;

import com.leodelmiro.produto.dataprovider.gateway.produto.RemoveProdutoGatewayImpl;
import com.leodelmiro.produto.core.usecase.produto.impl.RemoveProdutoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RemoveProdutoConfig {

    @Bean
    public RemoveProdutoUseCaseImpl removeProdutoUseCase(
            RemoveProdutoGatewayImpl removeProdutoGatewayImpl
    ) {
        return new RemoveProdutoUseCaseImpl(removeProdutoGatewayImpl);
    }
}
