package com.internship.task.shopping.app.discount;

import com.internship.task.shopping.app.product.Product;
import com.internship.task.shopping.app.receipt.Receipt;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FifteenPercentDiscount {

    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));

            List<String> discounts;
            if(receipt.discounts()==null){
                discounts = new ArrayList<>();
            } else {
                discounts = receipt.discounts();
            }
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        var counter=0;
        int size= receipt.entries().size();

        for(int i=0;i<size;i++) {
            var receiptEntries=receipt.entries().get(i);
            if(receiptEntries.product().type().equals(Product.Type.GRAINS)) {
                counter+= receiptEntries.quantity();
            }
        }
        if (counter>=3) {
            return true;
        }else {
            return false;
        }
    }
}
