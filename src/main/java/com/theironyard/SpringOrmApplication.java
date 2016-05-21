package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class SpringOrmApplication {

	public static void main(String[] args) throws IOException{

		File file = new File("customers.csv");
		Scanner scanner = new Scanner(file);
		ArrayList<Customer> customers = CSVParser.CustomerBuilder(scanner);

		File file2 = new File("purchases.csv");
		Scanner scanner2 = new Scanner(file2);
		ArrayList<Purchase> purchases = CSVParser.PurchaseBuilder(scanner2);

		System.out.println(customers.get(77).getName());
		System.out.println(purchases.get(99).getCreditCard());

		//SpringApplication.run(SpringOrmApplication.class, args);
	}
}
