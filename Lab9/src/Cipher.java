/*******************************************************************
* Cipher.java
* <Alex Eckstein / Section A 4/07/2016/4:00>
*
*class the encrypts and decrypts the message
*******************************************************************/

public class Cipher {
	private int key;

// Constructor	
	public Cipher(int k) {
		key = k;
	} // end Constructor

	public String encrypt(String message) {
		
		StringBuilder newMessage = new StringBuilder(message);
		
		for (int x = 0; x < message.length(); x++){
			
			char y = message.charAt(x);
			y += key;
			
			//wrap around the alphabet
			if (y > 122){
				y -= 26;
			}
			message.charAt(x);
			newMessage.setCharAt(x, y);

			}
		
		message = newMessage.toString();
		
		return message;
	} // end encrypt()

	public String decrypt(String message) {
		
		StringBuilder newMessage = new StringBuilder(message);
		
		for (int x = 0; x < message.length(); x++){
			char y = message.charAt(x);
			y -= key;
			
			//wrap around the alphabet
			if (y < 97){
				y += 26;
			}
			newMessage.setCharAt(x, y);
		}
		message = newMessage.toString();
		
		return message;
	} // end decrypt()
	
} // end class