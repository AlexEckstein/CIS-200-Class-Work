 /*******************************************************************
* Lab1.java
* <Alex Eckstein / Section 1 1/21/2016/4:00>
*
* This program calculates and displays a purchase order amount.
*******************************************************************/
import java.util.Scanner;

public class Lab1 {
public static void main(String [] args) {

String input1;
String input2;
String input3;// read in user input as a string
 // price of purchase item
 // number of items purchased
Scanner s = new Scanner(System.in);

System.out.print("Price of purchased item: "); // user prompt
 input1 = s.nextLine(); // read input as a string
 	
double price= Double.valueOf(input1);

 System.out.print("Quantity: "); 	// user prompt				
input2 = s.nextLine(); // read input as a string
int qty= Integer.valueOf(input2);									
 
 System.out.print("Tax Rate(i.e. 0.07): ");
 input3 = s.nextLine();
 double taxRate= Double.valueOf(input3);
 
 double totalPrice = price * qty;
double tax = totalPrice * taxRate;
 System.out.print("Total purchase order = $");
 System.out.println(price);
   // displays the final amount

 // display the final amount w/2 decimals using printf
 System.out.printf("Total purchase order without tax = $%.2f\n", price * qty);
System.out.printf("tax $%.2f\n", tax);
 // display the final amount w/2 decimals using String.format
 String output = String.format("Total purchase order = $%.2f\n", price * qty + tax);
 System.out.println(output);
											// System.out.print(String.format("Tax: $%.2f", amount));
 } // end main
 } // end class Lab1