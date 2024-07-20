package com.sindhu.ecommerce.dto;

import com.sindhu.ecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListProductResponseDTO {
       private List<Product> productList;
       private String responseMessage;

}
