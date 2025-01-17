package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.CadastraProdutoGateway;
import com.leodelmiro.produto.core.usecase.produto.CadastraProdutoUseCase;

public class CadastraProdutoUseCaseImpl implements CadastraProdutoUseCase {

    private final CadastraProdutoGateway cadastraProdutoGateway;

    public CadastraProdutoUseCaseImpl(CadastraProdutoGateway cadastraProdutoGateway) {
        this.cadastraProdutoGateway = cadastraProdutoGateway;
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return cadastraProdutoGateway.cadastrar(produto);
    }
}
