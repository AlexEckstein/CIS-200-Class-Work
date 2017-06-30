
/**
This file provided to the student for modification
The Payroll class stores data about an employee's pay
*/
import java.text.NumberFormat;
import java.util.*;

public class Payroll {
	private String name; // Employee name
	private int idNumber; // 6-digit ID number
	private double payRate; // Hourly pay rate
	private double hoursWorked; // Number of hours worked

	private Scanner s = new Scanner(System.in);

	/**
	 * The constructor initializes an object with the employee's name and ID
	 * number.
	 * 
	 * @param n
	 *            The employee's name.
	 * @param i
	 *            The employee's ID number.
	 */
	public Payroll(String n, int i) {
		name = n;
		idNumber = i;
	}
	/**
	* The getName method gets the name of employee and adds it to the object
	* @return String of employee name
	*/
	public String getName() throws Exception {
		boolean valid = false;

		System.out.print("Enter first and last name: ");
		while (valid == false)
			try {
				name = s.nextLine();
				if (name.equals("") || name.isEmpty()) {
					throw new Exception();
				}
				valid = true;
			} catch (Exception e) {
				System.out.print("Name cannot be blank. Re-enter: ");
			}
		return name;

	}

	/**
	 * The getIdNumber returns the employee's ID number.
	 * 
	 * @return The employee's ID number.
	 */
	public int getIdNumber() throws NumberFormatException {
		System.out.print("Enter ID Number: ");
		idNumber = -1;
		
		while (idNumber == -1) {
			try {
				idNumber = Integer.parseInt(s.nextLine());
				
			} catch (NumberFormatException e) {
				idNumber = -1;
				System.out.print("Please re-enter a valid ID: ");
			}
		}
		return idNumber;
	}

	/**
	 * The getPayRate returns the employee's pay rate.
	 * 
	 * @return The employee's pay rate.
	 */
	public double getPayRate() throws NumberFormatException {
		System.out.print("Enter Pay Rate per hour: ");
		payRate = -1;
		
		while (payRate == -1) {
			try {
				payRate = Double.parseDouble(s.nextLine());

			} catch (NumberFormatException e) {
				payRate = -1;
				System.out.print("Please re-enter a valid Pay Rate: ");
			}
		}
		return payRate;
	}

	/**
	 * The getHoursWorked returns the hours worked by the employee.
	 * 
	 * @return The hours worked.
	 */
	public double getHoursWorked() throws NumberFormatException {
		System.out.print("Enter Hours Worked: ");
		hoursWorked = -1;
		
		while (hoursWorked == -1) {
			try {
				hoursWorked = Double.parseDouble(s.nextLine());

			} catch (NumberFormatException e) {
				hoursWorked = -1;
				System.out.print("Please re-enter valid time worked: ");
			}
		}
		return hoursWorked;
	}

	/**
	 * The getGrossPay returns the employee's gross pay.
	 * 
	 * @return The employee's gross pay.
	 */
	public double getGrossPay() {
		return hoursWorked * payRate;
	}
	/**
	* the addPayroll method lets the user input more employees 
	
	* @return returns a boolean value that is equal to true when the user
	* 		  wants to add more employees
	*/
	public boolean addPayroll() {
		boolean a = false;
		System.out.println("\nWould you like to enter another employee?");
		System.out.print("Press Enter for another employee or any other key to quit.");
		String readString = s.nextLine();
		
		if (readString.equals("") || readString.isEmpty()) {
			a = true;
		} else
			a = false;
		
		return a;
	}
	/**
	* the toString method turns elements from the object into a string for printing
	* @return returns a string of information for each object. 
	*/
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		return ("\n\nName: " + name + "\nID Number: " + idNumber + "\nPay for the week: "
				+ formatter.format(getGrossPay()));
	}
	/**
	* This method returns the id Number for each object
	* @return returns the integer value for employee ID numbers
	*/
	public int findId() {
		
		return idNumber;
	}
} // end class
