package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class SpringORMController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

    @PostConstruct
    public void init() throws IOException{

        //saves customers to repo
        if (customerRepo.count() == 0) {
            File file = new File("customers.csv");
            Scanner scanner = new Scanner(file);
            ArrayList<Customer> customers = CSVParser.CustomerBuilder(scanner);
            customerRepo.save(customers);
        }

        //saves purchases to repo
        if (purchaseRepo.count() == 0 ) {
            File file2 = new File("purchases.csv");
            Scanner scanner2 = new Scanner(file2);
            ArrayList<Purchase> purchases = CSVParser.PurchaseBuilder(scanner2);
            purchaseRepo.save(purchases);
        }
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String webRoot(Model model, HttpSession session){

        //used to add purchases to model
        Iterable<Purchase> purchases;
        purchases = purchaseRepo.findAll();

        model.addAttribute("purchases", purchases);
        return "home";

    }

}
