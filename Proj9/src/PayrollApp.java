
/*******************************************************************
* PayrollApp.java
* <Alex Eckstein / Section A 4/21/2016/4:00>
*
* This program is the control for payroll application
*******************************************************************/
import java.util.*;

public class PayrollApp {

	public static void main(String[] args) throws Exception {
		boolean addEmployees = true;
		boolean addAgain = false;
		Scanner s = new Scanner(System.in);
		ArrayList<Payroll> al = new ArrayList<Payroll>();

		while (addEmployees == true) {
			Payroll p = new Payroll(null, 0);
			p.getName();
			p.getIdNumber();
			p.getPayRate();
			p.getHoursWorked();
			al.add(p);
			if (addAgain == false) {
				addEmployees = p.addPayroll();
			} // else {
			// addEmployees = false;
			// }
		}

		System.out.println("\nPrinting Array...\n");
		System.out.println(al.toString());

		while (addEmployees == false || addAgain != true) {
			boolean valid = false;
			while (valid == false) {
				System.out.print("\nEnter ID that you wish to delete: ");
				int deleteID = Integer.parseInt(s.nextLine());

				for (int x = 0; x < al.size(); x++) {
					Payroll tempOb = al.get(x);
					if (deleteID == tempOb.findId()) {
						al.remove(x);
						x = al.size();
						System.out.println("\nDeleted ID number: " + deleteID + "\n");
						valid = true;
					}
				}
			}

			System.out.println("\nPrinting Array...\n");
			System.out.println(al.toString());
			addEmployees = true;
			addAgain = true;

		}

		Payroll p = new Payroll(null, 0);
		p.getName();
		p.getIdNumber();
		p.getPayRate();
		p.getHoursWorked();
		al.add(p);
		addEmployees = false;

		if (addEmployees == false && addAgain == true) {
			System.out.print(al.toString());
		}
	}// end of main
}// end of class
