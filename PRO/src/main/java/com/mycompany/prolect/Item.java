
package com.mycompany.prolect;


public class Item {
	
	String name;
	Double price;
	int quantity;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Item(String n, double p, int q) {
		name  = n;
		price = p;
		quantity = q;
	}
	
	public double total() {
		return price * quantity;
	}
	
        @Override
	public String toString() {
		return quantity + "x " + name + " \nprice: " + price + " \ntotal price: " + (price*quantity);
	}
        
       
}

