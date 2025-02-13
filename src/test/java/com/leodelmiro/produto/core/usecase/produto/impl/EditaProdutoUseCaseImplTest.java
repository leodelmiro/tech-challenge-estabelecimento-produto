package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.EditaProdutoGateway;
import com.leodelmiro.produto.core.usecase.produto.BuscaProdutoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EditaProdutoUseCaseImplTest {

    private EditaProdutoGateway editaProdutoGateway;
    private BuscaProdutoUseCase buscaProdutoUseCase;
    private EditaProdutoUseCaseImpl editaProdutoUseCase;

    @BeforeEach
    void setUp() {
        editaProdutoGateway = mock(EditaProdutoGateway.class);
        buscaProdutoUseCase = mock(BuscaProdutoUseCase.class);
        editaProdutoUseCase = new EditaProdutoUseCaseImpl(editaProdutoGateway, buscaProdutoUseCase);
    }

    @Test
    void deveEditarProdutoComSucesso() {
        Long id = 1L;
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome("Produto Atualizado");

        Produto produtoExistente = new Produto();
        produtoExistente.setId(id);
        produtoExistente.setNome("Produto Antigo");

        when(buscaProdutoUseCase.buscar(id)).thenReturn(produtoExistente);
        when(editaProdutoGateway.editar(produto, id)).thenReturn(produto);

        Produto produtoEditado = editaProdutoUseCase.editar(produto, id);

        assertEquals(produto, produtoEditado);
        verify(buscaProdutoUseCase, times(1)).buscar(id);
        verify(editaProdutoGateway, times(1)).editar(produto, id);
    }

    @Test
    void deveChamarBuscaEEdicaoComOsParametrosCorretos() {
        Long id = 2L;
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome("Produto Teste");

        Produto produtoExistente = new Produto();
        produtoExistente.setId(id);
        produtoExistente.setNome("Produto Original");

        when(buscaProdutoUseCase.buscar(id)).thenReturn(produtoExistente);

        editaProdutoUseCase.editar(produto, id);

        verify(buscaProdutoUseCase, times(1)).buscar(id);
        verify(editaProdutoGateway, times(1)).editar(produto, id);
    }
}