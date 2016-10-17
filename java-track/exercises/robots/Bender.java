package robots;

public class Bender extends Robot {
	
	private int bendStrength, girderAngle;
	protected RobotBehavior behavior;
	
	public Bender(int b, RobotBehavior rb) {
		super("Bender", 0, 0, 0, 0);
		this.bendStrength = b;
		this.girderAngle = 0;
		this.behavior = rb;
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
	
}
