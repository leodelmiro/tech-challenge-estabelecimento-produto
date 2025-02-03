package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.dataprovider.produto.RemoveProdutoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RemoveProdutoUseCaseImplTest {

    private RemoveProdutoGateway removeProdutoGateway;
    private RemoveProdutoUseCaseImpl removeProdutoUseCase;

    @BeforeEach
    void setUp() {
        removeProdutoGateway = mock(RemoveProdutoGateway.class);
        removeProdutoUseCase = new RemoveProdutoUseCaseImpl(removeProdutoGateway);
    }

    @Test
    void deveRemoverProdutoPorId() {
        Long id = 1L;

        removeProdutoUseCase.remover(id);

        verify(removeProdutoGateway, times(1)).remover(id);
    }
}