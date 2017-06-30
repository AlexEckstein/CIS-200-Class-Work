import java.util.*;

public class Lab4 {

	private static Scanner s;

	public static void main(String[] args) {
		
		s = new Scanner (System.in); 
		String input = null;
		int testsPerStud = 0;
		int studsInClass = 0;
		int k = 0;
		int i = 0;
		double total = 0;
		double totalTests = 0;
		double classTotal = 0;
		
		int highScore = 0; 
		int lowScore = 100;
		
		
		System.out.print("How many Students are in the class? ");
		input = s.nextLine();
		studsInClass = Integer.parseInt(input);
		
		System.out.print("How many exams did each student take? ");
		input = s.nextLine();
		testsPerStud = Integer.parseInt(input);
		
		int [][] array = new int[studsInClass][testsPerStud];
		
		
		for (i=0; i < studsInClass ; i++){
			
			if (k == testsPerStud){
				System.out.printf("Student average is: %.1f", (total/ k));
				System.out.println();
				k = 0;
				total = 0;
			}
			
			
			System.out.println();
			System.out.println("Student " + (i+1));
			
			
			
			for (k=0; k < testsPerStud; k++){
				
				System.out.print("Enter test "+ (k+1) + " grade(0 to 100): " );
				input = s.nextLine();
				array [i][k] = Integer.parseInt(input);
				total += Integer.parseInt(input);
				classTotal += Integer.parseInt(input);
				totalTests ++;
				
				if (array [i][k] > highScore){
					highScore = array[i][k];
				}
				if (array [i][k] < lowScore){
					lowScore = array[i][k];
				}
				
			}
		}
		System.out.printf("Student average is: %.1f", (total/ k));
		System.out.println();
		k = 0;
		
		System.out.println();
		System.out.printf("The class average is %.1f", classTotal/totalTests);
		System.out.println();
		System.out.println("The class high score is " + highScore + " and the low score is " + lowScore);
		
		
				
	}

}
