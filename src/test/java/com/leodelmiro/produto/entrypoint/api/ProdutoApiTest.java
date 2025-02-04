package com.leodelmiro.produto.entrypoint.api;

import com.leodelmiro.produto.core.domain.Categoria;
import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.usecase.produto.*;
import com.leodelmiro.produto.entrypoint.api.mapper.ProdutoMapper;
import com.leodelmiro.produto.entrypoint.api.request.CadastraProdutoRequest;
import com.leodelmiro.produto.entrypoint.api.request.EditaProdutoRequest;
import com.leodelmiro.produto.entrypoint.api.response.ProdutoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static utils.ProdutoApplicationUtilsTest.getProduto;
import static utils.ProdutoApplicationUtilsTest.getProdutoResponse;


class ProdutoApiTest {

    @Mock
    private CadastraProdutoUseCase cadastraProdutoUseCase;
    @Mock
    private RemoveProdutoUseCase removeProdutoUseCase;
    @Mock
    private BuscaProdutoUseCase buscaProdutoUseCase;
    @Mock
    private ListaProdutosUseCase listaProdutosUseCase;
    @Mock
    private EditaProdutoUseCase editaProdutoUseCase;
    @Mock
    private ProdutoMapper produtoMapper;

    @InjectMocks
    private ProdutoApi produtoApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockRequest));
    }

    @Test
    void deveCadastrarProduto() {
        when(cadastraProdutoUseCase.cadastrar(any())).thenReturn(getProduto(1L, "Produto 1", "Descrição 1"));
        when(produtoMapper.toProdutoResponse(any())).thenReturn(getProdutoResponse(10L ));

        CadastraProdutoRequest request = new CadastraProdutoRequest("Produto Teste",
                Categoria.BEBIDA,
                BigDecimal.ONE,
                1L,
                "Descrição Teste",
                Set.of()
        );
        ResponseEntity<ProdutoResponse> result = produtoApi.cadastrar(request);

        assertEquals(201, result.getStatusCode().value());
        Assertions.assertNotNull(result.getBody());
        assertEquals("Produto Teste", result.getBody().nome());
    }

    @Test
    void deveBuscarProdutoPorId() {
        Produto produto = getProduto(1L, "Produto Teste", "Descrição Teste");
        ProdutoResponse response = getProdutoResponse(10L);

        when(buscaProdutoUseCase.buscar(1L)).thenReturn(produto);
        when(produtoMapper.toProdutoResponse(any())).thenReturn(response);

        ResponseEntity<ProdutoResponse> result = produtoApi.buscar(1L);

        assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(result.getBody());
        assertEquals("Produto Teste", result.getBody().nome());
    }

    @Test
    void deveListarTodosProdutos() {
        Set<Produto> produtos = Set.of(
                getProduto(1L, "Produto Teste", "Descrição Teste")
        );

        when(listaProdutosUseCase.listarTodos()).thenReturn(produtos);

        ResponseEntity<Set<ProdutoResponse>> result = produtoApi.listarTodos();

        assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(result.getBody());
        assertEquals(1, result.getBody().size());
    }

    @Test
    void deveEditarProduto() {
        EditaProdutoRequest request = new EditaProdutoRequest("Produto Editado", null, null, null, null, null);
        Produto produto = getProduto(1L, "Produto Teste", "Descrição Teste");
        ProdutoResponse response = getProdutoResponse(1L);

        when(editaProdutoUseCase.editar(any(), eq(1L))).thenReturn(produto);
        when(produtoMapper.toProdutoResponse(any())).thenReturn(response);

        ResponseEntity<ProdutoResponse> result = produtoApi.editar(1L, request);

        assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(result.getBody());
        assertEquals("Produto Teste", result.getBody().nome());
    }

    @Test
    void deveRemoverProduto() {
        ResponseEntity<Void> result = produtoApi.remover(1L);

        Mockito.verify(removeProdutoUseCase, Mockito.times(1)).remover(1L);
        assertEquals(204, result.getStatusCode().value());
    }
}