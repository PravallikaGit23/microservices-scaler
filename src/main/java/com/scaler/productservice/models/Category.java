package com.scaler.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{

    private String title;

    @OneToMany(mappedBy = "category" , cascade = {CascadeType.REMOVE})
    private List<Product> products;
}
