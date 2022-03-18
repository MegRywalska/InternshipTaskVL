package com.virtuslab.internship.discount;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FifteenPercentDiscountTest {

    @Test
    void shouldApplyDiscountWhenThreeProductTypeGrainsAreInTheBasket() throws Exception{

        //given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var cart = new Basket();
        var discount = new FifteenPercentDiscount();

        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 2));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        var receipt = new Receipt(receiptEntries);

        //When
        cart.addProduct(bread);
        cart.addProduct(bread);
        cart.addProduct(cereals);
        var receiptAfterDiscount = discount.applyFifteenProcentDiscount(receipt, cart);
        var expectedTotalPrice =bread.price().multiply(BigDecimal.valueOf(2)).add(cereals.price()).multiply(BigDecimal.valueOf(0.85));

        //Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());

    }



}