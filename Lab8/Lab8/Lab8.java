
/*******************************************************************
* Lab8.java
* <Alex Eckstein / Section A 3/31/2016/4:00>
*
* This program uses points to calculate lines and then finds whether
* or not those lines intersect
*******************************************************************/
import java.util.*;

public class Lab8 {
	public static void main(String[] args) {
		Point[] points = new Point[4];

		points[0] = new Point(1, 1);
		points[1] = new Point(3, 3);
		points[2] = new Point(0, 4);
		points[3] = new Point(1, 6);

		Line line1 = new Line(points[0], points[1]);

		Line line2 = new Line(points[2], points[3]);

		System.out.println(line1.toString());

		System.out.println(line2.toString());

		boolean tf = line2.intersects(line1);

		if (tf == true) {
			System.out.println("Lines intersect");
		} else if (tf == false) {
			System.out.println("Lines do NOT intersect");
		}
	} // end main
} // end class