package com.leodelmiro.produto.core.dataprovider.produto;

import com.leodelmiro.produto.core.domain.Produto;

import java.util.Set;

public interface ListaProdutosGateway {
    Set<Produto> listarTodos();
    Set<Produto> listarPorLanches();
    Set<Produto> listarPorAcompanhamentos();
    Set<Produto> listarPorBebidas();
    Set<Produto> listarPorSobremesas();
}
