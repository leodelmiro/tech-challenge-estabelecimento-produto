package com.leodelmiro.produto.core.dataprovider.produto;

import com.leodelmiro.produto.core.domain.Produto;

public interface BuscaProdutoGateway {
    Produto buscar(Long id);
}
