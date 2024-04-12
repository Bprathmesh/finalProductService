package com.pb.productservicesst.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductNotFoundException extends RuntimeException{
//    here to make this class as exception simply we will extend it
    private Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }

}
