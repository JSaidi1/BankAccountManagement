package org.jsprojects.management;

import java.util.ArrayList;
import java.util.Scanner;

public class Agency {
	private String code;//3 digit - id
	private String name;
	private String adress;
	private ArrayList<Customer>arrayCustomer = new ArrayList<>();
		
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	
	public void setArrayCustomer(ArrayList<Customer> arrayCustomer) {
		this.arrayCustomer = arrayCustomer;
	}

	public boolean codeIsValid(String codeStr) {
		//must be 3 digit:
		
		if (codeStr.length() == 3 && Character.isDigit(codeStr.charAt(0)) && Character.isDigit(codeStr.charAt(1)) && Character.isDigit(codeStr.charAt(2))) {
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public String toString() {
		return "Agency [code=" + code + ", name=" + name + ", adress=" + adress + ", arrayCustomer=" + arrayCustomer
				+ "]";
	}

	
	
}
