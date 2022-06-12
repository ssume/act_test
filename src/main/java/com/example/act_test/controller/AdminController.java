package com.example.act_test.controller;

import com.example.act_test.domain.entity.ProductEntity;
import com.example.act_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private ProductService productService;

    @PostMapping(value="/product/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity productEntity){
        return new ResponseEntity<ProductEntity>(productService.addProduct(productEntity), HttpStatus.OK);
    }

    @DeleteMapping(value="/product/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Long productId){
        return productService.deleteByProductId(productId) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
    }

    @PutMapping(value="/product/update")
    public ResponseEntity<ProductEntity> updateProduct(@RequestParam Long productId,@RequestBody ProductEntity productEntity) {
        productService.updateById(productId, productEntity);
        return new ResponseEntity<ProductEntity>(productEntity,HttpStatus.OK);
    }
}
