package com.theironyard;

import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {

    public static ArrayList<Customer> CustomerBuilder(Scanner scanner, CustomerRepo customerRepo){

        //init for Customer arrayList
        ArrayList<Customer> customers = new ArrayList<>();

        //skips first line
        scanner.nextLine();

        //reading loop, splits on commas. constructs Customers, adds to arraylist
        while (scanner.hasNext()){

            //Customer builder
            String[] thisLine = scanner.nextLine().split(",");
            String name = thisLine[0];
            String email = thisLine[1];

            Customer customer = new Customer ();
            customer.setName(name);
            customer.setEmail(email);

            customers.add(customer);
        }

        return customers;
    }


    //todo: pass in customer repo here (to look up customer below)
    public static ArrayList<Purchase> PurchaseBuilder(Scanner scanner, CustomerRepo customerRepo){

        //init for Purchase arrayList
        ArrayList<Purchase> purchases = new ArrayList<>();

        //skips first line
        scanner.nextLine();

        //reading loop, splits on commas. constructs Purchases, adds to arraylist
        while (scanner.hasNext()){

            //Purchase builder
            String[] thisLine = scanner.nextLine().split(",");
            int customer_id = Integer.parseInt(thisLine[0]);
            String date = thisLine[1];
            String creditCard = thisLine[2];
            int cvv = Integer.parseInt(thisLine[3]);
            String category = thisLine[4];

            //look up customer

            Purchase purchase = new Purchase ();
            purchase.setDate(date);
            purchase.setCreditCard(creditCard);
            purchase.setCvv(cvv);
            purchase.setCategory(category);
            //todo: put set Customer here
            purchase.setCustomer(customerRepo.findOne(customer_id));

            purchases.add(purchase);
        }

        return purchases;
    }
}


