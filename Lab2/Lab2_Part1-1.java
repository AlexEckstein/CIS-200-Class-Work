 /*******************************************************************
* Lab2_Part1.java
* <Alex Eckstein / Section 1 1/21/2016/4:00>
*
* This program calculates GPA's 
*******************************************************************/
import java.util.Scanner;  //Import for Scanner

public class Lab2_Part1{
public static void main(String [] args){
	Scanner keyboard = new Scanner(System.in); 
	String input;
	
	double classOneHour;// Hold values for each class
	char classOneGrade;
	double  classOneNumber = 0;
	
	double classTwoHour;
	char classTwoGrade;
	double  classTwoNumber = 0;
	
	double classThreeHour;
	char classThreeGrade;
	double  classThreeNumber = 0;
	
	double classFourHour;
	char classFourGrade;
	double  classFourNumber = 0;
	
	System.out.println("This program calculates GPA");
	
	//Gathers the data about each class
	
		System.out.print("Please enter the amount of credit hours for your first class ");
	input = keyboard.nextLine();
	classOneHour = Double.valueOf(input);
	System.out.print("Please enter the letter grade for your first class ");
	classOneGrade = (keyboard.nextLine().charAt(0));
	// Class 1
	if (classOneGrade == 'a'){
		  classOneNumber = 4.0;
	}
	else if (classOneGrade == 'A'){
		  classOneNumber = 4.0;
	}
	else if (classOneGrade == 'b'){
		  classOneNumber = 3.0;
	}
	else if (classOneGrade == 'B'){
		  classOneNumber = 3.0;
	}
	else if (classOneGrade == 'c'){
		  classOneNumber = 2.0;
	}
	else if (classOneGrade == 'C'){
		  classOneNumber = 2.0;
	}
	else if (classOneGrade == 'd'){
		  classOneNumber = 1.0;
	}
	else if (classOneGrade == 'D'){
		  classOneNumber = 1.0;
	}
	else if (classOneGrade == 'f'){
		  classOneNumber = 0;
	}
	else if (classOneGrade == 'F')
		  classOneNumber = 0;
	else{
		System.out.print("Error, please input a valid variable");
		System.exit(0);
	}
		
	//Class 2 
	System.out.print("Please enter the amount of credit hours for your second class ");
	input = keyboard.nextLine();
	classTwoHour = Double.valueOf(input);
	System.out.print("Please enter the letter grade for your second class ");
	classTwoGrade = (keyboard.nextLine().charAt(0));
	 
	if (classTwoGrade == 'a'){
		  classTwoNumber = 4.0;
	}
	else if (classTwoGrade == 'A'){
		  classTwoNumber = 4.0;
	}
	else if (classTwoGrade == 'b'){
		  classTwoNumber = 3.0;
	}
	else if (classTwoGrade == 'B'){
		  classTwoNumber = 3.0;
	}
	else if (classTwoGrade == 'c'){
		  classTwoNumber = 2.0;
	}
	else if (classTwoGrade == 'C'){
		  classTwoNumber = 2.0;
	}
	else if (classTwoGrade == 'd'){
		  classTwoNumber = 1.0;
	}
	else if (classTwoGrade == 'D'){
		  classTwoNumber = 1.0;
	}
	else if (classTwoGrade == 'f'){
		  classTwoNumber = 0;
	}
	else if (classTwoGrade == 'F')
		  classTwoNumber = 0;
	else{
		System.out.print("Error, please input a valid variable");
		System.exit(0);
	}	
	//Class 3 
	
	System.out.print("Please enter the amount of credit hours for your third class ");
	input = keyboard.nextLine();
	classThreeHour = Double.valueOf(input);
	System.out.print("Please enter the letter grade for your third class ");
	classThreeGrade = (keyboard.nextLine().charAt(0));
	
	if (classThreeGrade == 'a'){
		  classThreeNumber = 4.0;
	}
	else if (classThreeGrade == 'A'){
		  classThreeNumber = 4.0;
	}
	else if (classThreeGrade == 'b'){
		  classThreeNumber = 3.0;
	}
	else if (classThreeGrade == 'B'){
		  classThreeNumber = 3.0;
	}
	else if (classThreeGrade == 'c'){
		  classThreeNumber = 2.0;
	}
	else if (classThreeGrade == 'C'){
		  classThreeNumber = 2.0;
	}
	else if (classThreeGrade == 'd'){
		  classThreeNumber = 1.0;
	}
	else if (classThreeGrade == 'D'){
		  classThreeNumber = 1.0;
	}
	else if (classThreeGrade == 'f'){
		  classThreeNumber = 0;
	}
	else if (classThreeGrade == 'F')
		  classThreeNumber = 0;
	else{
		System.out.print("Error, please input a valid variable");
		System.exit(0);
	}
	
	//Class 4
	System.out.print("Please enter the amount of credit hours for your fourth class ");
	input = keyboard.nextLine();
	classFourHour = Double.valueOf(input);
	//classFourHour = keyboard.nextLine();
	System.out.print("Please enter the letter grade for your fourth class ");
	classFourGrade = (keyboard.nextLine().charAt(0));
	
	if (classFourGrade == 'a'){
		  classFourNumber = 4.0;
	}
	else if (classFourGrade == 'A'){
		  classFourNumber = 4.0;
	}
	else if (classFourGrade == 'b'){
		  classFourNumber = 3.0;
	}
	else if (classFourGrade == 'B'){
		  classFourNumber = 3.0;
	}
	else if (classFourGrade == 'c'){
		  classFourNumber = 2.0;
	}
	else if (classFourGrade == 'C'){
		  classFourNumber = 2.0;
	}
	else if (classFourGrade == 'd'){
		  classFourNumber = 1.0;
	}
	else if (classFourGrade == 'D'){
		  classFourNumber = 1.0;
	}
	else if (classFourGrade == 'f'){
		  classFourNumber = 0;
	}
	else if (classFourGrade == 'F')
		  classFourNumber = 0;
	else{
		System.out.print("Error, please input a valid variable");
		System.exit(0);
	}
	//double classOneVariable = (classOneNumber*classOneHour);
	double totalHours = (classOneHour + classTwoHour + classThreeHour + classFourHour);
	double totalGPA = (((classOneNumber *classOneHour) + (classTwoNumber*classTwoHour) + (classThreeNumber*classThreeHour) + (classFourNumber* classFourHour)) / totalHours);
	
	System.out.printf("Your combined GPA is: %.2f\n", totalGPA);
	
}
}