package com.pb.productservicesst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {
    @Id
    private Long id;
    private String title;
    private String description;
}
