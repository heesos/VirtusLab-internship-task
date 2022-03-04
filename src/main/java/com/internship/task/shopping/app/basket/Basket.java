package com.internship.task.shopping.app.basket;

import com.internship.task.shopping.app.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
