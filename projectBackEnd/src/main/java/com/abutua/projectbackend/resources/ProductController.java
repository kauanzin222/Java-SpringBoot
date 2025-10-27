package com.abutua.projectbackend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Bola de Vôlei");
        p1.setPrice(50.50);

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Bola de Futebol");
        p2.setPrice(130);

        Product p3 = new Product();
        p3.setId(3);
        p3.setName("Bola de HandBall");
        p3.setPrice(330.75);

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        // if (id <= products.size() && id > 0)
        //     return ResponseEntity.ok(products.get(id - 1));
        // else {
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product NOT FOUND");
        // }

        // Programação Funcional
        Product prod = products.stream() // Transforma a lista em um fluxo de dados
                                .filter(p -> p.getId() == id) 
                                // filter passa por CADA PRODUTO e pergunta: 
                                // o id do produto em questão é igual ao id do Path?
                                .findFirst() // Me devolva o PRIMEIRO produto a passar no filtro!
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product NOT FOUND")); 
                                // Caso contrário, lance a exceção. O resto do código não será lido.


        return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return products;
    }
}
