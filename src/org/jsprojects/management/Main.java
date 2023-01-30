package org.jsprojects.management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean end = false;
		int choice;
		//
		BankAccount bankAccount = new BankAccount();
		//
		while(end == false) {
			bankAccount.displayBankAccountMenu();
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
				case 1://1- Create an agency
					Agency agency = new Agency();
					agency.createAgency();
					System.out.println("==>Created agency: "+agency);
					break;
				case 2://2- Create a customer
					
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
					System.out.println("=>Input error, please choose '1' or '2' or '3' or '4' or '5' or '6' or '7' or '8' from the menu below!");
					break;
			}
			
		}

	}

}
