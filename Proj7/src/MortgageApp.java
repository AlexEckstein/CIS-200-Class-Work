
/*******************************************************************
* MortgageApp.java
* <Alex Eckstein / Section A 4/04/2016/4:00>
*
* This class contains the main method used for the program.
* This program will calculate the loans, give users a random account 
* number for their last name and output the desired loan's monthly 
* cost and overall costs into an array.
*******************************************************************/
import java.util.*;

public class MortgageApp {


	public static void main(String[] args) {

		selection();

	} // end of main
	
	/** selection
	* only method that main method calls, it starts the selection screen
	* and calls functions based upon user input. When creating mortgages,
	* they are saved in the selection function.
	*/
	public static void selection() {
		Scanner s = new Scanner(System.in);
		Mortgage[] mortgage = new Mortgage[10];
		
		//values used to track position and whether to input more
		int x = 0; 
		boolean running = true;
		
		//while number of mortgages is less than 11 and user hasn't quit
		while (x < 10 && running == true) {
			
			// Print the menu
			System.out.println("Please choose from the following choices below:");
			System.out.println("\t 1) Promotional Loan (preset loan amount, rate, term)");
			System.out.println("\t 2) Unique Loan (enter in loan values)");
			System.out.println("\t 3) Quit (Exit the program)");
			System.out.print("\n\t Please enter the selection(1-3): ");
			String selection = s.nextLine();

			// test for valid input
			while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3")) {

				System.out.print("\t\tInvalid Choice. Please select 1, 2, or 3: ");
				selection = s.nextLine();
			}

			// call methods based upon selection
			if (selection.equals("1")) {
				
				Mortgage promoMortgage = new Mortgage();
				mortgage[x] = promoMortgage.createPromoLoan();
				System.out.println(mortgage[x].toString());
				
				x++;
			} else if (selection.equals("2")) {
				
				Mortgage mortgage1 = new Mortgage();
				mortgage[x] = mortgage1.createUniqueLoan();
				System.out.println(mortgage[x].toString());
				x++;

			} else if (selection.equals("3")) {
				System.out.println("\nPROGRAM COMPLETE");
				System.out.println("Contents of Array..");

				for (int y = 0; y < x; y++) {
					System.out.println(mortgage[y].toString());
				}
				running = false;

			}
		}
		if(x == 10){
			
			System.out.println("\nPROGRAM COMPLETE");
			System.out.println("Contents of Array..");
			
			for (int y = 0; y < x; y++) {
				System.out.println(mortgage[y].toString());
			}
			System.out.println("\tArray is now full");
		}
	} // end of selection

} // end of class
