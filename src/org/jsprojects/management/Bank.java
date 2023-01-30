package org.jsprojects.management;

import java.util.ArrayList;

public class Bank {
	private String name = "CDA bank";
	private ArrayList<Agency>agencyArray = new ArrayList<>();
	
	
	public void setAgencyArray(ArrayList<Agency> agencyArray) {
		this.agencyArray = agencyArray;
	}
	
	public void displayBankAccountMenu() {
		System.out.println("\n-----------------------------MENU CDA BANK----------------------------");
		System.out.println("| 1- Create an agency                                                |");                                                  
		System.out.println("| 2- Create a customer                                               |");
		System.out.println("| 3- Create a bank account                                           |");
		System.out.println("| 4- Account search (account number)                                 |");
		System.out.println("| 5- Customer search (Name, Account number, Customer ID)             |");
		System.out.println("| 6- Display the list of a customer's accounts (customer ID)         |");
		System.out.println("| 7- Print customer info (customer ID)                               |");
		System.out.println("| 8- Close (leave the program)                                       |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\nYour choice? ");
	}
	
	
}
