package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FilterRequest;
import com.example.demo.model.SorterRequest;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Comparator;
import java.util.stream.*;

@RestController
public class ProductController {
    
    @GetMapping("/products")
    public List<Product> getProducts() {
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
    // load products from JSON file or database
        List<Product> products = getProducts();

        for (Product product : products) {
            if ((filterRequest.getName() != null && filterRequest.getName()!= "") && !product.getName().toLowerCase().contains(filterRequest.getName().toLowerCase())) {
                continue;
                }
        // apply category filter
            if ((filterRequest.getCategory() != null && filterRequest.getCategory()!= "") && !product.getCategory().contains(filterRequest.getCategory())) {
            continue;
            }
        // apply min price filter
            if ((filterRequest.getMinPrice() != null) && product.getPrice() < filterRequest.getMinPrice()) {
            continue;
            }
        // apply max price filter
            if ((filterRequest.getMaxPrice() != null) && product.getPrice() > filterRequest.getMaxPrice()) {
            continue;
            }
            filteredProducts.add(product);
        }

    return filteredProducts;
}

//   @PostMapping("/products/sort")
//    public List<Product> sortProducts(@RequestBody SorterRequest sorterRequest) {
//        List<Product> sortedProducts = new ArrayList<>();
//        // load products from JSON file or database
//        List<Product> products = getProducts();
////        ?как бы передавать отсортирванную продукцию в ФИЛЬТР И НАБОРОТ
//
//        if (sorterRequest.getType()=="price" && sorterRequest.getAsc()){
//            //сортировка по цене по  возрастанию
//            sortedProducts = products.stream()
//                    .sorted(Comparator.comparingDouble(Product::getPrice))
//                    .collect(Collectors.toList());
//        }
//        else if(sorterRequest.getType()=="price" && sorterRequest.getAsc()==false){
//            // сортировка по убыванию цены
//            sortedProducts = products.stream()
//                    .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
//                    .collect(Collectors.toList());
//        }
//        else if(sorterRequest.getType()=="abc" && sorterRequest.getAsc()){
//            // сортировка по алфавиту
//            sortedProducts = products.stream()
//                    .sorted(Comparator.comparing(Product::getName))
//                    .collect(Collectors.toList());
//        }
//        else if (sorterRequest.getType()=="reset"){
//            sortedProducts= getProducts();
//        }
//        else{
//            //some error happend
//            sortedProducts= products;
//
//        }
//        return sortedProducts;
//    }

    @PostMapping("/products/sort")
    public List<Product> sortProducts(@RequestBody SorterRequest sortRequest) {
        List<Product> sortedProducts = new ArrayList<>();
        sortedProducts = getProducts();

        switch (sortRequest.getSortBy()) {
            case "reset":
                //do nothing
                break;
            case "name":
                sortedProducts.sort(Comparator.comparing(Product::getName));
                break;
            case "price":
                sortedProducts.sort(Comparator.comparing(Product::getPrice));
                break;
            case "price-desc":
                sortedProducts.sort(Comparator.comparing(Product::getPrice).reversed());
                break;

            default:
                throw new IllegalArgumentException("Invalid sort parameter: " + sortRequest.getSortBy());
        }

        return sortedProducts;

    }
}
