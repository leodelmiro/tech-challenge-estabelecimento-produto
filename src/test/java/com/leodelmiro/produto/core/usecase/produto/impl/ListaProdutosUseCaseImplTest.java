package com.leodelmiro.produto.core.usecase.produto.impl;

import com.leodelmiro.produto.core.dataprovider.produto.ListaProdutosGateway;
import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.core.domain.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListaProdutosUseCaseImplTest {

    private ListaProdutosGateway listaProdutosGateway;
    private ListaProdutosUseCaseImpl listaProdutosUseCase;

    @BeforeEach
    void setUp() {
        listaProdutosGateway = mock(ListaProdutosGateway.class);
        listaProdutosUseCase = new ListaProdutosUseCaseImpl(listaProdutosGateway);
    }

    @Test
    void deveListarTodosOsProdutos() {
        Set<Produto> produtos = Set.of(new Produto(1L,
                "Produto 1",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                "Bebida Teste",
                1L,
                LocalDateTime.now()), new Produto(2L,
                "Produto 2",
                Categoria.LANCHE,
                BigDecimal.ONE,
                "Lanche Teste",
                1L,
                LocalDateTime.now()));
        when(listaProdutosGateway.listarTodos()).thenReturn(produtos);

        Set<Produto> resultado = listaProdutosUseCase.listarTodos();

        assertEquals(produtos, resultado);
        verify(listaProdutosGateway, times(1)).listarTodos();
    }

    @Test
    void deveListarProdutosPorLanches() {
        Set<Produto> lanches = Set.of(new Produto(1L, "Lanche 1",
                Categoria.LANCHE,
                BigDecimal.ONE,
                "Lanche Teste",
                1L,
                LocalDateTime.now()), new Produto(2L, "Lanche 2",
                Categoria.LANCHE,
                BigDecimal.ONE,
                "Lanche Teste 2",
                1L,
                LocalDateTime.now()));
        when(listaProdutosGateway.listarPorLanches()).thenReturn(lanches);

        Set<Produto> resultado = listaProdutosUseCase.listarPorLanches();

        assertEquals(lanches, resultado);
        verify(listaProdutosGateway, times(1)).listarPorLanches();
    }

    @Test
    void deveListarProdutosPorAcompanhamentos() {
        Set<Produto> acompanhamentos = Set.of(new Produto(1L,
                        "Acompanhamento 1",
                        Categoria.ACOMPANHAMENTO,
                        BigDecimal.ONE,
                        "Acompanhamento Teste",
                        1L,
                        LocalDateTime.now()
                )
        );
        when(listaProdutosGateway.listarPorAcompanhamentos()).thenReturn(acompanhamentos);

        Set<Produto> resultado = listaProdutosUseCase.listarPorAcompanhamentos();

        assertEquals(acompanhamentos, resultado);
        verify(listaProdutosGateway, times(1)).listarPorAcompanhamentos();
    }

    @Test
    void deveListarProdutosPorBebidas() {
        Set<Produto> bebidas = Set.of(
                new Produto(1L,
                        "Bebida 1",
                        Categoria.BEBIDA,
                        BigDecimal.ONE,
                        "Bebida Teste",
                        1L,
                        LocalDateTime.now()),
                new Produto(2L,
                        "Bebida 2",
                        Categoria.BEBIDA,
                        BigDecimal.ONE,
                        "Bebida Teste 2",
                        1L,
                        LocalDateTime.now()
                )
        );
        when(listaProdutosGateway.listarPorBebidas()).thenReturn(bebidas);

        Set<Produto> resultado = listaProdutosUseCase.listarPorBebidas();

        assertEquals(bebidas, resultado);
        verify(listaProdutosGateway, times(1)).listarPorBebidas();
    }

    @Test
    void deveListarProdutosPorSobremesas() {
        Set<Produto> sobremesas = Set.of(
                new Produto(1L, "Sobremesa 1",
                        Categoria.SOBREMESA,
                        BigDecimal.ONE,
                        "Sobremesa Teste",
                        1L,
                        LocalDateTime.now()
                )
        );
        when(listaProdutosGateway.listarPorSobremesas()).thenReturn(sobremesas);

        Set<Produto> resultado = listaProdutosUseCase.listarPorSobremesas();

        assertEquals(sobremesas, resultado);
        verify(listaProdutosGateway, times(1)).listarPorSobremesas();
    }
}