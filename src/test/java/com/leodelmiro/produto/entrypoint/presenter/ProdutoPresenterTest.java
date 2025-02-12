package com.leodelmiro.produto.entrypoint.presenter;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.entrypoint.api.mapper.ProdutoMapper;
import com.leodelmiro.produto.entrypoint.api.response.ProdutoResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static utils.ProdutoApplicationUtilsTest.getProduto;
import static utils.ProdutoApplicationUtilsTest.getProdutoResponse;

class ProdutoPresenterTest {

    @Test
    void deveTransformarSetProdutosParaProdutoResponse() {
        Produto produto1 = getProduto(1L, "Produto 1", "Descrição 1");
        Produto produto2 = getProduto(2L, "Produto 2", "Descrição 2");

        ProdutoResponse produtoResponse1 = getProdutoResponse(10L);
        ProdutoResponse produtoResponse2 = getProdutoResponse(20L);

        Set<Produto> produtos = new HashSet<>();
        produtos.add(produto1);
        produtos.add(produto2);

        ProdutoMapper produtoMapper = mock(ProdutoMapper.class);
        when(produtoMapper.toProdutoResponse(produto1)).thenReturn(produtoResponse1);
        when(produtoMapper.toProdutoResponse(produto2)).thenReturn(produtoResponse2);

        Set<ProdutoResponse> produtoResponses = ProdutoPresenter.transformarSetProdutosParaProdutoResponse(produtos, produtoMapper);

        assertEquals(2, produtoResponses.size());
        assertEquals(Set.of(produtoResponse1, produtoResponse2), produtoResponses);

        verify(produtoMapper, times(1)).toProdutoResponse(produto1);
        verify(produtoMapper, times(1)).toProdutoResponse(produto2);
    }
}