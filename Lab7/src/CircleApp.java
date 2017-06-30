 /*******************************************************************
* Circle.java
* <Alex Eckstein / Section 1 3/24/2016/4:00>
*
* This class contains the main method and allows users to input 
* information used by constructors in Circle.java
*******************************************************************/
import java.util.Scanner;

public class CircleApp {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		//Circle 1
		Circle circle1 = new Circle();
		System.out.println("Circle 1:");
		
		//print values of first circle
		circle1.display();
		
		//Circle 2 
		System.out.print("Enter in the radius of Circle: ");
		Double radius = Double.parseDouble(s.nextLine());
		
		System.out.print("Enter in the color of Circle: ");
		String color = s.nextLine();
		
		//closing scanner
		s.close();
		Circle circle2 = new Circle(color, radius);
		
		//print values of second circle
		circle2.display();

	}
	
	

}
