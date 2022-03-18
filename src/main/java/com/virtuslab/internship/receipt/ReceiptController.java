package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ReceiptController {

    private final FifteenPercentDiscount fifteenPercentDiscount = new FifteenPercentDiscount();
    private final TenPercentDiscount tenPercentDiscount = new TenPercentDiscount();

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/api/receipt-post")
    public Receipt postReceipt() {
        var receipt = new ReceiptGenerator().generate(new Basket());
        receipt = fifteenPercentDiscount.applyFifteenProcentDiscount(receipt, new Basket());
        receipt = tenPercentDiscount.apply(receipt);

        return receipt;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/receipt/{id}")
    public Receipt getReceipt(@PathVariable(name = "id") Long id) {
        return new Receipt();
    }
}
