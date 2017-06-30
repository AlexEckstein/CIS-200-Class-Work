
/*******************************************************************
* Lab5.java
* <Alex Eckstein / Section A 2/26/2016/4:00>
*
* This program imports passwords into an array and converts it to ASCII then
* adds it to a file
*******************************************************************/
import java.io.*;
import java.util.*;

public class lab5 {
	
	private static Scanner s;
	static boolean passHasSpecial = false;
	static String input = null;
	static int passwordLength = 0;
	static boolean valid = true;
	static boolean reEnter = false;
	static String password2 = null;
	static int passASCII = 0;

	// Arrays
	static int asciiVal;
	static char[] passwordArray;
	static char[] specialCh;

	public static void SaveFile() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("Lab5.txt");

		for (int x = 0; x < passwordLength; x++) {
			asciiVal = (int) (passwordArray[x]);
			writer.print(asciiVal);
			writer.print(",");
		}
			writer.print("0");
		    writer.println();
		    writer.println("87656786 98");
		    writer.println("89273641 67");
		    writer.println("82839485 78");
		    writer.println("89127364 87");
		    writer.println("84567456 78");
		    writer.println("87456767 99");

		    writer.close();

		  
		writer.close();
	}

	public static void PasswordCheck() {
		int check = 0;

		if (check == 0) {
			if (passwordLength <= 8) {
				System.out.println("Invalid password – must be at least 8 characters");
				valid = false;
				GetPassword();
			}
			if (input.matches(".*\\d.*")) {
				check++;

			} else {
				System.out.println("Invalid password – must contain at least one digit");
				valid = false;
				check++;
				GetPassword();
			}
			if (passHasSpecial == false) {
				System.out
						.println("Invalid password – must contain at least one of the following characters: ! @ # $ *");
				valid = false;
				check++;
				GetPassword();
			} 
			else{
				check++;
				ReEnter();
			}

		}
	}
	public static void ReEnter() {
		System.out.print("Please Re-enter Password to confirm : ");
		password2 = s.nextLine();

		if (password2.equals(input)) {
			reEnter = true;
		}else {
			reEnter = false;
			ReEnter();
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		GetPassword();

		if (reEnter = true) {
			SaveFile();
		}

	}

	public static void GetPassword() {
		char[] specialCh = { '!', '@', '#', '$', '*' };

		s = new Scanner(System.in);

		System.out.println("Password needs to have 8 characters, 1 digit, and at least 1 special character");
		System.out.print("Please input a password: ");
		input = s.nextLine();
		passwordLength = input.length();
		passwordArray = new char[passwordLength];

		// inputs password string into array
		for (int x = 0; x < passwordLength; x++) {

			// checks individual char for special char
			passwordArray[x] = input.charAt(x);
			for (int y = 0; y < 5; y++) {

				if (passwordArray[x] == specialCh[y]) {
					passHasSpecial = true;

				}

			}
		}
		PasswordCheck();
	}
}
