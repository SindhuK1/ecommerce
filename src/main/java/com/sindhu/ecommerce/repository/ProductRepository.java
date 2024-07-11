package com.sindhu.ecommerce.repository;

public class ProductRepository {
    public void getAllProducts() {
        String sqlQuery = "select * from products";
        db.execute(sqlQuery);
    }
}
