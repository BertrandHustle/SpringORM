package com.theironyard;

import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {

    public static ArrayList<Customer> CustomerBuilder(Scanner scanner){

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

            Customer customer = new Customer (name, email);

            customers.add(customer);
        }

        return customers;
    }

    public static ArrayList<Purchase> PurchaseBuilder(Scanner scanner){

        //init for Purchase arrayList
        ArrayList<Purchase> purchases = new ArrayList<>();

        //skips first line
        scanner.nextLine();

        //reading loop, splits on commas. constructs Purchases, adds to arraylist
        while (scanner.hasNext()){

            //Purchase builder
            String[] thisLine = scanner.nextLine().split(",");
            String date = thisLine[1];
            String creditCard = thisLine[2];
            int cvv = Integer.parseInt(thisLine[3]);
            String category = thisLine[4];

            Purchase purchase = new Purchase (date, creditCard, cvv, category);

            purchases.add(purchase);
        }

        return purchases;
    }
}


