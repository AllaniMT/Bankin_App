package BankApplication;

import java.util.Scanner;

public class BankApp {
	public static void main  (String [] args ) {
		ClientAccount clientaccount = new ClientAccount ("John","131");
		clientaccount.showMenu();
	}
}

class ClientAccount{
	int balance; 
	int previousTransaction; 
	String clientName; 
	String clientId; 

	ClientAccount(String cname, String cid){
		clientName = cname;
		clientId = cid;
	}
	
	void deposit (int amount) {
	if (amount != 0) {
		balance = balance + amount;
		previousTransaction = amount;	
	}
	}
	
	void withdraw (int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
		}
	
	void getPreviousTransaction() {
		if (previousTransaction> 0) {
			System.out.println("Deposited :" + previousTransaction);
		} 
		else if (previousTransaction<0) {
			System.out.println("withdraw :" +Math.abs(previousTransaction));// To show the positive Value
		}
		else {
			System.out.println("No transaction occured ");
			
		}
	}
	
	void showMenu() {
		char option ='\0';
		Scanner scanner = new Scanner (System.in);
		System.out.println("Hello " + clientName);
		System.out.println("Your id is: " + clientId);
		System.out.println("\n");
		System.out.println("A. check a Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Eithdraw");
		System.out.println("D.Previous transaction");
		System.out.println("E.Exit");
		
		do {
			System.out.println("=================================");
			System.out.println("Enter an option Please");
			System.out.println("=================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option)
			{
			case 'A':
				System.out.println("--------------------------------");
				System.out.println("Balnace = "  + balance);
				System.out.println("--------------------------------");
				System.out.println("\n");
				break;
			case 'B':
				System.out.println("--------------------------------");
				System.out.println("enter a amount to deposit");
				System.out.println("--------------------------------");
				int amount =scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("--------------------------------");
				System.out.println("enter a amount to withdraw");
				System.out.println("--------------------------------");
				int amount2 =scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("--------------------------------");
				getPreviousTransaction();
				System.out.println("--------------------------------");
				System.out.println("\n");
				break;
			case 'E':
				System.out.println("*************");
				break;
				default:
					System.out.println("Invalid option !!!. Please enter another option");
					break;
			}
			
		}while (option!= 'E');
		
		System.out.println("Thank you for using our services");
	}
	
}


