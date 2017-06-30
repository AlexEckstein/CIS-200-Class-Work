/*******************************************************************
* Lab10.java
* <Alex Eckstein / Section A 2/4/2016/4:00>
*
* This is the control class for the Account class.
*******************************************************************/
import java.util.*;
import java.io.*;

public class Lab10 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Account> list = new ArrayList<Account>();

		Scanner s = new Scanner(System.in);
		System.out.print("Enter the name of the input file: ");
		boolean validInput = false;

		while (validInput == false) {
			try {
				String fileName = s.nextLine();
				Scanner read = new Scanner(new File(fileName));

				read.useDelimiter(",|\\n");
				while (read.hasNext()) {
					try {
						int accountNum = read.nextInt();
						String name = read.next();
						double amount = Double.parseDouble(read.next());

						Account a = new Account(accountNum, name, amount);

						list.add(a);
					} catch (InputMismatchException e) {
						System.out.println("File has invalid data type. Skipping over");
					} catch (NumberFormatException e) {
						System.out.println("File has invalid data type. Skipping over");

					}
					validInput = true;
				}
			} catch (FileNotFoundException e) {
				System.out.print("File not found. Check filename and rerun program ");
			}
		}
		char option;
		do {
			System.out.print("Enter (p)rint, (d)eposit, (w)ithdrawal, (l)ookup, or (q)uit: ");
			option = (s.nextLine()).charAt(0);
			switch (option) {
			case 'p': // print - find and display and account object
				System.out.print("Enter account number: ");
				int num = Integer.parseInt(s.nextLine());

				Account a = find(list, num);
				System.out.println(a);
				break;

			case 'd': // deposit money into an account
				System.out.print("Enter account number: ");
				num = Integer.parseInt(s.nextLine());
				boolean validDepo = false;
				a = find(list, num);

				System.out.print("Enter deposit amount: ");
				while (validDepo == false) {

					try {
						double dep = Double.parseDouble(s.nextLine());

						a.deposit(dep);
						validDepo = true;
					} catch (NumberFormatException e) {
						System.out.print("Please re-enter a valid amount to deposit: ");
					}
				}
				break;

			case 'w': // withdraw money from an account
				System.out.print("Enter account number: ");
				num = Integer.parseInt(s.nextLine());
				a = find(list, num);
				boolean validWith = false;
				System.out.print("Enter withdrawal amount: ");
				while (validWith == false) {
					try {
						double with = Double.parseDouble(s.nextLine());
						a.withdrawal(with);
						validWith = true;
					} catch (NumberFormatException e) {
						System.out.print("Please re-enter a valid amount to withdrawl: ");
					}
				}
				break;

			case 'l': // lookup - find an account and display using account name
				System.out.print("Enter name: ");
				String name = s.nextLine();
				int x = 0;
				int y = list.size();
				int tempNum = 0;

				Account temp = new Account(0, null, 0);

				for (x = 0; x < y; x++) {
					temp = list.get(x);
					if (temp.getName().equalsIgnoreCase(name)) {

						tempNum = temp.getNum();
					}
				}
				System.out.println("The account number for " + name + " is " + tempNum);

				break;
			} // end switch
		} while (option != 'q');
	} // end main

	public static Account find(ArrayList<Account> accounts, int num) {
		int x;
		Account temp = new Account(0, null, 0);
		Account temp2 = new Account(0, null, 0);
		int y = accounts.size();

		for (x = 0; x < y; x++) {
			temp = accounts.get(x);
			if (temp.getNum() == num) {
				temp2 = accounts.get(x);
			}
		}

		// loop through accounts, calling get to get each account (or using an
		// Iterator)
		// for each account, see if object's account number matches the number
		// entered by user
		// if found, return that account

		// leave this at the very end of the method in case the account isn't
		// found
		return temp2;
	} // end find
}