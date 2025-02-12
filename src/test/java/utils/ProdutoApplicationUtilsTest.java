package utils;

import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.entrypoint.api.response.ProdutoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class ProdutoApplicationUtilsTest {
    public static Produto getProduto(long id, String Produto_Teste, String Descrição_Teste) {
        return new Produto(id,
                Produto_Teste,
                Categoria.BEBIDA,
                BigDecimal.ONE,
                Descrição_Teste,
                1L,
                LocalDateTime.now());
    }

    public static Produto getLanche(long id, String Produto_Teste, String Descrição_Teste) {
        return new Produto(id,
                Produto_Teste,
                Categoria.LANCHE,
                BigDecimal.ONE,
                Descrição_Teste,
                1L,
                LocalDateTime.now());
    }

    public static Produto getBebida(long id, String Produto_Teste, String Descrição_Teste) {
        return new Produto(id,
                Produto_Teste,
                Categoria.BEBIDA,
                BigDecimal.ONE,
                Descrição_Teste,
                1L,
                LocalDateTime.now());
    }

    public static Produto getAcompanhamento(long id, String Produto_Teste, String Descrição_Teste) {
        return new Produto(id,
                Produto_Teste,
                Categoria.ACOMPANHAMENTO,
                BigDecimal.ONE,
                Descrição_Teste,
                1L,
                LocalDateTime.now());
    }

    public static Produto getSobremesa(long id, String Produto_Teste, String Descrição_Teste) {
        return new Produto(id,
                Produto_Teste,
                Categoria.SOBREMESA,
                BigDecimal.ONE,
                Descrição_Teste,
                1L,
                LocalDateTime.now());
    }

    public static ProdutoResponse getProdutoResponse(long tempoDePreparoEmSegundos) {
        return new ProdutoResponse(1L,
                "Produto Teste",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                "Descrição Teste",
                tempoDePreparoEmSegundos,
                LocalDateTime.now(),
                Set.of());
    }
}
