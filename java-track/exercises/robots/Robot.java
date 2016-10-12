package robots;
import java.util.HashMap;


public class Robot {
	
	// fields
	protected String name;	
	protected int xPos, yPos, speed, orientation;
	protected RobotBehavior behavior;
	
	private static int base_model = 001;
	private static final HashMap<Integer, String> dirMap = createMap();
	
	private static HashMap<Integer, String> createMap() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "N");
		map.put(1, "W");
		map.put(2, "S");
		map.put(3, "E");
		return map;
	}
	
	public Robot(String name, int xPos, int yPos, int speed, int orientation) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
		this.orientation = orientation;
		
	}
	
	public Robot() {
		this.name = "Robot " + Robot.base_model;
		this.xPos = 0;
		this.yPos = 0;
		this.speed = 0;
		this.orientation = 0;
		
		Robot.base_model += 1;
	}
	
	public void setBehavior(RobotBehavior rb) {
		this.behavior = rb;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getOrientation() {
		return orientation;
	}
	
	public void setOrientation(int orientation) {
		if (orientation > 3 || orientation < 0) {
			throw new IllegalArgumentException("Orientation must be int between 0-3");
		}
		this.orientation = orientation;
	}

	public String toString() {
		return "Name: " + this.name + " // Position: " + position() + " // Speed: " +
				this.speed + " // Orientation: " + dirMap.get(orientation);
	}
	
	public String position() {
		return "(" + this.xPos + "," + this.yPos + ")";
	}
	
	public void move() {

		if (this.orientation == 0) {
			this.yPos = this.yPos + this.speed;
		}
		else if (this.orientation == 1) {
			this.xPos = this.xPos - this.speed;
		}
		else if (this.orientation == 2) {
			this.yPos = this.yPos - this.speed;
		}
		else {
			this.xPos = this.xPos + this.speed;
		}
		System.out.println("Beep boop. Moving " + this.name + " " + this.speed + " units to " + position());
	}
	
	public double distanceFrom(Robot r) {
		int r_x = r.getxPos();
		int r_y = r.getyPos();
		return Math.sqrt(Math.pow(r_x - this.xPos, 2) + Math.pow(r_y - this.yPos, 2));	
	}
	
	public void rotate(String direction) {
		if (direction.equals("left")) {
			this.orientation += 1;
		}
		else if (direction.equals("right")) {
			this.orientation -= 1;
		}
		else {
			System.out.println("Invalid rotation");
		}
		
		if (this.orientation > 3) {
			this.orientation = 0;
		}
		if (this.orientation < 0) {
			this.orientation = 3;
		}
		System.out.println(this.name + " turned " + direction + ". Current heading: " + dirMap.get(orientation));
	}
	

	public static void main(String[] args) {
		Bender b = new Bender(5);
		Bender q = new Bender(11);
		b.setBehavior(new FastBendingBehavior());
		q.setBehavior(new SlowBendingBehavior());
		
		boolean bFinished = false;
		boolean qFinished = false;
		
		while (!bFinished || !qFinished) {
			bFinished = b.behavior.doNextMove(b);
			System.out.println();
			qFinished = q.behavior.doNextMove(q);
			System.out.println();
		}
		System.out.println("ONE OF THE ROBOTS IS DONE!");
		
		
	}	
	
}	
