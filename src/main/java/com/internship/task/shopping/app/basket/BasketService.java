package com.internship.task.shopping.app.basket;

import com.internship.task.shopping.app.receipt.Receipt;
import com.internship.task.shopping.app.receipt.ReceiptGenerator;
import org.springframework.stereotype.Component;

@Component
public class BasketService {

    public Receipt getReceipt(Basket basket) {
        var receiptGenerator = new ReceiptGenerator();
        var receipt = receiptGenerator.generate(basket);

        return receipt;
    }

}
