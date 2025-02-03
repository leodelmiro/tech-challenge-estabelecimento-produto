package com.leodelmiro.produto.entrypoint.controller;

import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.usecase.produto.*;
import com.leodelmiro.produto.entrypoint.api.mapper.ProdutoMapper;
import com.leodelmiro.produto.entrypoint.api.request.CadastraProdutoRequest;
import com.leodelmiro.produto.entrypoint.api.request.EditaProdutoRequest;
import com.leodelmiro.produto.entrypoint.api.response.ProdutoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.ProdutoApplicationUtilsTest.getProduto;
import static utils.ProdutoApplicationUtilsTest.getProdutoResponse;

class ProdutoControllerTest {

    private CadastraProdutoUseCase cadastraProdutoUseCase;
    private RemoveProdutoUseCase removeProdutoUseCase;
    private BuscaProdutoUseCase buscaProdutoUseCase;
    private ListaProdutosUseCase listaProdutosUseCase;
    private EditaProdutoUseCase editaProdutoUseCase;
    private ProdutoMapper produtoMapper;

    @BeforeEach
    void setUp() {
        cadastraProdutoUseCase = Mockito.mock(CadastraProdutoUseCase.class);
        removeProdutoUseCase = Mockito.mock(RemoveProdutoUseCase.class);
        buscaProdutoUseCase = Mockito.mock(BuscaProdutoUseCase.class);
        listaProdutosUseCase = Mockito.mock(ListaProdutosUseCase.class);
        editaProdutoUseCase = Mockito.mock(EditaProdutoUseCase.class);
        produtoMapper = Mockito.mock(ProdutoMapper.class);
    }

    @Test
    void deveCadastrarProduto() {
        CadastraProdutoRequest request = new CadastraProdutoRequest("Produto Teste",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                10L,
                "Descrição Teste",
                Set.of());
        Produto produto = getProduto(1L, "Produto 1", "Descrição 1");
        ProdutoResponse response = getProdutoResponse(10L);

        Mockito.when(produtoMapper.toProduto(request)).thenReturn(produto);
        Mockito.when(cadastraProdutoUseCase.cadastrar(produto)).thenReturn(produto);
        Mockito.when(produtoMapper.toProdutoResponse(produto)).thenReturn(response);

        ProdutoResponse result = ProdutoController.cadastrar(request, cadastraProdutoUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals("Produto Teste", result.nome());
        assertEquals(BigDecimal.ONE, result.preco());
    }

    @Test
    void deveBuscarProdutoPorId() {
        Produto produto = getProduto(1L, "Produto 1", "Descrição 1");
        ProdutoResponse response = getProdutoResponse(10L);

        Mockito.when(buscaProdutoUseCase.buscar(1L)).thenReturn(produto);
        Mockito.when(produtoMapper.toProdutoResponse(produto)).thenReturn(response);

        ProdutoResponse result = ProdutoController.buscar(1L, buscaProdutoUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals("Produto Teste", result.nome());
        assertEquals(BigDecimal.ONE, result.preco());
    }

    @Test
    void deveListarTodosProdutos() {
        Set<Produto> produtos = Set.of(
                getProduto(1L, "Produto 1", "Descrição 1")
        );

        Mockito.when(listaProdutosUseCase.listarTodos()).thenReturn(produtos);

        Set<ProdutoResponse> result = ProdutoController.listarTodos(listaProdutosUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void deveListarLanches() {
        Set<Produto> produtos = Set.of(
                new Produto(1L,
                        "Produto_Teste",
                        Categoria.LANCHE,
                        BigDecimal.ONE,
                        "Descrição_Teste",
                        1L,
                        LocalDateTime.now()));

        Mockito.when(listaProdutosUseCase.listarPorLanches()).thenReturn(produtos);

        Set<ProdutoResponse> result = ProdutoController.listarLanches(listaProdutosUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void deveListarAcompanhamentos() {
        Set<Produto> produtos = Set.of(
                new Produto(1L,
                        "Produto_Teste",
                        Categoria.ACOMPANHAMENTO,
                        BigDecimal.ONE,
                        "Descrição_Teste",
                        1L,
                        LocalDateTime.now()));

        Mockito.when(listaProdutosUseCase.listarPorAcompanhamentos()).thenReturn(produtos);

        Set<ProdutoResponse> result = ProdutoController.listarAcompanhamentos(listaProdutosUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void deveListarBebidas() {
        Set<Produto> produtos = Set.of(
                new Produto(1L,
                        "Produto_Teste",
                        Categoria.BEBIDA,
                        BigDecimal.ONE,
                        "Descrição_Teste",
                        1L,
                        LocalDateTime.now()));

        Mockito.when(listaProdutosUseCase.listarPorBebidas()).thenReturn(produtos);

        Set<ProdutoResponse> result = ProdutoController.listarBebidas(listaProdutosUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void deveListarSobremesas() {
        Set<Produto> produtos = Set.of(
                new Produto(1L,
                        "Produto_Teste",
                        Categoria.SOBREMESA,
                        BigDecimal.ONE,
                        "Descrição_Teste",
                        1L,
                        LocalDateTime.now()));

        Mockito.when(listaProdutosUseCase.listarPorSobremesas()).thenReturn(produtos);

        Set<ProdutoResponse> result = ProdutoController.listarSobremesas(listaProdutosUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void deveEditarProduto() {
        EditaProdutoRequest request = new EditaProdutoRequest("Produto Editado", null, null, null, null, null);
        Produto produto = getProduto(1L, "Produto 1", "Descrição 1");
        ProdutoResponse response = new ProdutoResponse(1L,
                "Produto Editado",
                BigDecimal.ONE,
                "Descrição Teste",
                10L,
                LocalDateTime.now(),
                Set.of());
        ;

        Mockito.when(produtoMapper.toProduto(request)).thenReturn(produto);
        Mockito.when(editaProdutoUseCase.editar(produto, 1L)).thenReturn(produto);
        Mockito.when(produtoMapper.toProdutoResponse(produto)).thenReturn(response);

        ProdutoResponse result = ProdutoController.editar(1L, request, editaProdutoUseCase, produtoMapper);

        assertNotNull(result);
        assertEquals("Produto Editado", result.nome());
        assertEquals(BigDecimal.ONE, result.preco());
    }

    @Test
    void deveRemoverProduto() {
        ProdutoController.remover(1L, removeProdutoUseCase);

        Mockito.verify(removeProdutoUseCase, Mockito.times(1)).remover(1L);
    }
}