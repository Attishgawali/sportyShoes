package com.sheryians.major.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private long id;
    private String name;
    private int categoryId;
    private double price;
    private String description;
    private String imageName;
}
