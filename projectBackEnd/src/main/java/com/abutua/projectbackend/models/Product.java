package com.abutua.projectbackend.models;

public class Product {

    // Atributos:
    private int id;
    private String name;
    private double price;
    private String description;
    private boolean promotion;
    private boolean newProduct;

    private int idCategory;

    private static int contProducts = 0;

    // Métodos Construtores
    public Product(String name, String desc, int idCat, boolean prom, boolean newProd, double price) {
        System.out.println("Construindo um Produto!");

        // Aumentando a qtde de Produtos existentes
        contProducts++;

        this.id = contProducts;
        this.name = name;
        this.description = desc;
        this.idCategory = idCat;
        this.promotion = prom;
        this.newProduct = newProd;
        this.price = price;
    }

    // Métodos de Produto
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
