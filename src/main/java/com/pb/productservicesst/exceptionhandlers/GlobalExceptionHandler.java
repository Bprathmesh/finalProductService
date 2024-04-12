package com.pb.productservicesst.exceptionhandlers;

import com.pb.productservicesst.dtos.ExceptionDtos;
import com.pb.productservicesst.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDtos> handleArithmeticException(){
         ExceptionDtos dto=new ExceptionDtos();
         dto.setMessage("Something went wrong");
         dto.setResolution("ArithmeticException");
         ResponseEntity<ExceptionDtos> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return  response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDtos> handleArrayIndexOutOfBoundsException (){
        ExceptionDtos dto=new ExceptionDtos();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDtos> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return  response;
    }

//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public ResponseEntity<ExceptionDtos> handleGeneralException (){
//        ExceptionDtos dto=new ExceptionDtos();
//        dto.setMessage("Something went wrong");
//        dto.setResolution("Exception");
//        ResponseEntity<ExceptionDtos> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//        return  response;
//    }
@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<ExceptionDtos> handleProductNotFoundException (ProductNotFoundException productNotFoundException){
    ExceptionDtos dto=new ExceptionDtos();
    dto.setMessage("Invalid product id "+productNotFoundException.getId()+" passed");
    dto.setResolution("Product not found exception");
    ResponseEntity<ExceptionDtos> response=new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    return  response;
}

}
