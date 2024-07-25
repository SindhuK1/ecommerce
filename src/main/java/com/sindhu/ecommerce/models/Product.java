package com.sindhu.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
   private String name;
   private String description;
   private Double price;
   private String imageUrl;
   private Double discount;

   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
   private Category category;





}
