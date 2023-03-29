package com.example.demo.model;

public class Product /*implements Comparable<Product>*/{

    private String name;
    private String category;
    private double price;
    private String img;

    public Product() {}

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // геттеры и сеттеры для полей name, category, price

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

//    public int compare(Product p){
//
//        return p.getPrice().compareTo(p.getPrice());
//    }
}
