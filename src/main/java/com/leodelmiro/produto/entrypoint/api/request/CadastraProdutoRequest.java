package com.leodelmiro.produto.entrypoint.api.request;

import com.leodelmiro.produto.core.domain.Categoria;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Set;

public record CadastraProdutoRequest(
        @NotBlank String nome,
        @NotNull Categoria categoria,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 10, fraction = 2)
        BigDecimal preco,
        @Min(0) @NotNull Long tempoDePreparoEmSegundos,
        @NotBlank String descricao,
        @NotNull Set<CadastraProdutoImagemRequest> imagens
) {
}
