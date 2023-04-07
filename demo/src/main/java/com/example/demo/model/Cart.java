package com.example.demo.model;

import java.util.LinkedHashMap;
import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private Map<Long, CartItem> items = new LinkedHashMap<>();
    private int totalQuantity;
    private BigDecimal totalAmount;

    public void addItem(Product product, int quantity) {
        int productId = product.getId();
        CartItem item = items.get((long)productId);
        System.out.println(items);
        System.out.println(item);
        if (item == null) {
            item = new CartItem(product, quantity);
            items.put((long)productId, item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }

        totalQuantity += quantity;
        //totalAmount = totalAmount.add((BigDecimal.valueOf(product.getPrice())).multiply(BigDecimal.valueOf(quantity)));
    }
    public Map<Long, CartItem> getItems ()
    {
        return this.items;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    // Другие методы класса Cart
}
