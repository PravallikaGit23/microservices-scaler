package com.scaler.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Product> products;
}
