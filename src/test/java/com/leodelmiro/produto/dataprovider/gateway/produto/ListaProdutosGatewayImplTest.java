package com.leodelmiro.produto.dataprovider.gateway.produto;

import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.dataprovider.repository.ProdutoRepository;
import com.leodelmiro.produto.dataprovider.repository.entity.ProdutoEntity;
import com.leodelmiro.produto.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListaProdutosGatewayImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoEntityMapper produtoEntityMapper;

    @InjectMocks
    private ListaProdutosGatewayImpl listaProdutosGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveListarTodosOsProdutos() {
        ProdutoEntity produtoEntity1 = new ProdutoEntity();
        ProdutoEntity produtoEntity2 = new ProdutoEntity();
        Produto produto1 = new Produto(1L,
                "Produto 1",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                "Bebida Teste",
                1L,
                LocalDateTime.now());
        Produto produto2 = new Produto(2L,
                "Produto 2",
                Categoria.LANCHE,
                BigDecimal.ONE,
                "Lanche Teste",
                1L,
                LocalDateTime.now());

        when(produtoRepository.findAll()).thenReturn(List.of(produtoEntity1, produtoEntity2));
        when(produtoEntityMapper.toProduto(produtoEntity1)).thenReturn(produto1);
        when(produtoEntityMapper.toProduto(produtoEntity2)).thenReturn(produto2);

        Set<Produto> produtos = listaProdutosGateway.listarTodos();

        assertEquals(Set.of(produto1, produto2), produtos);
        verify(produtoRepository, times(1)).findAll();
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity1);
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity2);
    }

    @Test
    void deveListarProdutosPorLanches() {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        Produto produto = new Produto(1L,
                "Lanche 1",
                Categoria.LANCHE,
                BigDecimal.ONE,
                "Lanche Teste",
                1L,
                LocalDateTime.now());

        when(produtoRepository.listarPorLanches()).thenReturn(List.of(produtoEntity));
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Set<Produto> lanches = listaProdutosGateway.listarPorLanches();

        assertEquals(Set.of(produto), lanches);
        verify(produtoRepository, times(1)).listarPorLanches();
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }

    @Test
    void deveListarProdutosPorAcompanhamentos() {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        Produto produto = new Produto(1L,
                "Acompanhamento 1",
                Categoria.ACOMPANHAMENTO,
                BigDecimal.ONE,
                "Acompanhamento Teste",
                1L,
                LocalDateTime.now()
        );

        when(produtoRepository.listarPorAcompanhamentos()).thenReturn(List.of(produtoEntity));
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Set<Produto> acompanhamentos = listaProdutosGateway.listarPorAcompanhamentos();

        assertEquals(Set.of(produto), acompanhamentos);
        verify(produtoRepository, times(1)).listarPorAcompanhamentos();
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }

    @Test
    void deveListarProdutosPorBebidas() {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        Produto produto = new Produto(1L,
                "Bebida 1",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                "Bebida Teste",
                1L,
                LocalDateTime.now());

        when(produtoRepository.listarPorBebidas()).thenReturn(List.of(produtoEntity));
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Set<Produto> bebidas = listaProdutosGateway.listarPorBebidas();

        assertEquals(Set.of(produto), bebidas);
        verify(produtoRepository, times(1)).listarPorBebidas();
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }

    @Test
    void deveListarProdutosPorSobremesas() {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        Produto produto = new Produto(1L, "Sobremesa 1",
                Categoria.SOBREMESA,
                BigDecimal.ONE,
                "Sobremesa Teste",
                1L,
                LocalDateTime.now()
        );

        when(produtoRepository.listarPorSobremesas()).thenReturn(List.of(produtoEntity));
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Set<Produto> sobremesas = listaProdutosGateway.listarPorSobremesas();

        assertEquals(Set.of(produto), sobremesas);
        verify(produtoRepository, times(1)).listarPorSobremesas();
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }
}