package com.leodelmiro.produto.core.dataprovider.produto;

import com.leodelmiro.produto.core.domain.Produto;

public interface EditaProdutoGateway {
    Produto editar(Produto produto, Long id);
}
