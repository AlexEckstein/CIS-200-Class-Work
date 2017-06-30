/*******************************************************************
 * Student.java 
 * <Alex Eckstein / Section A 4/07/2016/4:00>
 *
 * This class contains the methods and constructors used for the program.
 *******************************************************************/
import java.text.NumberFormat;

public class Student {

	private String firstName;
	private String lastName;
	private String wId;
	private double labScore;
	private double projScore;
	private double examScore;
	private double codeLabScore;
	private double finalExamScore;
	private double scorePercent;

	private double labPP;
	private double projPP;
	private double examPP;
	private double codeLabPP;
	private double finalExamPP;
	private double totalPP;

	private final double labWeight = .15;
	private final double projWeight = .15;
	private final double examWeight = .30;
	private final double codeLabWeight = .10;
	private final double finalWeight = .30;

	/**
	* 9 argument constructor 
	*
	* @param firstName - String that defines first name of student
	* @param lastName - String that defines last name of student
	* @param wId - String that holds the ID of student
	* @param labScore - double that holds the score of labs
	* @param projScore - double that holds the score of projects
	* @param examScore - double that holds the score of the exams
	* @param codeLabScore - double that holds the score of the Code Labs
	* @param finalExamScore - double that holds the score of the final Exam
	* @param scorePercent - double that holds the final grade that the student receives 
	*/
	public Student(String firstName, String lastName, String wId, double labScore, double projScore, double examScore,
			double codeLabScore, double finalExamScore, double scorePercent) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.wId = wId;
		this.labScore = labScore;
		this.projScore = projScore;
		this.examScore = examScore;
		this.codeLabScore = codeLabScore;
		this.finalExamScore = finalExamScore;
		this.scorePercent = scorePercent;
	}
	/**
	* Default constructor for Student object
	*/
	public Student() {
		this.firstName = "no name entered";
		this.lastName = "no name entered";
		this.wId = "no WID";
		this.labScore = 0;
		this.projScore = 0;
		this.examScore = 0;
		this.codeLabScore = 0;
		this.finalExamScore = 0;
		this.scorePercent = 0;
	}
	/**
	* Saves points possible into Student class
	* @return void
	*/
	public void getPP() {
		View v = new View();

		labPP = v.getLabPP();
		projPP = v.getProjectPP();
		examPP = v.getExamPP();
		codeLabPP = v.getCodeLabPP();
		finalExamPP = v.getFinalPP();
		totalPP = labPP + projPP + examPP + codeLabPP + finalExamPP;
	}
	/**
	* create student object
	* 
	* @return Student s - object returned
	*/
	public Student createStudent() {
		Student s = new Student();
		View v = new View();

		s.firstName = v.getFirstName();
		s.lastName = v.getLastName();
		s.wId = v.getWID();
		s.labScore = v.getLabScore();
		labScore = s.labScore;
		s.projScore = v.getProjScore();
		projScore = s.projScore;
		s.examScore = v.getExamScore();
		examScore = s.examScore;
		s.codeLabScore = v.getCodeLabScore();
		codeLabScore = s.codeLabScore;
		s.finalExamScore = v.getFinalExamScore();
		finalExamScore = s.finalExamScore;
		s.scorePercent = calcScorePercent();
		return s;
	}
	/**
	* calculates the score percent that a student earns
	* 
	* @return double of scorePercentage 
	*/
	private double calcScorePercent() {
		double adjustedLab = totalPP * labWeight;
		double adjustedProj = totalPP * projWeight;
		double adjustedExam = totalPP * examWeight;
		double adjustedCodeLab = totalPP * codeLabWeight;
		double adjustedFinal = totalPP * finalWeight;

		labScore = (labScore / labPP) * adjustedLab;
		projScore = (projScore / projPP) * adjustedProj;
		examScore = (examScore / examPP) * adjustedExam;
		codeLabScore = (codeLabScore / codeLabPP) * adjustedCodeLab;
		finalExamScore = (finalExamScore / finalExamPP) * adjustedFinal;

//		double labPercent = labScore / adjustedLab;
//		double projPercent = projScore / adjustedProj;
//		double examPercent = examScore / adjustedExam;
//		double codeLabPercent = codeLabScore / adjustedCodeLab;
//		double finalPercent = finalExamScore / adjustedFinal;

		double totalPercent = (labScore + projScore + examScore + codeLabScore + finalExamScore) / totalPP;
		
		scorePercent = totalPercent;
		
		return totalPercent;
	}
	/**
	* calculates the letter grade for student
	*
	* @return String finalGrade - letter grade
	*/
	private String calcFinalGrade() {
		String finalGrade;
		
		if (scorePercent >= .895)
			finalGrade = "A";
		else if(scorePercent >= .795 && scorePercent < .895)
			finalGrade = "B";
		else if(scorePercent >= .685 && scorePercent < .795)
			finalGrade = "C";
		else if (scorePercent > .585 && scorePercent < .685)
			finalGrade = "D";
		else
			finalGrade = "F";

		return finalGrade;
	}
	/**
	* Converts the information in object into a String
	* 
	* @return String used for printing results
	*/
	public String toString() {
		NumberFormat formatter = NumberFormat.getPercentInstance();
		formatter.setMinimumFractionDigits(1);

		return ("\nStudent Name: " + lastName + ", " + firstName + "\nWID: " + wId + "\nOverall Pct: "
				+ formatter.format(scorePercent) + "\nFinal Grade: " + calcFinalGrade());
	}
}
