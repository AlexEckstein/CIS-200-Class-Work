
/*******************************************************************
* lab6.java
* <Alex Eckstein / Section A 2/4/2016/4:00>
*
* This program uses methods to input variables about a loan. It will
* then output the monthly rate, amount paid, and amount paid in interest.
*******************************************************************/
import java.util.*;

public class lab6 {

	public static void main(String[] args) {

		double interestRate; // holds MONTHLY interest rate
		double loanAmount; // Amount of the Loan
		int years; // Length of the Loan
		double monthlyPayment; // Monthly Payment required

		interestRate = getRate();

		loanAmount = getAmount();
		years = getYears();

		monthlyPayment = calcMonthlyPayment(years, loanAmount, interestRate);
		double totalPaid = monthlyPayment * years * 12;
		double interestPaid = totalPaid - loanAmount;
		displayOutput(monthlyPayment, totalPaid, interestPaid);

	}// end of main

	public static double getRate() {
		boolean valid = true;
		double interestRate;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter yearly interest rate (Ex 8.25): ");

		String input = s.nextLine();

		interestRate = Double.parseDouble(input);

		while (interestRate > 12 || interestRate < 3) {
			System.out.println("Valid interest rates are 3%-12%.");
			System.out.print("Please re-enter: ");
			interestRate = s.nextDouble();
		}
		interestRate *= .01;
		return interestRate;
	}// end of getRate

	public static double getAmount() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter loan amount (Example 120000.95): ");
		String input = s.nextLine();

		double loanAmount = Double.parseDouble(input);

		while (loanAmount < 50000 || loanAmount > 1000000) {
			System.out.println("Valid loan amount is between $50,000-$1,000,000.");
			System.out.print("Please re-enter: ");
			loanAmount = s.nextDouble();
		}
		return loanAmount;
	}// end of getAmount

	public static int getYears() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of years (as an integer): ");
		String input = s.nextLine();

		int years = Integer.parseInt(input);

		while (years < 1 || years > 50) {
			System.out.println("Valid loan length is between 1 - 50 years.");
			System.out.print("Please re-enter: ");
			years = s.nextInt();
		}
		return years;
	}// end of getYear

	public static double calcMonthlyPayment(int years, double loanAmount, double interestRate) {

		int months = years * 12;
		double monthlyInterest = interestRate / 12;
		double monthlyPayment = loanAmount * (monthlyInterest * (Math.pow((1 + monthlyInterest), months)))/ (Math.pow((1 + monthlyInterest), months) - 1);
		return monthlyPayment;
	} // end of calcMonthlyPayment

	public static void displayOutput(double monthlyPayment, double totalPaid, double interestPaid) {
		System.out.printf("\nThe monthly payment is %.2f", monthlyPayment);
		System.out.printf("\nThe total paid on loan is %.2f", totalPaid);
		System.out.printf("\nThe total interest paid on loan is %.2f", interestPaid);
	} // end displayOutput

}
