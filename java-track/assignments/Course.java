
import java.util.ArrayList;

public class Course {
	
	// fields : name, credits, num seats, roster of students
	private String name;
	private int credits;
	private int remainingSeats;
	private ArrayList<Student> students;
	
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static int coursesCreated;
	
	
	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.students = new ArrayList<Student>();
		courses.add(this);
		coursesCreated += 1;
	}
	
	public static ArrayList<Course> getAllCourses() {
		return courses;
	}
	
	public static int getNumCoursesCreated() {
		return coursesCreated;
	}
	
	/**
	 * addStudent() - returns a boolean based on whether or not the student was successfully added to the course. 
	 * Check to make sure that the student has not already enrolled, 
	 * and update the number of seats remaining.
	 */
	
	public boolean addStudent(Student s) {
		if (this.remainingSeats < 1) {
			return false;
		}	
		if (students.contains(s)) {
			return false;
		} else {
			students.add(s);
			this.remainingSeats -= 1;
			return true;
		}
	}
	
	/**
	 * generateRoster() - Returns a String that represents a roster with all of the students in the course. 
	 * Make sure to omit "empty" seats!
	 */
	public String generateRoster() {
		String roster = "";
		for (Student s: this.students) {
			roster += s + "\n";
		}
		return roster;
	}
	
	/**
	 * averageGPA() - returns the average GPA of all students enrolled in the course. Make sure to omit "empty" seats!
	 */
	public double averageGPA() {
		double sumGPA = 0;
		for (Student s: this.students) {
			sumGPA += s.getGPA();
		}
		return sumGPA / this.students.size();
	}
	
	
	public String toString() {
		return this.name + " " + this.credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	
}

/**
public class Course {

	private String name;
	private int credits;
	private int remainingSeats;
	private Student[] roster;

	public Course(String name, int credits, int numberOfSeats) {
		this.roster = new Student[numberOfSeats];
		this.name = name;
		this.credits = credits;
		this.remainingSeats = numberOfSeats;
	}

	public String getName() {
		return name;
	}
	public int getCredits() {
		return credits;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public Student[] getRoster() {
		return roster;
	}

	public Boolean addStudent(Student newStudent) {

		if (this.remainingSeats == 0) {
			return false;
		}

		// check to make sure student hasn't already enrolled
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null && roster[i].getName() == newStudent.getName()) {
				return false;
			}
		}

		roster[roster.length - this.remainingSeats] = newStudent;
		remainingSeats--;

		return true;
	}

	public double averageGPA() {

		double sum = 0.0;
		int numberOfStudents = 0;
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				sum += roster[i].getGPA();
				numberOfStudents++;
			}
		}

		return sum / numberOfStudents;
	}

	public String generateRoster() {

		String rosterString = "";
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				rosterString = rosterString + roster[i].getName() + "\n";
			}
		}

		return rosterString;
	}

	public String toString() {
		return this.name + "(" + this.credits + ")";
	}

}
}
*/
