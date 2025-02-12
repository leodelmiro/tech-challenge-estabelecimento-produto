package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.CadastraProdutoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CadastraProdutoUseCaseImplTest {

    private CadastraProdutoGateway cadastraProdutoGateway;
    private CadastraProdutoUseCaseImpl cadastraProdutoUseCase;

    @BeforeEach
    void setUp() {
        cadastraProdutoGateway = mock(CadastraProdutoGateway.class);
        cadastraProdutoUseCase = new CadastraProdutoUseCaseImpl(cadastraProdutoGateway);
    }

    @Test
    void deveCadastrarProdutoComSucesso() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");

        when(cadastraProdutoGateway.cadastrar(produto)).thenReturn(produto);

        Produto produtoCadastrado = cadastraProdutoUseCase.cadastrar(produto);

        assertEquals(produto, produtoCadastrado);
        verify(cadastraProdutoGateway, times(1)).cadastrar(produto);
    }

    @Test
    void deveChamarGatewayComProdutoCorreto() {
        Produto produto = new Produto();
        produto.setId(2L);
        produto.setNome("Outro Produto");

        cadastraProdutoUseCase.cadastrar(produto);

        verify(cadastraProdutoGateway, times(1)).cadastrar(produto);
    }
}