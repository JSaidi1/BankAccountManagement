package org.jsprojects.management;

import java.util.Scanner;

public class Agency {
	private String code;//3 digit
	private String name;
	private String adress;
	
	/*
	public Agency() {
		super();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set : agency code:");
		this.code = sc.nextLine();
		
		System.out.println("Set : agency name:");
		this.name = sc.nextLine();
		
		System.out.println("Set : agency adress:");
		this.adress = sc.nextLine();
	}*/
	
	public void createAgency() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set : agency code:");
		//this.code = sc.nextLine();
		
		
		System.out.println("Set : agency name:");
		this.name = sc.nextLine();
		
		System.out.println("Set : agency adress:");
		this.adress = sc.nextLine();
	}
	
	public boolean id_codeIsValid(String codeStr){
		
	}

	@Override
	public String toString() {
		return "Agency [code=" + code + ", name=" + name + ", adress=" + adress + "]";
	}
	
	
}
