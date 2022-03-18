package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {


    public Receipt generate(Basket basket) {
        var discountFifteenPercent = new FifteenPercentDiscount();
        var discountTenPercent = new TenPercentDiscount();
        var receipt = getReceipt(basket);

        receipt = discountFifteenPercent.applyFifteenProcentDiscount(receipt, basket);   //adding discounts
        receipt = discountTenPercent.apply(receipt);

        return receipt ;
    }

    private Receipt getReceipt(Basket basket) {
        Map<Product, Integer> receiptEntriesMap = new HashMap<>();
        List <ReceiptEntry> receiptEntries = new ArrayList<>();

        for (int i = 0; i < basket.getProducts().size(); i++) {             //Counting the number of items of the given products in the basket
            Product product = basket.getProducts().get(i);
            int count = 1;
            if(receiptEntriesMap.containsKey(product)){
                count = receiptEntriesMap.get(product);
                count++;
                receiptEntriesMap.put(product, count);
            }else{
                receiptEntriesMap.put(product, count);
            }
        }

        for (Map.Entry<Product, Integer> entry :receiptEntriesMap.entrySet()) {             //Adding products to the list along with the quantity
            ReceiptEntry receiptEntry = new ReceiptEntry(entry.getKey(), entry.getValue());

            receiptEntries.add(receiptEntry);
        }
        return  new Receipt(receiptEntries);
    }


}