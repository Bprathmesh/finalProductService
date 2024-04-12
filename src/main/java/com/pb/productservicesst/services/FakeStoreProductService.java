package com.pb.productservicesst.services;

import com.pb.productservicesst.dtos.FakeStoreProductDto;
import com.pb.productservicesst.exceptions.ProductNotFoundException;
import com.pb.productservicesst.models.Category;
import com.pb.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service //tells spring to initialise object
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        //chef business logic call fake store to get product with given id
//        throw new RuntimeException("Service not up");
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto=
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException(id,"Please pass valid Product id");
        }
//        Convert Fake Store Dto Object to Product object


        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
    public List<Product> getAllProducts(){
    RestTemplate restTemplate=new RestTemplate();
    FakeStoreProductDto[] fakeStoreProductDtos=
            restTemplate.getForObject("https://fakestoreapi.com/products",
                    FakeStoreProductDto[].class);

    List<Product> products=new ArrayList<>();
    for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
        products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }
    return  products;

    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle((fakeStoreProductDto.getTitle()));
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;


    }

}
