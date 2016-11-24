
public class Course {

	private String name;
	private int Credits;
	private int remainingSeats;
	private Student[] roster;

	public Course( String name, int Credits, int numberofSeats) {

		this.name = name;
		this.Credits = Credits;
		this.remainingSeats = numberofSeats;
		this.roster = new Student[numberofSeats];	
	}


	public String getName() {
		return name;
	}


	public int getCredits() {
		return Credits;
	}


	public int getRemainingSeats() {
		return remainingSeats;
	}


	public Student[] getRoster() {
		return roster;
	}


	public boolean addStudent(Student student) {

		if (this.remainingSeats == 0) {
			return false;
		}

		for(int i = 0; i < this.roster.length; i++) {
			if(this.roster[i] != null && this.roster[i].getName() == student.getName() ) {
				return false;
			}
		}

		this.roster[this.roster.length - this.remainingSeats ] = student;
		this.remainingSeats -= 1;
		return true;
	}

	public String generateRoster() {

		String rosterNames = "";
		for(int i = 0; i < this.roster.length; i++) {
			if(this.roster != null) {
				String names = roster[i].getName();
				rosterNames += names + "\n";
			}
		}

		return rosterNames; 
	}
	
	public double averageGPA(){
		double sumGPA = 0.0;
		int numberGPA = 0;
		for( int i = 0; i < this.roster.length; i++) 
		{
			if(this.roster[i] != null) {
			sumGPA += this.roster[i].getGPA();
			 numberGPA ++;
			}
		}
		 double averageGPA = sumGPA/numberGPA;
		 return averageGPA;
	}
	
	public String toString() {
		
		return this.name + " (" + this.Credits + ")";
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
