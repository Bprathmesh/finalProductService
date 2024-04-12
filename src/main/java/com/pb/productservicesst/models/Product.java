package com.pb.productservicesst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//We can also define Getter Setter at attribute level if u have all args constructor we wont have default constructor right
public class Product {
    @Id
    private long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;
    private  String image;


}
