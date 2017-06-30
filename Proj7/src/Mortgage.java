
/*******************************************************************
* Mortgage.java
* <Alex Eckstein / Section A 4/04/2016/4:00>
*
* This class contains the methods and private variables needed for 
* the program.
*******************************************************************/
import java.text.NumberFormat;
import java.util.*;

public class Mortgage {

	// Private Variables
	private Scanner s = new Scanner(System.in);
	private double interestRate;
	private int loanTerm;
	private double loanAmount;
	private int accountNumber;
	private String lastName;

	/** Mortgage
	* constructor used for creating mortgages
	*
	* @param interestRate - holds interest rate
	* @param loanTerm - holds term of loan
	* @param loanAmount - amount of loan
	* @param accountNumber - number of account
	* @param lastName - last name of account holder
	*/
	public Mortgage(double interestRate, int loanTerm, double loanAmount, int accountNumber, String lastName) {
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.loanAmount = loanAmount;
		this.accountNumber = getAccountNumber();
		this.lastName = lastName;
	}

	/** Mortgage
	* default constructor
	*/
	public Mortgage() {

	}

	/** storeLastName
	* gets input from user and stores to lastName
	*/
	public void storeLastName() {

		System.out.print("\nEnter customer's Last Name Only: ");
		String input = s.nextLine();
		lastName = input.substring(0, Math.min(input.length(), 4));
	}
	/** getAccountNumber
	* creates an account number for user
	* 
	* @return random int value
	*/
	private int getAccountNumber() {

		// 100 is the 9900 is the range of random numbers
		int randomNum = 100 + (int) (Math.random() * 9900);
		return randomNum;
	}
	/** storeLoanAmount
	* lets users input and verifies input is proper. Saves
	* input to loanAmount.
	*/
	public void storeLoanAmount() throws NumberFormatException {
		loanAmount = -1;

		System.out.print("\nEnter the amount of the loan (Ex:75000): $");

		while (loanAmount == -1) {
			try {
				loanAmount = Double.parseDouble(s.nextLine());

				if (loanAmount > 1000000 || loanAmount < 75000) {
					System.out.println("\tValid Loan Amounts are $75000-$1000000");
					System.out.print("\tPlease re-enter loan amount without $ or commas(Ex:75000): ");

					loanAmount = -1;
				}
			} catch (NumberFormatException e) {
				loanAmount = -1;
				System.out.print("\tPlease re-enter loan amount without $ or commas (Ex 75000): $");

			}
		}
	}
	/** storeInterestRate
	* inputs interest rate from user and verifies
	*/
	public void storeInterestRate() {
		System.out.print("\nEnter yearly interest rate (Ex: 8.25): ");
		interestRate = -1;
		while (interestRate == -1) {
			try {
				interestRate = Double.parseDouble(s.nextLine());

				if (interestRate < 2.0 || interestRate > 7.0) {
					System.out.println("\tValid Interest Rates are 2% - 7%");
					System.out.print("\tPlease re-enter valid yearly interest rate(Ex:8.25): ");
					interestRate = -1;
				}
			} catch (NumberFormatException e) {
				System.out.println("\tValid Interest Rates are 2% - 7%");
				interestRate = -1;
			}
		}
		interestRate = interestRate / 12.0;
		interestRate = interestRate * .01;
	}
	/** storeTerm
	* inputs term of loan from user and verifies
	*/
	public void storeTerm() {
		loanTerm = -1;

		System.out.print("\nEnter number of years for the loan: ");

		while (loanTerm == -1) {
			try {

				loanTerm = Integer.parseInt(s.nextLine());

				if (loanTerm > 40 || loanTerm < 10) {
					System.out.println("\tValid Loan Terms are 10-40");
					System.out.print("\tPlease re-enter valid number of years: ");
					loanTerm = -1;

				}
			} catch (NumberFormatException e) {
				loanTerm = -1;
				System.out.println("\tValid Loan Terms are 10-40");
				System.out.print("\tPlease re-enter valid number of years: ");
			}
		}
		loanTerm = loanTerm * 12;
	}
	/** calcMonthlyPayment
	* calculates the monthly payment

	* @return double monthlyPayment
	*/
	private double calcMonthlyPayment() {
		double monthlyPayment = (loanAmount * interestRate * Math.pow(1 + interestRate, loanTerm)
				/ (Math.pow(1 + interestRate, loanTerm) - 1));

		return monthlyPayment;
	}
	/** calcTotalPayment
	* calculates the total payment based off monthly
	* 
	* @return double totalPayment
	*/
	private double calcTotalPayment() {
		double totalPayment = calcMonthlyPayment() * loanTerm;

		return totalPayment;
	}
	/** Mortgage createPromoLoan
	* creates a promotional loan by calling methods
	*
	* @return promoMortgage - mortgage object
	*/
	public Mortgage createPromoLoan() {
		Mortgage promoMortgage = new Mortgage(.032 / 12.0, 240, 250000.00, getAccountNumber(), lastName);
		promoMortgage.storeLastName();
		promoMortgage.getAccountNumber();

		return promoMortgage;
	}
	/** createUniqueLoan
	* create a unique loan by calling methods
	* 
	* @return mortgage1 - mortgage object created through methods
	*/
	public Mortgage createUniqueLoan() {
		Mortgage mortgage1 = new Mortgage(interestRate, loanTerm, loanAmount, accountNumber, lastName);
		mortgage1.storeLastName();
		mortgage1.getAccountNumber();
		mortgage1.storeLoanAmount();
		mortgage1.storeInterestRate();
		mortgage1.storeTerm();
		mortgage1.toString();
		return mortgage1;
	}
	/** toString
	* method that takes a mortgage object and converts for printing
	* 
	* @return String that prints the required output for the program to work
	*/
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return ("\nAccount number: " + lastName + accountNumber + "\nThe monthly payment is "
				+ formatter.format(calcMonthlyPayment()) + "\nThe total payment is "
				+ formatter.format(calcTotalPayment()) + "\n");
	}
}
