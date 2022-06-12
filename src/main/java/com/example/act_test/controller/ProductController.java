package com.example.act_test.controller;

import com.example.act_test.domain.entity.ProductEntity;
import com.example.act_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value="/all")
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        List<ProductEntity> product = productService.findAll();
        return new ResponseEntity<List<ProductEntity>>(product, HttpStatus.OK);
    }

    @GetMapping(value="/get")
    public ResponseEntity<List<ProductEntity>> getProduct(@RequestParam Long productId){
        List<ProductEntity> product = productService.findByProductId(productId);
        return new ResponseEntity<List<ProductEntity>>(product, HttpStatus.OK);
    }

}
