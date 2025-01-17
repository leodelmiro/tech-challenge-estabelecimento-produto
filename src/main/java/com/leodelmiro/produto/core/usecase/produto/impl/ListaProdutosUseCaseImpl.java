package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.ListaProdutosGateway;
import com.leodelmiro.produto.core.usecase.produto.ListaProdutosUseCase;

import java.util.Set;

public class ListaProdutosUseCaseImpl implements ListaProdutosUseCase {
    private final ListaProdutosGateway listaProdutosGateway;

    public ListaProdutosUseCaseImpl(ListaProdutosGateway listaProdutosGateway) {
        this.listaProdutosGateway = listaProdutosGateway;
    }

    @Override
    public Set<Produto> listarTodos() {
        return listaProdutosGateway.listarTodos();
    }

    @Override
    public Set<Produto> listarPorLanches() {
        return listaProdutosGateway.listarPorLanches();
    }

    @Override
    public Set<Produto> listarPorAcompanhamentos() {
        return listaProdutosGateway.listarPorAcompanhamentos();
    }

    @Override
    public Set<Produto> listarPorBebidas() {
        return listaProdutosGateway.listarPorBebidas();
    }

    @Override
    public Set<Produto> listarPorSobremesas() {
        return listaProdutosGateway.listarPorSobremesas();
    }
}
