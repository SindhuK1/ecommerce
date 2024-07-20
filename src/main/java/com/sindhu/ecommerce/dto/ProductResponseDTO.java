package com.sindhu.ecommerce.dto;

import com.sindhu.ecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Product product;
    private String responseMessage;
}
