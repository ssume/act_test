package com.example.act_test.repository;

import com.example.act_test.domain.entity.ProductEntity;
import com.example.act_test.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByProductId(Long productId);

    @Transactional
    public Long deleteByProductId(Long productId);


}
