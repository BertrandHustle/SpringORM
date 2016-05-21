package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SpringORMController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PurchaseRepo purchaseRepo;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String webRoot(Model model, HttpSession session){

        //used to add purchases to model
        Iterable<Purchase> purchases;
        purchases = purchaseRepo.findAll();

        model.addAttribute("purchases", purchases);
        return "home";

    }

}
