package com.virtuslab.internship.discount;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;

import java.math.BigDecimal;


public class FifteenPercentDiscount {
                                                                     //the discount is applied when there are 3 products grains in the cart
    public static String name = "FifteenPercentDiscounter";

    public Receipt applyFifteenProcentDiscount(Receipt receipt, Basket basket) {           // creates a bill with an accrued discount
        if (shouldApply(basket)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(name);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Basket basket) {                //  the method tells you when the discount should be charged
        int count = 0;

        for (int i = 0; i < basket.getProducts().size(); i++) {
            Product product = basket.getProducts().get(i);
            if (product.type() == Product.Type.GRAINS) {
                count++;
            }
        }

        return count >= 3;
    }
}
