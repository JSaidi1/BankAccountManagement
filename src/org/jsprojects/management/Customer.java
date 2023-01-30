package org.jsprojects.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer {
	private String id_customer;//Alphanumeric consisting of two uppercase characters + 6 digits
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String email;
	private int nbreOfAccounts;//max 3
	//private ArrayList<BankAccount>arrayBankAccount;//max 3
	
	public Customer() {
		super();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set : customer id (Alphanumeric consisting of two uppercase characters + 6 digits): ");
		String id_customer = sc.nextLine();
		if (this.id_customerIsValid(id_customer) == true) {
			
		}
		
		this.id_customer = id_customer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.nbreOfAccounts = nbreOfAccounts;
	}
	
	public boolean id_customerIsValid(String id_customerStr){
		//control First 2 chars: must be alpha upper case & last 6 chars: must be int & positive
		char[] arrayIdCustommer = id_customerStr.toCharArray();
		
		if (id_customerStr.length() == 8 && Character.isUpperCase(arrayIdCustommer[0]) && Character.isUpperCase(arrayIdCustommer[1]) && Character.isDigit(id_customerStr.charAt(2)) && Character.isDigit(id_customerStr.charAt(3)) && Character.isDigit(id_customerStr.charAt(4)) && Character.isDigit(id_customerStr.charAt(5)) && Character.isDigit(id_customerStr.charAt(6)) && Character.isDigit(id_customerStr.charAt(7))) {
			return true;
		}else {
			return false;
		}		
	}
	
	@Override
	public String toString() {
		return "Customer [id_customer=" + id_customer + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + birthdate + ", email=" + email + ", nbreOfAccounts=" + nbreOfAccounts + "]";
	}
	
	
	
	
	
	
}
