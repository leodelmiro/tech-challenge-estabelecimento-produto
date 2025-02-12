package com.leodelmiro.produto.dataprovider.gateway.produto;

import com.leodelmiro.produto.dataprovider.repository.ProdutoRepository;
import com.leodelmiro.produto.dataprovider.repository.entity.ProdutoEntity;
import com.leodelmiro.produto.dataprovider.repository.mapper.ProdutoEntityMapper;
import com.leodelmiro.produto.core.domain.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscaProdutoGatewayImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoEntityMapper produtoEntityMapper;

    @InjectMocks
    private BuscaProdutoGatewayImpl buscaProdutoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarProdutoPorIdComSucesso() {
        Long id = 1L;
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(id);
        produtoEntity.setNome("Produto Teste");

        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome("Produto Teste");

        when(produtoRepository.findById(id)).thenReturn(Optional.of(produtoEntity));
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Produto resultado = buscaProdutoGateway.buscar(id);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Produto Teste", resultado.getNome());
        verify(produtoRepository, times(1)).findById(id);
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoForEncontrado() {
        Long id = 1L;
        when(produtoRepository.findById(id)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> buscaProdutoGateway.buscar(id));
        assertEquals("Produto não encontrado", exception.getMessage());
        verify(produtoRepository, times(1)).findById(id);
        verifyNoInteractions(produtoEntityMapper);
    }
}