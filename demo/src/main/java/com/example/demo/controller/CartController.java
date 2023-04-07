package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Product;

import jakarta.servlet.http.HttpSession;


@RestController
public class CartController {
    
    @PostMapping("/cart")
    @ResponseBody
    public String addToCart(@RequestParam int productId, HttpSession session) {
        // Получить текущую корзину из сессии
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        Product item = ProductController.getProductById(productId);

        // Добавить товар в корзину
        cart.addItem(item,1);

        // Вернуть сообщение об успешном добавлении товара в корзину
        return "Товар успешно добавлен в корзину!";
    }
    @GetMapping("/cart/quantity")
    @ResponseBody
    public Map<String, Integer> getCartQuantity(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        System.out.println(cart);
        int quantity = cart != null ? cart.getTotalQuantity() : 1;

        Map<String, Integer> response = new HashMap<>();
        response.put("quantity", quantity);

        return response;
    }
    @GetMapping("/shoppingCart/order")
    @ResponseBody
    public Map<Long, CartItem>  getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        Map<Long, CartItem> items = cart.getItems();
        return items;
    }

}
