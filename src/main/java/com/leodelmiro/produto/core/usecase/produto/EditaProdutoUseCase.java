package com.leodelmiro.produto.core.usecase.produto;

import com.leodelmiro.produto.core.domain.Produto;

public interface EditaProdutoUseCase {
    Produto editar(Produto produto, Long id);
}
