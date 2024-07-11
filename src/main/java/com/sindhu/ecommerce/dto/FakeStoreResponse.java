package com.sindhu.ecommerce.dto;

import com.sindhu.ecommerce.models.Category;
import lombok.Getter;
import lombok.Setter;

//purpose to store the data from outside world.
//we place this inside dto folder - to transfer data from their server to my server
@Getter
@Setter

public class FakeStoreResponse {
    private String id;
    private String title;
    private String description;
    private Integer price;
    private String category;
    private String image;
}


/*
"id": 10,
    "title": "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s",
    "price": 109,
    "description": "Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)",
    "category": "electronics",
    "image": "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg",
    "rating": {
        "rate": 2.9,
        "count": 470
*/

