package com.internship.task.shopping.app.receipt;

import com.internship.task.shopping.app.basket.Basket;
import com.internship.task.shopping.app.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        var receipt = getReceipt(basket);
        return receipt;
    }

    private Receipt getReceipt(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        for ( Product product:basket.getProducts()) {
            int quantity = Collections.frequency(basket.getProducts(),product);
            if(!isInList(receiptEntries,product)){
                receiptEntries.add(new ReceiptEntry(product,quantity));
            }
        }
        return new Receipt(receiptEntries);
    }

    private boolean isInList(List<ReceiptEntry> receiptEntries, Product product) {
        for (ReceiptEntry receiptEntry:receiptEntries) {
            if(receiptEntry.product().name()== product.name()){
                return true;
            }
        }
        return false;
    }
}
