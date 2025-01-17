package com.leodelmiro.produto.entrypoint.api.request;

import jakarta.validation.constraints.NotBlank;

public record CadastraProdutoImagemRequest(
        @NotBlank String nome,
        @NotBlank String url
) {
}
