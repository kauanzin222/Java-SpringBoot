package com.abutua.projectbackend.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class CategoryController {

    private List<Category> categories = Arrays.asList(
            new Category("Produção Própria"),
            new Category("Nacional"),
            new Category("Premium"),
            new Category("Avançado"),
            new Category("Importado"));

    @GetMapping("Categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {

        Category cat = categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found... :c"));

        return ResponseEntity.ok(cat);
    }

    @GetMapping("Categories")
    public List<Category> getCategories() {
        return categories;
    }
}
