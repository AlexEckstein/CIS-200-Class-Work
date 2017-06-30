
/*******************************************************************
* Proj4.java
* <Alex Eckstein / Section A 2/26/2016/4:00>
*
* This program imports a file with a list of words, into arrays that
* scramble and hold the words to be implimented into a jumble game.
*******************************************************************/
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Proj4 {
	
	// Declaration for scanner
	static Scanner s = new Scanner(System.in);
	static String input = null;

	// Declaration for random value
	static int r = 0;
	static Random randomNumbers = new Random();
	
	// Declaration for hints
	static int hintRand = 0;
	static char hint;
	
	// String that saves file variables
	static String fileName = null;
	static int fileLength = 0;

	// Array that holds words from file
	static String[] wordArray;

	// Declaration for individual char array
	static char[] charArray;

	// Keeps track of word length
	static int wordLength = 0;

	// Values used for for loops
	static int j = 0;
	static int x = 0;
	static int i = 0;

	// Values for game
	static String gameWord = null;
	static boolean gameActive = false;
	static String guess = null;
	static int wordPoints = 0;
	static int finalScore = 0;
	
	// WordShuffle values
	static String shuffledWord = null;
	static int shuffleCount = 8;
	static int slot1 = 0;
	static int slot2 = 0;

	
	// Main Method
	public static void main(String args[]) throws IOException {

		FileToArray();
		Game();
		//RandomWord();
	
	} // End of Main

	// Method that inputs files to array
	public static void FileToArray() throws IOException {

		// Input for file directory
		System.out.print("Enter in text file containing words (Ex: words.txt): ");
		fileName = s.nextLine();
		System.out.println();
		// Grabs file and inputs into array
		try {

			// Readers for file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			// random value for selecting word
			String arrayLength = br.readLine();
			fileLength = Integer.parseInt(arrayLength);
			
			wordArray = new String[fileLength];
			
			r = randomNumbers.nextInt(fileLength) + 1;
			
			// Reads file into array to hold words
			for (j = 0; j < wordArray.length; j++) {
				wordArray[j] = br.readLine();

			}
			// Closes Buffered Reader
			br.close();

			// Initialize CharArray based on String length
			wordLength = wordArray[r].length();
			gameWord = wordArray[r];
			charArray = new char[wordLength];

			// Reads string into char array for scrambling
			for (x = 0; x < wordLength; x++) {
				charArray[x] = wordArray[r].charAt(x);
			}

		}
		// In case the file cannot be found, print error
		catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		}
	}// End of FileToArray

	// Method that changes word to random
	public static void RandomWord() {
		
		// random value for selecting word
		r = randomNumbers.nextInt(fileLength) + 1;
		wordLength = wordArray[r].length();
		gameWord = wordArray[r];
		
		charArray = new char[wordLength];
		

		// Reads string into char array for scrambling
		for (int z = 0; z < wordLength; z++) {
			charArray[z] = wordArray[r].charAt(z);
		}
		
		
	}

	// Method for game runtime
	public static void Game() throws IOException {
		
		String shuffled = WordShuffle(gameWord);
		wordPoints = 10;
		gameActive = true;
		
		while (gameActive = true) {
			shuffled = WordShuffle(gameWord);
			System.out.println("Current puzzle: " + shuffled);
			System.out.println("Current points for word: " + wordPoints);
			System.out.print("Enter (g)uess, (n)ew word, (h)int, or (q)uit: ");
			input = s.nextLine();
			System.out.println();

			if (input.equalsIgnoreCase("g")) {
				System.out.print("Enter your guess: ");
				guess = s.nextLine();

				if (guess.equalsIgnoreCase(wordArray[r])) {
					System.out.println("You guessed it!");
					System.out.println("Score for word: " + wordPoints);
					finalScore =+ wordPoints; 
					System.out.println("Total Score: " + finalScore);
					System.out.println();
					wordPoints = 10;
					RandomWord();
				} else {
					if(wordPoints != 0){
						wordPoints--;
					}
					System.out.println("Oops! Try again.");
					System.out.println();
				}

			} else if (input.equalsIgnoreCase("h")) {
				wordPoints = wordPoints/2;
				GetRandomHint();
				int hintSpot = hintRand + 1;
				System.out.println("The letter at spot "+ hintSpot +" is " + hint);
				System.out.println();
				
			} else if (input.equalsIgnoreCase("q")) {
				
				System.out.println("Goodbye!");
				System.out.println("Final score: " + finalScore);
				System.exit(0);
				
			}else if(input.equalsIgnoreCase("n")){
				wordPoints = 10;
				RandomWord();
				
				
			}else{
			
				System.out.println("Invalid Choice - 'g', 'n' 'h' or 'q' only.\n");
			}
		}
	}
	
	public static void GetRandomHint(){
		hintRand = randomNumbers.nextInt((wordLength)-1) + 1;
		hint = gameWord.charAt(hintRand);
	}

    //Swaps the characters to be used in WordShuffle
	private static String swapCharacter(String shuffledWord ,int slot1,int slot2) {
		
		char temp = charArray[slot1];
		charArray[slot1] = charArray[slot2];
		charArray[slot2] = temp;
		return new String(charArray);
	}

	//Swaps characters randomly 8 times
    public static String WordShuffle(String gameWord) {

        shuffledWord = gameWord; // start with original

        wordLength = gameWord.length();
        for(int i=0;i<shuffleCount;i++) {
            
            slot1 = ThreadLocalRandom.current().nextInt(0, wordLength);
            slot2 = ThreadLocalRandom.current().nextInt(0, wordLength);
            shuffledWord = swapCharacter(shuffledWord,slot1,slot2);
        }
        return shuffledWord;
        
    } //End of WordShuffle
} //End of Class
