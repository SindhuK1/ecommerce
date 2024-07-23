package com.sindhu.ecommerce.inheritancetype.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
