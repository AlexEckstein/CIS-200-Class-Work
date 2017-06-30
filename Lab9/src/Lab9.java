/*******************************************************************
* Lab9.java
* <Alex Eckstein / Section A 4/07/2016/4:00>
*
* This class contains the main method used for the program.
*******************************************************************/
public class Lab9 {

	public static void main(String[] args) {
		
		View viewer = new View();
		String message = viewer.getMessage();
		
		Cipher c = new Cipher(viewer.getKey());
		String encrypted = c.encrypt(message);
		System.out.print("Encrypted message: ");
		viewer.displayResult(encrypted);
		String decrypted = c.decrypt(encrypted);
		System.out.print("Decrypted message: ");
		viewer.displayResult(decrypted);
	}

}