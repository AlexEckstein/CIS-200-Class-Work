
/*******************************************************************
* View.java
* <Alex Eckstein / Section A 4/07/2016/4:00>
*
* This class contains the view class used for the program.
*******************************************************************/
import java.util.*;

public class View {

	private Scanner s;
	private int x = 1;

	/*
	* no arg constructor used for scanning
	*/
	public View() {
		s = new Scanner(System.in);
	}
	/**
	* gets points possible 
	* 
	* @return integer from user input
	*/
	public int getLabPP() {
		System.out.print("Please enter the total number of points possible for Labs: ");

		return Integer.parseInt(s.nextLine());
	}

	/**
	* gets points possible 
	* 
	* @return integer from user input
	*/
	public int getProjectPP() {
		System.out.print("Please enter the total number of points possible for Projects: ");

		return Integer.parseInt(s.nextLine());
	}
	/**
	* gets points possible 
	* 
	* @return integer from user input
	*/
	public int getExamPP() {
		System.out.print("Please enter the total number of points possible for Exams: ");

		return Integer.parseInt(s.nextLine());
	}
	/**
	* gets points possible 
	* 
	* @return integer from user input
	*/
	public int getCodeLabPP() {
		System.out.print("Please enter the total number of points possible for CodeLabs: ");

		return Integer.parseInt(s.nextLine());
	}
	/**
	* gets points possible 
	* 
	* @return integer from user input
	*/
	public int getFinalPP() {
		System.out.print("Please enter the total number of points possible for Final Exam: ");

		return Integer.parseInt(s.nextLine());
	}
	/**
	* gets first name from user 
	* 
	* @return String from user input
	*/
	public String getFirstName() {
		System.out.print("\nEnter the student's first name: ");

		return s.nextLine();
	}
	/**
	* gets last name from user 
	* 
	* @return String from user input
	*/
	public String getLastName() {
		System.out.print("Enter the student's last name: ");

		return s.nextLine();
	}
	/**
	* gets WID from user 
	* 
	* @return String from user input
	*/
	public String getWID() {
		System.out.print("Enter the student's WID: ");

		return s.nextLine();
	}
	/**
	* gets labScore from user 
	* 
	* @return double from user input
	*/
	public double getLabScore() {
		System.out.print("\nEnter the student's Total Lab score: ");

		return Double.parseDouble(s.nextLine());
	}
	/**
	* gets projScore from user 
	* 
	* @return double from user input
	*/
	public double getProjScore() {
		System.out.print("Enter the student's Total Projects score: ");

		return Double.parseDouble(s.nextLine());
	}
	/**
	* gets examScore from user 
	* 
	* @return double from user input
	*/
	public double getExamScore() {
		System.out.print("Enter the student's Total Exams score: ");

		return Double.parseDouble(s.nextLine());
	}
	/**
	* gets codeLabScore from user 
	* 
	* @return double from user input
	*/
	public double getCodeLabScore() {
		System.out.print("Enter the student's CodeLab score: ");

		return Double.parseDouble(s.nextLine());
	}
	/**
	* gets finalExamScore from user 
	* 
	* @return double from user input
	*/
	public double getFinalExamScore() {
		System.out.print("Enter the student's Final Exam score: ");

		return Double.parseDouble(s.nextLine());
	}
	/**
	* asks user if they would like to add another student 
	* 
	* @return boolean value used to add a student or not
	*/
	public boolean addStudent() {
		boolean a = false;
		System.out.println("\nWould you like to enter another student?");
		System.out.println("\t" + x + " Student(s) entered so far.");
		System.out.println("\t(20 students can be entered)");
		System.out.print("Press Enter for another student or any other key to quit.");

		Scanner keyboard = new Scanner(System.in);
		String readString = keyboard.nextLine();

		// while (readString != null) {
		if (readString.equals("") || readString.isEmpty()) {
			x++;
			a = true;
		} else
			a = false;
		// }
		return a;

	}
	/**
	* This method prints the students
	*
	* @param Student[] student - student array passed into method
	* @return void
	*/
	public void printStudent(Student[] student) {
		int i;
		for (i = 0; i < x; i++) {
			System.out.println(student[i].toString());
			System.out.print("\tPress enter to display next Student...");
			Scanner keyboard = new Scanner(System.in);
			String readString = keyboard.nextLine();

			if (readString.equals("") || readString.isEmpty()) {

			}
		}
		if (i == x)
			System.out.println("All Students displayed...");
	}
}// end of class
