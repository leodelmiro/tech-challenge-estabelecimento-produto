package com.leodelmiro.produto.core.usecase.produto;

import com.leodelmiro.produto.core.domain.Produto;

public interface BuscaProdutoUseCase {
    Produto buscar(Long id);
}
