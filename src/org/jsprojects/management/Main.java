package org.jsprojects.management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean end = false;
		int choice;
		
		System.out.println("\n-------------------------------MENU BANK-----------------------------");
		System.out.println("| 1- Create an agency                                                |");                                                  
		System.out.println("| 2- Create a customer                                               |");
		System.out.println("| 3- Create a bank account                                           |");
		System.out.println("| 4- Account search (account number)                                 |");
		System.out.println("| 5- Client search (Name, Account number, customer ID)               |");
		System.out.println("| 6- Display the list of a customer's accounts (customer ID)         |");
		System.out.println("| 7- Print customer info (customer ID)                               |");
		System.out.println("| 8- Close (leave the program)                                       |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\nYour choice? ");
		
		while(end == false) {
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					System.out.println("Au revoir !");
					end = true;
					break;
	
				default:
					break;
			}
			
		}

	}

}
