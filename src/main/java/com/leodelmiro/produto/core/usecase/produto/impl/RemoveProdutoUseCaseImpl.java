package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.dataprovider.produto.RemoveProdutoGateway;
import com.leodelmiro.produto.core.usecase.produto.RemoveProdutoUseCase;

public class RemoveProdutoUseCaseImpl implements RemoveProdutoUseCase {

    private final RemoveProdutoGateway removeProdutoGateway;

    public RemoveProdutoUseCaseImpl(RemoveProdutoGateway removeProdutoGateway) {
        this.removeProdutoGateway = removeProdutoGateway;
    }

    @Override
    public void remover(Long id) {
        removeProdutoGateway.remover(id);
    }
}
