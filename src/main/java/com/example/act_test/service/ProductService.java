package com.example.act_test.service;

import com.example.act_test.domain.entity.ProductEntity;
import com.example.act_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAll() {
        List<ProductEntity> product = new ArrayList<>();
        productRepository.findAll().forEach(e -> product.add(e));
        return product;
    }

    public List<ProductEntity> findByProductId(Long productId){
        List<ProductEntity> product = new ArrayList<>();
        productRepository.findByProductId(productId).forEach(e -> product.add(e));
        return product;
    }

    public ProductEntity addProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
        return productEntity;
    }

    public Long deleteByProductId(Long productId){
        return productRepository.deleteByProductId(productId);
    }

    public void updateById(Long productId, ProductEntity productEntity){
        Optional<ProductEntity> product = productRepository.findById(productId);
        if(product.isPresent()){
            product.get().setProductName(productEntity.getProductName());
            product.get().setProductPrice(productEntity.getProductPrice());
            productRepository.save(product.get());
        }
    }
}
