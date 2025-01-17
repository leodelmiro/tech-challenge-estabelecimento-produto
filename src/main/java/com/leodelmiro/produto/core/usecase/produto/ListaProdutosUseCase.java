package com.leodelmiro.produto.core.usecase.produto;

import com.leodelmiro.produto.core.domain.Produto;

import java.util.Set;

public interface ListaProdutosUseCase {
    Set<Produto> listarTodos();
    Set<Produto> listarPorLanches();
    Set<Produto> listarPorAcompanhamentos();
    Set<Produto> listarPorBebidas();
    Set<Produto> listarPorSobremesas();
}
