
package com.mycompany.prolect;

import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public void addItem() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter item name: ");
		String item = sc.nextLine();
		
		System.out.print("Enter item price: ");
		Double price = sc.nextDouble();
		
		System.out.print("Enter quantity: ");
		int quantity = sc.nextInt();
		
		items.add(new Item(item, price, quantity));
	}
	
	public void displayInvoice() {
		double total = 0.0;
		for (Item item : items) 
		{
			System.out.println(item + "\n");
			total += item.total();
		}
		System.out.println("\n\n*************************");
		System.out.println("Total = " + total);
		System.out.println("*************************");
	}
	
}