package com.abutua.projectbackend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.projectbackend.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class ProductController {

        private List<Product> products = new ArrayList<>();
        
        @PostMapping("Products")
        public ResponseEntity<Product> save(@RequestBody Product product) {
                product.setId(products.size() + 1);
                products.add(product);

                URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(product.getId())
                                .toUri();

                return ResponseEntity.created(location).body(product);
        }

        
        @GetMapping("Products/{id}")
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
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                "Product NOT FOUND"));
                // Caso contrário, lance a exceção. O resto do código não será lido.

                return ResponseEntity.ok(prod);
        }

        @GetMapping("Products")
        public List<Product> getProducts() {
                return products;
        }
}
