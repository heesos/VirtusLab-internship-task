package com.internship.task.shopping.app.discount;

import com.internship.task.shopping.app.receipt.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TenPercentDiscount {

    public static String NAME = "TenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.9));

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
        //changed < to >
        return receipt.totalPrice().compareTo(BigDecimal.valueOf(50)) > 0;
    }
}
