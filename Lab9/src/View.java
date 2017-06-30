
/*******************************************************************
* View.java
* <Alex Eckstein / Section A 4/04/2016/4:00>
*
* This is the console class. It contains the methods used for getting
* the key and message to be encrypted.
*******************************************************************/
import java.util.*;

public class View {
	private Scanner s;

	// Constructor
	public View() {
		s = new Scanner(System.in);
	} // end Constructor

	public String getMessage() {
		System.out.print("Enter message: ");

		return s.nextLine();
	} // end getMessage()

	public int getKey() throws NumberFormatException {
		int key = -1;
		
		while (key == -1) {
			try {
				System.out.print("Enter in a key (Ex: 1-25): ");
				key = Integer.parseInt(s.nextLine());

			} catch (NumberFormatException e) {
				key = -1;
			}
		}
		System.out.println("Your key is: " + key);
		return key;
	} // end getKey()

	public void displayResult(String msg) {

		System.out.println(msg);
	} // end displayResult

} // end class