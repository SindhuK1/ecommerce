package com.sindhu.ecommerce.inheritancetype;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User {

    private String company;
    private Float avgRating;
}
