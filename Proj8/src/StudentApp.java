/*******************************************************************
 * StudentApp.java <Alex Eckstein / Section A 4/07/2016/4:00>
 *
 * This class contains the main method used for the program.
 *******************************************************************/
public class StudentApp {

	public static void main(String args[]) {
		Student[] student = new Student[20];
		int x = 0;
		boolean running = true;

		View viewer = new View();
		Student tempStudent = new Student();
		tempStudent.getPP();
		student[x] = tempStudent.createStudent();
		while (x < 20) {

			running = viewer.addStudent();
			if (running == true) {
				x++;
				student[x] = tempStudent.createStudent();
			} else {
				viewer.printStudent(student);
				System.exit(0);
			}
		}
	

	}
}
