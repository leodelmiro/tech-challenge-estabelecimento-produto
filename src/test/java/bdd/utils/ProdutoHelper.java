package bdd.utils;

import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.entrypoint.api.request.CadastraProdutoRequest;

import java.math.BigDecimal;
import java.util.Set;

public abstract class ProdutoHelper {
    public static CadastraProdutoRequest gerarCadastraProdutoRequest(Categoria categoria) {
        return new CadastraProdutoRequest(
                "Teste",
                categoria == null ? Categoria.LANCHE : categoria,
                BigDecimal.TEN,
                100L,
                "Testando Produto",
                Set.of()
        );
    }
}
