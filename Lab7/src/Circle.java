 /*******************************************************************
* Circle.java
* <Alex Eckstein / Section 1 3/24/2016/4:00>
*
* This class contains methods and constructors for circleApp.java
*******************************************************************/

public class Circle {
	private String color;
	private double radius;
	private final double pi = 3.14159;
	private double area;
	private double cm;
	private double surfaceArea;
	private double volume;

	
	//blank constructor
	public Circle() {
		color = "white";
		radius = 1;
		area = getArea(radius);
		cm = getCircumference(radius);
		surfaceArea = getSurfaceArea(radius);
		volume = getVolume(radius);
	}

	//constructor for 2 variables
	public Circle(String c, double r) {
		color = c;
		radius = r;
		area = getArea(radius);
		cm = getCircumference(radius);
		surfaceArea = getSurfaceArea(radius);
		volume = getVolume(radius);
	}

	public double getArea(double radius) {
		double a = pi * (radius * radius);
		return a;
	}

	public double getCircumference(double radius) {
		double circumference = 2 * pi * radius;
		return circumference;
	}

	public double getSurfaceArea(double radius) {
		double sa = 4*pi*(radius*radius);
		
		return sa;
	}

	public double getVolume(double radius) {
		double v = (4.0/3.0)*pi*radius*radius*radius;
		
		return v;
	}

	public void display() {
		System.out.println("Color: " + color);
		System.out.println("Radius: " + radius);
		System.out.printf("Area: %.3f", area);
		System.out.printf("\nCircumference: %.3f" , cm);
		System.out.printf("\nSurface Area: %.3f" , surfaceArea);
		System.out.printf("\nVolume: %.3f" , volume);
		System.out.println(); 
		System.out.println(); // Print blank line
	}
}
