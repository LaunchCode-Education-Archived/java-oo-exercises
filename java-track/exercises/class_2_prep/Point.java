package class_2_prep;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public String toString() {
		return "Point (" + x + ", " + y + ")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x_pos) {
		this.x = x_pos;
	}

	public int getY() {
		return y;
	}

	public void setY(int y_pos) {
		this.y = y_pos;
	}
	
	
}
