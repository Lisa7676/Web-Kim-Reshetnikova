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
import com.example.demo.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        List<Product> products = getProducts();

        for (Product product : products) {
            if ((filterRequest.getName() != null && filterRequest.getName() != "") && !product.getName().contains(filterRequest.getName())) {
                continue;
            }

            if ((filterRequest.getCategory() != null && filterRequest.getCategory() != "") && !product.getCategory().contains(filterRequest.getCategory())) {
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

}
