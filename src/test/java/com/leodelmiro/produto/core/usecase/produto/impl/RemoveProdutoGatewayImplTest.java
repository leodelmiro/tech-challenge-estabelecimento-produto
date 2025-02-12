package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.dataprovider.gateway.produto.RemoveProdutoGatewayImpl;
import com.leodelmiro.produto.dataprovider.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RemoveProdutoGatewayImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private RemoveProdutoGatewayImpl removeProdutoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRemoverProdutoPorId() {
        Long id = 1L;

        removeProdutoGateway.remover(id);

        verify(produtoRepository, times(1)).deleteById(id);
    }
}