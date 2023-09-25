package com.example.cannabisstoreinventory.product;

public class Product {
    private String name;
    private int quantity;
    private String avatar_product;

    public Product(String name, int quantity, String avatar_product) {
        this.name = name;
        this.quantity = quantity;
        this.avatar_product = avatar_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAvatar_product() {
        return avatar_product;
    }

    public void setAvatar_product(String avatar_product) {
        this.avatar_product = avatar_product;
    }
}
