
public class Student {

	private String name;
	private int StudentID;
	private int Credits;
	private double GPA;

	public Student ( String firstName, String lastName, int StudentID){
		this.name = firstName + " " + lastName;
		this.StudentID = StudentID;
		this.Credits = 0;
		this.GPA = 0.0;

	}

	public Student ( String firstName, String lastName, int studId, int Credits, double GPA){
		this.name = firstName + " " + lastName;
		this.StudentID = studId;
		this.Credits = Credits;
		this.GPA = GPA;

	}




	String getName() {
		return name;
	}

	int getStudentID() {
		return StudentID;
	}

	int getCredits() {
		return Credits;
	}

	double getGPA() {
		return GPA;
	}

	public String getClassStanding()
	{
		if(this.Credits < 30){
			return "Freshman";
		}
		else if( this.Credits <60) {
			return "Sophomore";
		}
		else if( this.Credits <90) {
			return "Junior";
		}
		else 
			return "Senior";
	}

	public void submitGrade(double grade, int credits ){
		double totalCredits = this.Credits + credits;
		double oldQualityScore = this.GPA * this.Credits;
		double newQualityScore = oldQualityScore + (credits * grade);
		double newGpa = newQualityScore / totalCredits;
		this.GPA = (double) Math.round(newGpa * 1000.0) / 1000.0;
		this.Credits += (int) credits;
		return;
	}

	public double computeTuition() {
		
		return (this.Credits / 15) * 20000.0 + (this.Credits % 15) * 1333.33;
	}

	public Student createLegacy(Student parent1, Student parent2) {
		return new Student( parent1.getName(), 
				parent2.getName(),
				(parent1.StudentID + parent2.StudentID),
				(Math.max(parent1.getCredits(), parent2.getCredits())),
				((parent1.getGPA() + parent2.getGPA())/2.0));

	}
	
	public String toString() {
		return this.name + "(" + this.StudentID + ")" + " " + this.Credits + " " + this.GPA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("Kwaku", "Twumasi", 3690209, 0,3.6);
		Student b = new Student("Kwaku", "Twumasi", 3690209, -2,3.5);
		Student m =  s.createLegacy(s,b);
System.out.println(s.toString());
System.out.println(s.getClassStanding());
System.out.println(m.toString());

	}

}
