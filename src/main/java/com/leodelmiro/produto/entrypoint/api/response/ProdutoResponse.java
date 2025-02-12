package com.leodelmiro.produto.entrypoint.api.response;

import com.leodelmiro.produto.core.domain.Categoria;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProdutoResponse(
        Long id,
        String nome,
        Categoria categoria,
        BigDecimal preco,
        String descricao,
        Long tempoDePreparoEmSegundos,
        LocalDateTime criadoEm,
        Set<ImagemResponse> imagens
) {
}
