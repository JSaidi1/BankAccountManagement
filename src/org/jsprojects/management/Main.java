package org.jsprojects.management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException, FileNotFoundException {

		boolean end = false;
		int choice;
		ArrayList<Agency>agencyArray = new ArrayList<>();
		ArrayList<Customer>customerArray = new ArrayList<>();
		ArrayList<BankAccount>bankAccountArray = new ArrayList<>();
		String id_customerStr = "";
		//
		Bank bank = new Bank();
		//BankAccount bankAccount = new BankAccount();
		//
		Scanner scanner = new Scanner(System.in);

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
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("Set : agence number: ");
				codeStr = scanner1.nextLine();
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
						agency.setName(scanner1.nextLine());
						//
						System.out.println("Set : agence adress: ");
						agency.setAdress(scanner1.nextLine());
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
				//Scanner scanner1 = new Scanner(System.in);
				//
				if(agencyArray.size() == 0) {
					System.out.println("You can't create a new customer because agency not exists");
					break;

				}
				else /*(agencyArray.size() != 0) */{
					System.out.println("Set : customer id (Alphanumeric consisting of two uppercase characters + 6 digits): ");
					id_customerStr = scanner.nextLine();

					if (customer.id_customerIsValid(id_customerStr) == true ) {

						//if(customer.getNbreOfAccounts() <= 3) {
						customer.setId_customer(id_customerStr); 
						//
						System.out.println("Set : firstName: ");
						customer.setFirstName(scanner.nextLine()); 
						//
						System.out.println("Set : lastName: ");
						customer.setLastName(scanner.nextLine());
						//
						System.out.println("Set : birthdate (format MM/dd/yyyy): ");
						dateStr = scanner.nextLine();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date d = sdf.parse(dateStr);
						customer.setBirthdate(d);
						//
						System.out.println("Set : email: ");
						customer.setEmail(scanner.nextLine());
						//
						customerArray.add(customer);
						//add customer to agency:
						System.out.println("Agencies :");
						for (Agency agencyEmlement : agencyArray) {
							System.out.println(agencyEmlement);
						}
						System.out.println("which agency do you want to assign this client (set code)?");
						String choiceAgency = scanner.nextLine();
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
									break;
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
				break;
			case 3:
				if (customerArray.size() == 0 ) {
					System.out.println("You must create at least one customer before creating an account");
				}else {
					boolean accountNumberAlreadyExist = false;
					//
					BankAccount bA = new BankAccount(); 
					bA.createBankAccount();
					System.out.println("==>Bank Account Created : "+ bA);
					//
					for (Customer customerElement : customerArray) {
						for (int i = 0; i < customerElement.getArrayBankAccount().size(); i++) {
							if (customerElement.getArrayBankAccount().get(i).getAccountNumber() == bA.getAccountNumber()) {
								accountNumberAlreadyExist = true;
								break;
							} 
						}
					}
					
					if (accountNumberAlreadyExist) {
						System.out.println("Error: you can't create this new account because there is already exists which this account number("+bA.getAccountNumber()+")");
					} else {//accountNumberAlreadyExist = false
						//add this new account to bankAccountArray
						bankAccountArray.add(bA);
						
						//choose a custmer to add this account
						System.out.println("Customers :");
						System.out.println(customerArray);
						System.out.println("Choose customer in which you will add the account? (set id_customer (Alphanumeric consisting of two uppercase characters + 6 digits)): ");
						
						//add bankAccountArray to a custommer from customerArray
						String choiceIdCustomer = scanner.nextLine();
						boolean stopWhile = false;
						boolean idCustomerChoosedIsInACustomer = false;
						
						while(stopWhile == false) {
							System.out.println("id_customer is not valid: set again the id_customer (Alphanumeric consisting of two uppercase characters + 6 digits)): ");
							System.out.println("To exit: set exit");
							
							choiceIdCustomer = scanner.nextLine();//
							
							if (choiceIdCustomer.equals("exit")) {
								stopWhile = true;
							}else {
								for (Customer customerElement : customerArray) {
									if(customerElement.getId_customer().equals(choiceIdCustomer)) {
										idCustomerChoosedIsInACustomer = true;
										//
										customerElement.setArrayBankAccount(bankAccountArray);
										System.out.println("==>Accounts tab are added to the choosen customer ("+choiceIdCustomer+").");
										//
										stopWhile = true;
										break;
									}
								}//for
							}//else
						}//while
					}//else
				}//else
				System.out.println("customerArray : "+customerArray);
				break;
				
			case 4:
				long searchNumberAccount= 0;
				for (BankAccount bankAccount : bankAccountArray) {
					System.out.println("Please enter the number account who search ");
					searchNumberAccount = scanner.nextLong();
					if (bankAccount.getAccountNumber() == searchNumberAccount ) {
						System.out.println(bankAccountArray);
					}
					else {
						System.out.println("this account number doesn't exist");
					}
				}
				
				break;
				
			case 5:
				

				break;
			case 6:

				String searchIdCustomer= "";
				for (Customer custom : customerArray) {
					System.out.println("Please enter the id customer who search ");
					searchIdCustomer = scanner.next();
					if (custom.getId_customer().equals(searchIdCustomer)) {
						System.out.println(customerArray);
					}
					else {
						System.out.println("this customer doesn't exist");
					}
				}
				
				break;
			
			case 7:
				
				float BalanceAccount =0;
				long Account =0;
				for (BankAccount bankAccount : bankAccountArray) {
					BalanceAccount= bankAccount.getBalance();
					Account= bankAccount.getAccountNumber();
				}
				
				
				for (Customer custom : customerArray) {
					System.out.println("Please enter the id customer who search ");
					searchIdCustomer = scanner.next();
					if (custom.getId_customer().equals(searchIdCustomer)) {
						
						PrintWriter writer = new PrintWriter(System.out);
						writer= new PrintWriter (new File("C:\\Users\\59013-42-09\\Desktop\\b\\file.txt"));
						writer.write("Fiche Client ");
						writer.write(System.getProperty( "line.separator" ));
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Numéro Client : " + searchIdCustomer);
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Nom : "  + custom.getLastName());
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Prénom : "  + custom.getFirstName());
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Date de naissance : "  + custom.getBirthdate());
						writer.write(System.getProperty( "line.separator" ));
						writer.write("----------------------------------------------------------------------");
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Liste de compte");
						writer.write(System.getProperty( "line.separator" ));
						writer.write("----------------------------------------------------------------------");
						writer.write(System.getProperty( "line.separator" ));
						writer.write("Numéro de compte"+"...................................." + " Solde");
						writer.write(System.getProperty( "line.separator" ));
						writer.write("----------------------------------------------------------------------");
						writer.write(System.getProperty( "line.separator" ));
						writer.write(Account + "...................................." + BalanceAccount);
						writer.flush();
					    writer.close();
					}
					else {
						System.out.println("this customer doesn't exist");
					}
				}
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
