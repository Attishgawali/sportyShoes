package com.sheryians.major.service;


import com.sheryians.major.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sheryians.major.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){ return productRepository.findAll();}
    public void addProduct(Product product){productRepository.save(product);}
    public void removeProductById(long id){productRepository.deleteById(id);}
    public Optional<Product> getProductById(long id){return productRepository.findById(id);}
    public List<Product> getProductByCategoryId(int id){
        return productRepository.findAllByCategory_Id(id);
    }
}