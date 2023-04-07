package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FilterRequest;
import com.example.demo.model.Product;
import com.example.demo.model.SortRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ProductController {
    @GetMapping("/products")
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
    
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new ClassPathResource("static/products.json").getFile();
            products = Arrays.asList(objectMapper.readValue(file, Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }



    @PostMapping("/products/filter")
    public List<Product> filterProducts(@RequestBody FilterRequest filterRequest) {
        List<Product> filteredProducts = new ArrayList<>();
        List<Product> products = getProducts();

        //добавляем в коллекцию то, что проходит по фильтру
        for (Product product : products) {
            if ((filterRequest.getName() != null && filterRequest.getName()!= "") && !(product.getName().toLowerCase()).contains(filterRequest.getName().toLowerCase())) {
                continue;
                }
        
            if ((filterRequest.getCategory() != null && filterRequest.getCategory()!= "") && !product.getCategory().contains(filterRequest.getCategory())) {
            continue;
            }
        
            if ((filterRequest.getMinPrice() != null) && product.getPrice() < filterRequest.getMinPrice()) {
            continue;
            }
        
            if ((filterRequest.getMaxPrice() != null) && product.getPrice() > filterRequest.getMaxPrice()) {
            continue;
            }
            filteredProducts.add(product);
        }

    return filteredProducts; 
    }

    @PostMapping("/products/sort")
    public List<Product> sortProducts(@RequestBody SortRequest sortRequest) {
        //List<Product> sortedProducts = new ArrayList<>();
        List<Product> sortedProducts = new ArrayList<>();
        sortedProducts = getProducts();

        switch (sortRequest.getSortBy()) {
            case "name":
            sortedProducts.sort(Comparator.comparing(Product::getName));
                break;
            case "price":
            sortedProducts.sort(Comparator.comparing(Product::getPrice));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort parameter: " + sortRequest.getSortBy());
        }
        return sortedProducts;
    }

    public static Product getProductById(int i){
        List<Product> products = getProducts();
        for (Product product : products){
            if (product.getId()==i)
                return product;
        }
        return null;
    }
}
