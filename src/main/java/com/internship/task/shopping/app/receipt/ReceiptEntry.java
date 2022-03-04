package com.internship.task.shopping.app.receipt;

import com.internship.task.shopping.app.product.Product;

import java.math.BigDecimal;

public record ReceiptEntry(
        Product product,
        int quantity,
        BigDecimal totalPrice) {

    public ReceiptEntry(Product product, int quantity) {
        this(product, quantity, product.price().multiply(BigDecimal.valueOf(quantity)));
    }
}
