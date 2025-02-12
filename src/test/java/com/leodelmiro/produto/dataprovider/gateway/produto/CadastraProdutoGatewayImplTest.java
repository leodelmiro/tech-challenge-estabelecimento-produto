package com.leodelmiro.produto.dataprovider.gateway.produto;

import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.dataprovider.repository.ProdutoRepository;
import com.leodelmiro.produto.dataprovider.repository.entity.ImagemEntity;
import com.leodelmiro.produto.dataprovider.repository.entity.ProdutoEntity;
import com.leodelmiro.produto.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CadastraProdutoGatewayImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoEntityMapper produtoEntityMapper;

    @InjectMocks
    private CadastraProdutoGatewayImpl cadastraProdutoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarProdutoComSucesso() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(1L);
        produtoEntity.setNome("Produto Teste");

        ImagemEntity imagemEntity = new ImagemEntity();
        imagemEntity.setId(1L);
        produtoEntity.setImagens(Set.of(imagemEntity));

        when(produtoEntityMapper.toProdutoEntity(produto)).thenReturn(produtoEntity);
        when(produtoRepository.save(produtoEntity)).thenReturn(produtoEntity);
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        Produto resultado = cadastraProdutoGateway.cadastrar(produto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Produto Teste", resultado.getNome());
        verify(produtoEntityMapper, times(1)).toProdutoEntity(produto);
        verify(produtoRepository, times(1)).save(produtoEntity);
        verify(produtoEntityMapper, times(1)).toProduto(produtoEntity);
    }

    @Test
    void deveConfigurarRelacaoBidirecionalEntreProdutoEImagens() {
        Produto produto = new Produto();
        produto.setId(1L);

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(1L);

        ImagemEntity imagemEntity = new ImagemEntity();
        imagemEntity.setId(1L);
        produtoEntity.setImagens(Set.of(imagemEntity));

        when(produtoEntityMapper.toProdutoEntity(produto)).thenReturn(produtoEntity);
        when(produtoRepository.save(produtoEntity)).thenReturn(produtoEntity);
        when(produtoEntityMapper.toProduto(produtoEntity)).thenReturn(produto);

        cadastraProdutoGateway.cadastrar(produto);

        assertEquals(produtoEntity, imagemEntity.getProduto());
        verify(produtoEntityMapper, times(1)).toProdutoEntity(produto);
        verify(produtoRepository, times(1)).save(produtoEntity);
    }
}