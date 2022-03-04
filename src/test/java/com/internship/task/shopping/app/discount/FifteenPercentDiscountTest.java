package com.internship.task.shopping.app.discount;

import com.internship.task.shopping.app.product.ProductDb;
import com.internship.task.shopping.app.receipt.Receipt;
import com.internship.task.shopping.app.receipt.ReceiptEntry;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FifteenPercentDiscountTest {


    @Test
    void apply() {
        var productDb = new ProductDb();
        var bread  = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");

        List<ReceiptEntry> receiptEntryList = new ArrayList<>();
        receiptEntryList.add(new ReceiptEntry(bread,2));
        receiptEntryList.add(new ReceiptEntry(cereals,3));


        var receipt = new Receipt(receiptEntryList);
        var discount = new FifteenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        var expectedTotalPrice = bread.price().multiply(BigDecimal.valueOf(2)).add(cereals.price().multiply(BigDecimal.valueOf(3))).multiply(
                BigDecimal.valueOf(0.85));

        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldNotApply() {
        var productDb = new ProductDb();
        var bread  = productDb.getProduct("Bread");
        var steak = productDb.getProduct("Steak");

        List<ReceiptEntry> receiptEntryList = new ArrayList<>();
        receiptEntryList.add(new ReceiptEntry(bread,2));
        receiptEntryList.add(new ReceiptEntry(steak,4));

        var receipt = new Receipt(receiptEntryList);
        var discount = new FifteenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        var expectedTotalPrice=bread.price().multiply(BigDecimal.valueOf(2)).add(steak.price().multiply(BigDecimal.valueOf(4)));

        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(null, receiptAfterDiscount.discounts());
    }

    @Test
    void applyFifteenFirst() {
        var productDb = new ProductDb();
        var bread  = productDb.getProduct("Bread");
        var steak = productDb.getProduct("Steak");

        List<ReceiptEntry> receiptEntryList = new ArrayList<>();
        receiptEntryList.add(new ReceiptEntry(bread,3));
        receiptEntryList.add(new ReceiptEntry(steak,4));

        var receipt = new Receipt(receiptEntryList);
        var discount = new FifteenPercentDiscount();
        var discount2 = new TenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        receiptAfterDiscount=discount2.apply(receiptAfterDiscount);
        var expectedTotalPrice=bread.price().multiply(BigDecimal.valueOf(3)).add(steak.price().multiply(BigDecimal.valueOf(4)));

        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }
}