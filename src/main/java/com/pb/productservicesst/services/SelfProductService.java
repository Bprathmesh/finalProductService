package com.pb.productservicesst.services;

import com.pb.productservicesst.exceptions.ProductNotFoundException;
import com.pb.productservicesst.models.Product;
import com.pb.productservicesst.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class SelfProductService implements  ProductService{
//    private ProductRepository productRepository=new ProductRepository(); if we create object of any service like this manually we have to create n diff objects take a lot of space because what if we want to change so we use dependancy injection
    private final ProductRepository  productRepository;
    SelfProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id,"Product not found");
        }
        Product product=optionalProduct.get();

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
