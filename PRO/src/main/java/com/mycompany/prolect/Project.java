package com.mycompany.prolect;




import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class  Project {
	
	private static ArrayList<Cashier> cashierList = new ArrayList<Cashier>();
	
	public static void main(String[] aseel) {
		Scanner input = new Scanner(System.in);
		Cashier cashier = null;
		Invoice invc = null;
		String cashierName = null;
		int i = 1;
		int option;
		int index;
		
		while(i > 0) {
			System.out.println("1- Add cashier");
			System.out.println("2- Create invoice");
			System.out.println("3- show cashier invoices");
			System.out.println("4- Change cashier");
			System.out.println("5- Exit");
			
			option = inputInt("\nChoose an option: ");
			
			switch(option) {
			case 1:
				System.out.print("\nEnter your name: ");
				cashierName = input.nextLine();
				
				if(cashierList.isEmpty()) {
					cashierList.add(new Cashier(cashierName));
					cashier = cashierList.get(0);
					System.out.println(cashier + " is the current user.");
				}else {
					cashierList.add(new Cashier(cashierName));
				}
				
				System.out.println("-Complete-\n");
				break;
				
			
			case 2:
				
				if(cashierList.isEmpty()) {
					System.out.println("The list is empty\nPlease choose option 1 to add cashier first\n\n");
					continue;
				}
				
				String userChoice = "y";
				invc = new Invoice();
				System.out.println("-Invoice created-\n");
				
				while(userChoice.equalsIgnoreCase("y")) {
					invc.addItem();
					System.out.println("Add another item? (y/n): ");
					userChoice = input.nextLine();
					if(userChoice.equalsIgnoreCase("y"))
                                            continue;
                                        
					System.out.println("\n-Items added-\n");
					cashier.addInvoice(invc);
				}
				break;
				
				
			case 3:
				if(cashierList.isEmpty()) {
					System.out.println("The list is empty\nPlease choose option 1 to add cashier first\n\n");
					continue;
				}
				cashier.showCashierInvoices();
				break;
				
				
			case 4:
				
				if(cashierList.isEmpty()) {
					System.out.println("The list is empty\nPlease choose option 1 to add cashier first\n\n");
					continue;
				}
				
				index = 1;
				for (Cashier c: cashierList ) {
					System.out.println(index++ + "- " + c.getName());
				}
				
				option = inputInt("\nEnter cashier number: ");
				
				if(option > cashierList.size() || option == 0) {
					System.out.println("\n\nInvalid number!");
					System.out.println("Failed to change cashier.");
					continue;
				}
				
				cashier = cashierList.get(option - 1);
				System.out.println("Cashier changed to " + cashier.getName() + "\n\n");
				break;
				
			
			case 5:
				i = -1;
				break;
				
			default:
				System.out.println("\nInvalid number\nPlease Enter a valid number.\n");
				
			}
	
		}
		System.out.println("\n###|End of programm|###");
		input.close();
		
	}
	
	
	public static int inputInt(String message) {
		int result;
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try{
				System.out.print(message);
				result = s.nextInt();
				break;
			}
			
			catch(InputMismatchException e){
				System.err.println("\n\nInvalid input!");
				System.out.println("The input should not be a big number or character.\n");
				s.next();
                                
                                //s.next() to clear scanner buffer 
			}
		}
		
		return result;
	}
}