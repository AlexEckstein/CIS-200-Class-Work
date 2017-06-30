
/*******************************************************************
* Proj5.java
* <Alex Eckstein / Section A 3/11/2016/4:00>
*
* This program imports a scantron file into an array, grades 
* individual scores, calculates class averages, and creates a
* result file called "Result.txt".
*******************************************************************/
import java.io.*;
import java.util.*;
import java.text.*;

public class Proj5 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = getFileName();

		// save variables from methods
		double questionAmount = getQuestionAmount();
		int questionWorth = getQuestionWorth();
		int answerKey[] = getAnswerKey(questionAmount);
		int numOfStudents = getNumOfStudents(fileName);

		// Declarations for method arrays
		int[] numCorrectArr = new int[numOfStudents];
		int[] score = new int[numOfStudents];
		char[] grade = new char[numOfStudents];
		double[] numPercent = new double[numOfStudents];

		// reads file from method
		String[][] scantronImport = fileReader(fileName, questionAmount, numOfStudents);

		// position in several arrays. x is the individual student
		int x = 0;
		
		// for loop that calls methods and uses x value for position in arrays
		for (x = 0; x < numOfStudents; x++) {

			// temporary array that created from method that is used for grading
			int[] testArray = testArrayToInt(scantronImport, x, questionAmount);

			// calculates number correct and imports it into array
			int singleNumCorrect = gradeSingle(testArray, answerKey);
			numCorrectArr[x] = singleNumCorrect;

			//calculates the score for a single student and imports to array
			int scoreSingle = singleNumCorrect * questionWorth;
			score[x] = scoreSingle;

			//calculates the percent for test and imports to an array
			double numPercentSingle = singleNumCorrect * 100 / questionAmount ;
			numPercent[x] = numPercentSingle;
			
			//gets the letter grade and imports to an array
			char getLetterGrade = getLetterGrade(numPercentSingle);
			grade[x] = getLetterGrade;
			
		}
		//calls for result methods and file creation method
		printScores(scantronImport, numCorrectArr, numPercent, score, grade, numOfStudents);
		printClassAverage(numCorrectArr, numPercent, numOfStudents, questionWorth);
		createResultFile(scantronImport, numCorrectArr, numPercent, score, grade, numOfStudents);

	}// end of main

	/** getFileName
	* (gets the file name from user)
	* @return (fileName)
	*/
	public static String getFileName() throws IOException {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter name of quiz file (i.e. QuizScores.txt): ");
		String fileName = s.nextLine();

		// Checks to make sure file exists
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			br.close();
			return fileName;
			
		} catch (FileNotFoundException e) {
			System.out.println("Error! File does not exist.");
			fileName = getFileName();
		}
		return fileName;
	}// end of getFileName

	/** getQuestionAmount
	* (gets the number of questions from user)
	* 
	* @return (questionAmount)
	*/
	public static double getQuestionAmount() {
		Scanner s = new Scanner(System.in);
		double questionAmount = 0;
		System.out.print("Please enter the number of questions on the exam: ");
		questionAmount = Integer.parseInt(s.nextLine());

		return questionAmount;
	}// end of getQuestionAmount

	/** getQuestionWorth
	* (gets the worth of each question from user)
	*
	* @return (questionWorth)
	*/
	public static int getQuestionWorth() {
		Scanner s = new Scanner(System.in);
		int questionWorth = 0;
		System.out.print("Please enter the number of points per questions: ");
		questionWorth = Integer.parseInt(s.nextLine());

		return questionWorth;
	}// end of getQuestionWorth

	/** getAnswerKey
	* (lets the user input answers into an array)
	*
	* @param (questionAmount - method requires the amount of questions for length of array)
	* @return (answerKey - int array that was inputed by user)
	*/
	public static int[] getAnswerKey(double questionAmount) {
		Scanner s = new Scanner(System.in);

		int[] answerKey = new int[(int) questionAmount];
		System.out.println("\nPlease enter the answers for the following questions");
		System.out.println("where'T' = true, 'F' = false, or A, B, C, D, E for multiple choice");

		for (int x = 0; x < questionAmount; x++) {
			System.out.print(x + 1 + ") ");
			String input = s.nextLine();
			input = input.toLowerCase();

			if (input.length() > 1 || input.length() == 0) {
				System.out.println("Error! Input one character at a time");
				x--;
			} else if (input.charAt(0) == 'a' || input.charAt(0) == 'b' || input.charAt(0) == 'c'
					|| input.charAt(0) == 'd' || input.charAt(0) == 'e' || input.charAt(0) == 't'
					|| input.charAt(0) == 'f') {
				answerKey[x] = input.charAt(0);

				if (answerKey[x] == 'a') {
					answerKey[x] = 1;
				} else if (answerKey[x] == 't') {
					answerKey[x] = 1;
				} else if (answerKey[x] == 'f') {
					answerKey[x] = 2;
				} else if (answerKey[x] == 'b') {
					answerKey[x] = 2;
				} else if (answerKey[x] == 'c') {
					answerKey[x] = 3;
				} else if (answerKey[x] == 'd') {
					answerKey[x] = 4;
				} else if (answerKey[x] == 'e') {
					answerKey[x] = 5;
				}
			} else {
				System.out.println("Error! Input is not applicable");
				x--;
			}
		}
		s.close();
		return answerKey;
	}// end of getAnswerKey
	
	/** fileReader
	* (reads the file into a String Array)
	*
	* @param (fileName - used to find the file)
	* @param (questionAmount - used for the length of the array)
	* @param (numberOfStudents - used for the length of the array)
	* @return (fileReader - returns the array of the file)
	*/
	public static String[][] fileReader(String fileName, double questionAmount, int numberOfStudents)
			throws FileNotFoundException {

		//holds the values for file array
		String[][] fileReader = new String[numberOfStudents][(int) questionAmount];

		try {
			
			Scanner s = new Scanner(new File(fileName));
			int b = 0;
			int x = 0;

			while (s.hasNextLine() && x < numberOfStudents) {

				s.useDelimiter(",|\n");
				// gets value of ID
				String i = s.next();
				fileReader[x][b] = i;
				
				// gets value of quiz answers
				i = s.nextLine().substring(1);
				b++;
				fileReader[x][b] = i;
				
				// values that increment the array
				x++;
				b--;

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return fileReader;
	}// end of fileReader

	/** getNumOfStudents
	* (reads the number of students in file)
	*
	* @param (fileName - name used to read file)
	* @return (numOfStudents - number of students in file)
	*/
	public static int getNumOfStudents(String fileName) throws FileNotFoundException {
		int numOfStudents = 0;

		try {

			File file = new File(fileName);
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				String input = s.nextLine();
				numOfStudents++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error! File does not exist.");

		}

		return numOfStudents;
	}//end of getNumStudents method

	/** testArraytoInt
	* (converts the scantronImport to a temporary integer array for grading)
	*
	* @param (scantronImport - used for creating array)
	* @param (x - used for the position in the scantronImport Array)
	* @param (questionAmount - used for length of array)
	* @return (testArray - scantronArray's second collumn split and into an array)
	*/
	public static int[] testArrayToInt(String[][] scantronImport, int x, double questionAmount) {
		//temporary storage for array, holds 1 value at a time
		char answer;
		
		//holds the value of fileArray into a string for splitting
		String test = scantronImport[x][1];

		int[] testArray = new int[(int) questionAmount];

		// convert String into integer array
		for (int i = 0; i < questionAmount; i++) {
			answer = test.charAt(i);
			
			testArray[i] = answer;
			
			// changes values in array for grading in next method
			if(testArray[i] == 49){
				testArray[i] = 1;
			}else if( testArray [i] == 50){
				testArray[i] = 2;
			}else if( testArray [i] == 51){
				testArray[i] = 3;
			}else if( testArray [i] == 52){
				testArray[i] = 4;
			}else if( testArray [i] == 53){
				testArray[i] = 5;
			}
		}
		return testArray;
		
	} // End of testArrayToInt
	
	/** gradeSingle
	* (grades a single test from a temp array created in testArrayToInt())
	*
	* @param (int[] testArray - temp array from student)
	* @param (int[] answerKey - Array used to compare for grading)
	* @return (numCorrect - number of correct answers on test)
	*/
	public static int gradeSingle(int[] testArray, int[] answerKey) {
		int numCorrect = 0;
		
		for (int x = 0; x < answerKey.length; x++) {
			
			if (answerKey[x] == testArray[x]) {
				numCorrect++;
			}
		}
		return numCorrect;
	} //end of gradeSingle method

	/** getLetterGrade
	* (creates a letter grade based upon grading standard)
	*
	* @param (percent - percent the student got correct on exam)
	* @return (letterGrade - character value that returns the lettergrade for 1 test)
	*/
	public static char getLetterGrade(double percent) {
		char letterGrade;
		
		if (percent > 89 && percent < 101) {
			letterGrade = 'A';
		} else if (percent > 79.9 && percent < 90) {
			letterGrade = 'B';
		} else if (percent > 69.9 && percent < 80) {
			letterGrade = 'C';
		} else if (percent > 59.9 && percent < 70) {
			letterGrade = 'D';
		} else {
			letterGrade = 'F';
		}
		return letterGrade;
	}// end of getLetterGrade method

	/** printScores
	* (prints the scores from exam)
	*
	* @param (scantronImport - array that is used for ID numbers)
	* @param (numCorrect - array of number of questions the students got correct)
	* @param (numPercent - array of percentages that the students received on exam)
	* @param (score - array of points the student recieved for the exam)
	* @param (grade - array with all students letter grades)
	* @param (numOfStudents - used for length of array)
	* @return (void)
	*/
	public static void printScores(String[][] scantronImport, int[] numCorrect, double[] numPercent, int[] score,
			char grade[], int numOfStudents) {
		System.out.println();
		System.out.print("Student ID\t # Correct\t % Correct \t Score \t Grade\n");
		
		DecimalFormat decFor = new DecimalFormat("0.0");
		
		// cycles through arrays based on students
		for (int x = 0; x < numOfStudents; x++) {
			
			System.out.println(scantronImport[x][0] + "  \t " + numCorrect[x] + "\t\t" + decFor.format(numPercent[x])+ "%" + "\t\t "
					+ score[x] + "\t " + grade[x]);

		}
	}// end of printScores method
	
	/** printClassAverage
	* (prints the average, high, and low for the class)
	*
	* @param (numCorrectArr - array of number of questions the students got correct)
	* @param (numPercent - array of percentages that the students received on exam)
	* @param (numOfStudents - used for max amount of positions in array)
	* @param (questionWorth - used for calculating high and low scores)
	* @return (void)
	*/
	public static void printClassAverage(int [] numCorrectArr, double [] numPercent, int numOfStudents, int questionWorth){
		double average = 0;
		int highScore = 0;
		int lowScore = 101;
		double total = 0;
		
		// formatter used for printing
		DecimalFormat decFor = new DecimalFormat("0.0");
		
		// cycles through arrays based on students
		for(int x = 0; x < numOfStudents; x++){
			
			total += numPercent[x];
			int temp = numCorrectArr[x];
			if(temp > highScore){
				highScore = temp;
				
			}else if(temp < lowScore){
				lowScore = temp;
			}
		}
		
		average = total/numOfStudents;
		
		System.out.println("\nAverage: " + decFor.format(average) + "%" + "(" + getLetterGrade(average) + ")");
		System.out.println("High Score: " + highScore * questionWorth);
		System.out.println("Low Score: " + lowScore * questionWorth);
	} // end of printClassAverage method

	/** createResultFile
	* (Writes values to file)
	*
	* @param (scantronImport - array that is used for ID numbers)
	* @param (numCorrect - array of number of questions the students got correct)
	* @param (numPercent - array of percentages that the students received on exam)
	* @param (score - array of points the student recieved for the exam)
	* @param (grade - array with all students letter grades)
	* @param (numOfStudents - used for length of array)
	* @return (void)
	*/
	public static void createResultFile(String[][] scantronImport, int[] numCorrect, double[] numPercent, int[] score,
			char grade[], int numOfStudents) throws IOException {
		System.out.print("\nResult.txt File created...");
		
		PrintWriter outFile = new PrintWriter(new File("Result.txt"));
		
		for (int x = 0; x < numOfStudents; x++) {
			outFile.print(scantronImport[x][0] + ",");
			outFile.print(numCorrect[x] + ",");
			outFile.print(numPercent[x] + ",");
			outFile.print(score[x] + ",");
			outFile.print(grade[x]);
			outFile.println();
		}
		//closes PrintWriter
		outFile.close();
	}// end of createResultFile method
	
}// end of class
