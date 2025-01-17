package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.EditaProdutoGateway;
import com.leodelmiro.produto.core.usecase.produto.BuscaProdutoUseCase;
import com.leodelmiro.produto.core.usecase.produto.EditaProdutoUseCase;

public class EditaProdutoUseCaseImpl implements EditaProdutoUseCase {

    private final EditaProdutoGateway editaProdutoGateway;
    private final BuscaProdutoUseCase buscaProdutoUseCase;

    public EditaProdutoUseCaseImpl(EditaProdutoGateway editaProdutoGateway,
                                   BuscaProdutoUseCase buscaProdutoUseCase) {
        this.editaProdutoGateway = editaProdutoGateway;
        this.buscaProdutoUseCase = buscaProdutoUseCase;
    }

    @Override
    public Produto editar(Produto produto, Long id) {
        buscaProdutoUseCase.buscar(id);
        return editaProdutoGateway.editar(produto, id);
    }
}
