package com.sindhu.ecommerce.models;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
      private String name;
      private String parentCategory;

      @OneToMany(mappedBy = "category")// fetch = FetchType.EAGER
       private List<Product> products;

}
