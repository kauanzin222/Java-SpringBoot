package com.abutua.projectbackend.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Product;

@RestController
public class ProductController {

    private List<Product> products = Arrays.asList(
        new Product(1, "Bola de Vôlei", 99.75),
        new Product(2, "Bola de Futebol", 100.0),
        new Product(3, "Bola de HandBall", 50.5)
    );

    @GetMapping("products/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable int id) {

        // if (id <= products.size() && id > 0)
        // return ResponseEntity.ok(products.get(id - 1));
        // else {
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product NOT FOUND");
        // }

        // Programação Funcional
        Product prod = products.stream() // Transforma a lista em um fluxo de dados
                .filter(p -> p.getId() == id)
                // filter passa por CADA PRODUTO e pergunta:
                // o id do produto em questão é igual ao id do Path?
                .findFirst() // Me devolva o PRIMEIRO produto a passar no filtro!
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product NOT FOUND"));
        // Caso contrário, lance a exceção. O resto do código não será lido.

        return ResponseEntity.ok(prod);
    }

    @GetMapping("Products")
    public List<Product> getProducts() {
        return products;
    }
}
