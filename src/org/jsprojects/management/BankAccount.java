package org.jsprojects.management;

import java.util.Scanner;

public class BankAccount {
	private long accountNumber; // 11 digit numeric
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	private float balance;
	private boolean overdraft;
	private String type;

	public void createBankAccount() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("Set : account Number");
		this.accountNumber = sc1.nextLong();

		if (Long.toString(accountNumber).length() < 11 && Long.toString(accountNumber).length() > 10) {
			System.out.println("Error:The length is incorrect. Please enter 11 digits");
			System.out.println("Set : account Number");
			this.accountNumber = sc1.nextLong();
		}

		System.out.println("Set : type");
		String choiceType = sc1.next();
		while (!choiceType.equals("Compte_courant") && !choiceType.equals("Livret_A") && !choiceType.equals("PEL")) {
			System.out.println("Eror:The type is incorrect. Please enter Compte_courant, Livret_A or PEL");
			System.out.println("Set : type");
			choiceType = sc1.next();
		}
		this.type = choiceType;

		balance = 0;
		overdraft = false;
		// sc1.close();
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", overdraft=" + overdraft
				+ ", type=" + type + "]";
	}

	/*
	 * public boolean equals(Object obj) { Scanner sc = new Scanner(System.in);
	 * System.out.println("Set : account Number"); this.accountNumber =
	 * sc.nextLong(); if (this == obj) return true; if (obj == null) return false;
	 * if (getClass() != obj.getClass()) return false; BankAccount other =
	 * (BankAccount) obj; return accountNumber == other.accountNumber; }
	 */

}
