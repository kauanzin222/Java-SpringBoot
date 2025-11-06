package com.abutua.projectbackend.models;

public class Category {

    // Atributos
    private int id;
    private String name;

    // Método Construtor
    public Category(int id, String name) {
        System.out.println("Construindo uma categoria!");

        this.id = id;
        this.name = name;
    }

    // Métodos da classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
