package org.jsprojects.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer {
	private String id_customer;//Alphanumeric consisting of two uppercase characters + 6 digits - id
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String email;
	//private int nbreOfAccounts = 0;//max 3
	private ArrayList<BankAccount>arrayBankAccount = new ArrayList<>();//max 3
	
	public ArrayList<BankAccount> getArrayBankAccount() {
		return arrayBankAccount;
	}

	/*
	public int getNbreOfAccounts() {
		return nbreOfAccounts;
	}
	*/
	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getId_customer() {
		return id_customer;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public void setNbreOfAccountsPlusOne() {
		this.nbreOfAccounts = this.nbreOfAccounts + 1;
	}
	*/
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
				+ ", birthdate=" + birthdate + ", email=" + email + ", arrayBankAccount=" + arrayBankAccount + "]";
	}
	

	
	
	
	
	
	
	
}
