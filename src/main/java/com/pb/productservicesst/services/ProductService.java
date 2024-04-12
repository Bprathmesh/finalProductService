package com.pb.productservicesst.services;

import com.pb.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
//    interface should dbe as general as possible
    Product getProductById (Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);


}
