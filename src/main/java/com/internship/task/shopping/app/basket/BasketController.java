package com.internship.task.shopping.app.basket;


import com.internship.task.shopping.app.product.Product;
import com.internship.task.shopping.app.product.ProductDb;
import com.internship.task.shopping.app.receipt.Receipt;
import com.internship.task.shopping.app.receipt.ReceiptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "api/basket")
public class BasketController {

    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;

    }

    @GetMapping
    public Receipt getReceipt(Basket basket) {
        return basketService.getReceipt(basket);
    }
}
