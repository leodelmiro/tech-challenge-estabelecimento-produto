package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.BuscaProdutoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BuscaProdutoUseCaseImplTest {

    private BuscaProdutoGateway buscaProdutoGateway;
    private BuscaProdutoUseCaseImpl buscaProdutoUseCase;

    @BeforeEach
    void setUp() {
        buscaProdutoGateway = mock(BuscaProdutoGateway.class);
        buscaProdutoUseCase = new BuscaProdutoUseCaseImpl(buscaProdutoGateway);
    }

    @Test
    void deveRetornarProdutoQuandoBuscarPorId() {
        Long id = 1L;
        Produto produtoEsperado = new Produto();
        produtoEsperado.setId(id);
        produtoEsperado.setNome("Produto Teste");

        when(buscaProdutoGateway.buscar(id)).thenReturn(produtoEsperado);

        Produto produtoRetornado = buscaProdutoUseCase.buscar(id);

        assertEquals(produtoEsperado, produtoRetornado);
        verify(buscaProdutoGateway, times(1)).buscar(id);
    }

    @Test
    void deveChamarGatewayComIdCorreto() {
        Long id = 2L;

        buscaProdutoUseCase.buscar(id);

        verify(buscaProdutoGateway, times(1)).buscar(id);
    }
}