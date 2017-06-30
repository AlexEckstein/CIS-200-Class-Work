
 /*******************************************************************
* Lab3.java
* <Alex Eckstein / Section A 2/4/2016/4:00>
*
* This program calculates payments monthly and in total 
*******************************************************************/
import java.util.*;

public class Lab3 {
		
    	private static Scanner s;

		public static void main(String[] args){
			s = new Scanner(System.in);
			String input;
			int examScore = 0;
			int examScoreFinal = 0;
			int examScoreAll = 0;
			int numberOfExamsClass = 0;
			int numberOfExamsAll = 0;
			int highestClass = 0;
			int lowestClass = 101;
			int highestAll = 0;
			int lowestAll = 101;
			
			char section;
			do {
				System.out.print("Please enter your section number: ");
				input = s.nextLine();
				section  = input.charAt(0);
		
			while (examScore != 1 || examScore < 100){
				System.out.println("This program inputs exam scores. Enter '-1' to end program");
				System.out.println("Please enter your exam score: ");
				input = s.nextLine();
				examScore = Integer.valueOf(input);
				examScoreFinal += examScore; 
				numberOfExamsClass++;
				numberOfExamsAll++;
				
				if (examScore > 100){
					numberOfExamsClass--; 
					numberOfExamsAll--;
					examScoreFinal = examScoreFinal - examScore;
					
					System.out.println("Please enter a valid input");
				}
				if (examScore > highestClass && examScore > -1){
					highestClass = examScore;
				}
				if (highestClass > highestAll){
					highestAll = highestClass;
				}
				if (examScore < lowestClass && examScore > -1){
					lowestClass = examScore;
				}
				if (lowestClass < lowestAll){
					lowestAll = lowestClass;
				}
				if (examScore < 0){
				numberOfExamsClass--;
				numberOfExamsAll--;
				examScoreFinal = examScoreFinal - examScore;
				examScoreAll += examScoreFinal;
				
				System.out.println("Section: " + section);
				System.out.println("The number of scores entered for class: " + numberOfExamsClass);
				System.out.println("The number of scores entered: " + numberOfExamsAll);
				System.out.println("The highest score in the class: " + highestClass);
				System.out.println("The highest score is: " + highestAll);
				System.out.println("The lowest score in the class: " + lowestClass);
				System.out.println("The lowest score is: " + lowestAll);
				System.out.println("The average class score is: " + examScoreFinal/ numberOfExamsClass);
				System.out.println("The average overall score is: " + examScoreFinal/ numberOfExamsAll);
				System.out.println("Would you like to add a new section? 1)yes 2)no");
				input = s.nextLine();
				int addSection = Integer.valueOf(input);
				
				if (addSection == 1){
					lowestClass = -1;
					highestClass = -1;
					numberOfExamsClass = 0;
					examScoreFinal = -1;
					System.out.print("Please enter your section number: ");
					input = s.nextLine();
					section  = input.charAt(0);
				}
				
				
			}
			} // end while 
			}while(examScore == -1);{ //end of do
				System.out.println("Would you like to add a new section?");
			}
}
}
