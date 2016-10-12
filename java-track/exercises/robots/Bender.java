package robots;

public class Bender extends Robot {
	
	private int bendStrength, girderAngle;
	
	public Bender(int b) {
		super("Bender", 0, 0, 0, 0);
		this.bendStrength = b;
		this.girderAngle = 0;
	}
	public int getBendStrength() {
		return bendStrength;
	}

	public void setBendStrength(int bendStrength) {
		this.bendStrength = bendStrength;
	}

	public int getGirderAngle() {
		return girderAngle;
	}

	public void setGirderAngle(int girderAngle) {
		this.girderAngle = girderAngle;
	}
	
	public void bend() {
		this.girderAngle += this.bendStrength;
	}
	
	public static void main(String[] args) {
		Bender b = new Bender(10);
		System.out.println(b.name);
		b.move();
		b.rotate("left");
		b.bend();
	}
	
}
