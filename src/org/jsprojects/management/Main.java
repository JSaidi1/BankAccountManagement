package org.jsprojects.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		boolean end = false;
		int choice;
		ArrayList<Agency>agencyArray = new ArrayList<>();
		ArrayList<Customer>customerArray = new ArrayList<>();
		String id_customerStr = "";
		//
		Bank bank = new Bank();
		//BankAccount bankAccount = new BankAccount();
		//
		while(end == false) {
			//bankAccount.displayBankAccountMenu();
			bank.displayBankAccountMenu();

			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1://1- Create an agency
				String codeStr;
				//ArrayList<Agency>agencyArray = new ArrayList<>();
				boolean codeAlreadyExists = false;

				Agency agency = new Agency();
				//
				Scanner scanner = new Scanner(System.in);
				System.out.println("Set : agence number: ");
				codeStr = scanner.nextLine();
				//
				if(agency.codeIsValid(codeStr) == true){
					//control if codeStr not already exists on agencyArray list in an object:
					for (Agency agencyy : agencyArray) {
						if(agencyy.getCode().equals(codeStr)) {
							System.out.println("Error: you can't create a new agency because the code you have entered("+codeStr+") already exists for an other agency("+agencyy);
							codeAlreadyExists = true;
							break;
						}
					}//for
					if(codeAlreadyExists == false) {
						agency.setCode(codeStr);
						//
						System.out.println("Set : agence name: ");
						agency.setName(scanner.nextLine());
						//
						System.out.println("Set : agence adress: ");
						agency.setAdress(scanner.nextLine());
						//
						agencyArray.add(agency);
						//
						bank.setAgencyArray(agencyArray);
						//
						System.out.println("Agency is added ("+agency+")");
					}//if
				}else {
					System.out.println("Agency code is not valid: it must be constituted of 3 digits.");
				}

				break;
			case 2://2- Create a customer
				String dateStr;
				//
				Customer customer = new Customer();
				//
				Scanner scanner1 = new Scanner(System.in);
				//
				if(agencyArray.size() == 0) {
					System.out.println("You can't create a new customer because agency not exists");
					break;
				
				}
				else /*(agencyArray.size() != 0) */{
					System.out.println("Set : customer id (Alphanumeric consisting of two uppercase characters + 6 digits): ");
					id_customerStr = scanner1.nextLine();
					
					if (customer.id_customerIsValid(id_customerStr) == true ) {
						
						//if(customer.getNbreOfAccounts() <= 3) {
						customer.setId_customer(id_customerStr); 
						//
						System.out.println("Set : firstName: ");
						customer.setFirstName(scanner1.nextLine()); 
						//
						System.out.println("Set : lastName: ");
						customer.setLastName(scanner1.nextLine());
						//
						System.out.println("Set : birthdate (format MM/dd/yyyy): ");
						dateStr = scanner1.nextLine();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date d = sdf.parse(dateStr);
						customer.setBirthdate(d);
						//
						System.out.println("Set : email: ");
						customer.setEmail(scanner1.nextLine());
						//
						customerArray.add(customer);
						//add customer to agency:
						System.out.println("Agencies :");
						for (Agency agencyEmlement : agencyArray) {
							System.out.println(agencyEmlement);
						}
						System.out.println("which agency do you want to assign this client (set code)?");
						String choiceAgency = scanner1.nextLine();
							//check if choiceAgency is a correct code of an agency
						boolean codeIsOnAnAgency = false;
						for (Agency agencyEmlement : agencyArray) {
							if(choiceAgency.equals(agencyEmlement.getCode())) {
								codeIsOnAnAgency = true;
								break;
							}
						}
						
						if(codeIsOnAnAgency == true) {
							//add customer to agency:
							//agencyArray.add(customerArray);
							//add to agency number choiceAgency the customer
							for (Agency agencyEmlement : agencyArray) {
								if(choiceAgency.equals(agencyEmlement.getCode())) {
									agencyEmlement.setArrayCustomer(customerArray);
								}
							}
							//System.out.println(agencyArray);
							System.out.println("Customer number is created now.");
						}else {
							System.out.println("Error: the code you entered("+choiceAgency+") does not exists for any agency.");
						}
						
					}else {
						System.out.println("Customer is not valid: it must be alphanumeric consisting of two uppercase characters + 6 digits");
					}
				}
				
			
			//
			//System.out.println("Set : customer id (Alphanumeric consisting of two uppercase characters + 6 digits): ");
			//id_customerStr = scanner1.nextLine();
			//
			/*					
					if (customer.id_customerIsValid(id_customerStr) == true ) {
						//if(customer.getNbreOfAccounts() <= 3) {
							customer.setId_customer(id_customerStr); 
							//
							System.out.println("Set : firstName: ");
							customer.setFirstName(scanner1.nextLine()); 
							//
							System.out.println("Set : lastName: ");
							customer.setLastName(scanner1.nextLine());
							//
							System.out.println("Set : birthdate (format MM/dd/yyyy): ");
							dateStr = scanner1.nextLine();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date d = sdf.parse(dateStr);
							customer.setBirthdate(d);
							//
							System.out.println("Set : email: ");
							customer.setEmail(scanner1.nextLine());
							//choose an agence
							//System.out.println(agencyArray);


						//}else {
							//System.out.println("This customer have already 3 accounts!");
						//}
					}else {
						System.out.println("Customer is not valid: it must be alphanumeric consisting of two uppercase characters + 6 digits");
					}*/
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
