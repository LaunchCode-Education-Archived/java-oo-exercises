package class_2_prep;

public class Robot {
	
	private static int base_model = 001;
	
	private String name;
	private Point position;
	private int speed;
	private int orientation; // 0, 1, 2, 3 == N, W, S, E
	
	public Robot(String name, Point pos, int speed, int orientation) {
		this.name = name;
		this.position = pos;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	public Robot() {
		this.name = "Robot " + Robot.base_model;
		this.position = new Point();
		this.speed = 0;
		this.orientation = 0;
		
		Robot.base_model += 1;
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

	public Point getPos() {
		return position;
	}

	public int getOrientation() {
		return orientation;
	}

	public String toString() {
		return "Name: " + this.name + " \nPosition: " + position + " \nSpeed: " +
				this.speed + " \nOrientation: " + direction();
	}
	
	public void move() {

		if (this.orientation == 0) {
			this.position.setY(this.position.getY() + this.speed);
		}
		else if (this.orientation == 1) {
			this.position.setX(this.position.getX() - this.speed);
		}
		else if (this.orientation == 2) {
			this.position.setY(this.position.getY() - this.speed);
		}
		else {
			this.position.setX(this.position.getX() + this.speed);
		}
		System.out.println("Beep boop. Moving " + this.speed + " units to " + this.position);
	}
	
	public double distanceFrom(Robot r) {
		int r_x = r.position.getX();
		int r_y = r.position.getY();
		return Math.sqrt(Math.pow(r_x - this.position.getX(), 2) + 
						 Math.pow(r_y - this.position.getY(), 2));	
	}
	
	public void rotate(String direction) {
		if (direction == "left") {
			this.orientation += 1;
		}
		else if (direction == "right") {
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
		System.out.println(this.name + " turned " + direction + ". Current heading: " + direction());
	}
	
	public String direction() {
		if (this.orientation == 0) {
			return "N";
		}
		else if (this.orientation == 1) {
			return "W";
		}
		else if (this.orientation == 2) {
			return "S";
		}
		else {
			return "E";
		}
	}
	
	public static void main(String[] args) {
		Robot rob = new Robot("rob", new Point(), 5, 0);
		System.out.println(rob);
		System.out.println();
		rob.rotate("left");
		System.out.println();
		rob.move();
		System.out.println();
		rob.rotate("right");
		System.out.println();
		rob.move();
		System.out.println();
		System.out.println(rob);
		System.out.println();
		Robot percy = new Robot();
		System.out.println();
		System.out.println(rob.name + " is " + rob.distanceFrom(percy) + " units from " + percy.name);
	}	
	
}	
