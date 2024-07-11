package com.sindhu.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
   private String id;
   private String name;
   private String description;
   private Double price;
   private String imageUrl;
   private Category category;

   public Product(String name){
      this.name = name;
   }


}
