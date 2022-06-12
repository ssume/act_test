package com.example.act_test.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="product")
@SequenceGenerator(name="SEQ_PRODUCT",sequenceName = "SEQ_PRODUCT_ID", initialValue = 1,allocationSize = 1)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @Column(name="product_id")
    private Long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private Long productPrice;

    @Column(name="product_regdate")
    private Date productRegdate;

    @Column(name="product_img1")
    private String productImg1;

    @Column(name="product_img2")
    private String productImg2;

    @Column(name="product_type")
    private String productType;
}
