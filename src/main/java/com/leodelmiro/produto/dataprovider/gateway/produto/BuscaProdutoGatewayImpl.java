package com.leodelmiro.produto.dataprovider.gateway.produto;

import com.leodelmiro.produto.dataprovider.repository.ProdutoRepository;
import com.leodelmiro.produto.dataprovider.repository.entity.ProdutoEntity;
import com.leodelmiro.produto.dataprovider.repository.mapper.ProdutoEntityMapper;
import com.leodelmiro.produto.core.domain.Produto;
import com.leodelmiro.produto.core.dataprovider.produto.BuscaProdutoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BuscaProdutoGatewayImpl implements BuscaProdutoGateway {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    @Cacheable(cacheNames = "produto", key = "#id", unless = "#result == null")
    public Produto buscar(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return produtoEntityMapper.toProduto(produto);
    }
}
