package com.sindhu.ecommerce.repository;

import com.sindhu.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category save(Category category);

    Optional<Category> getCategoryByName(String catName);

    List<Category> getCategoryByNameContaining(String text);

}
