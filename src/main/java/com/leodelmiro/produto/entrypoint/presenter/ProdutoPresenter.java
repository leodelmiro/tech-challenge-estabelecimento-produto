package com.leodelmiro.produto.entrypoint.presenter;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.entrypoint.api.mapper.ProdutoMapper;
import com.leodelmiro.produto.entrypoint.api.response.ProdutoResponse;

import java.util.Set;
import java.util.stream.Collectors;

public class ProdutoPresenter {
    public static Set<ProdutoResponse> transformarSetProdutosParaProdutoResponse(Set<Produto> produtos,
                                                                                 ProdutoMapper produtoMapper) {
        return produtos.stream()
                .map(produtoMapper::toProdutoResponse)
                .collect(Collectors.toSet()
                );
    }
}
