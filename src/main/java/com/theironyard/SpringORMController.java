package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpringORMController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

}
