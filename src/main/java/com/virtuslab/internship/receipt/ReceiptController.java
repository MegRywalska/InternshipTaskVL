package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ReceiptController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/api/receipt-post")
    public Receipt postReceipt() {                                                  // At a later stage, add services, repository, mapper and databases
        var receipt = new ReceiptGenerator().generate(new Basket());

        return receipt;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/receipt/{id}")
    public Receipt getReceipt(@PathVariable(name = "id") Long id) {                  // At a later stage, add services, repository, mapper and databases
        var receipt = new ReceiptGenerator().generate(new Basket());

        return receipt;
    }
}
