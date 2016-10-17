package studio2;

public class Rectangle {
	// fields
	
	private int length;
	private int width;
	
	
	// methods
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public boolean isSmallerArea(Rectangle other) {
		int otherArea = other.getArea();
		if (this.getArea() < otherArea) {
			return true;
		}
		return false;
	}
	
	public int getArea() {
		return length * width;
	}
	
	public int getPerimeter() {
		return length + length + width + width;
	}
	
	public boolean isSquare() {
		if (length == width) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(5, 5);
		Rectangle q = new Rectangle(4, 4);
		System.out.println(r.isSquare());
		System.out.println(q.isSmallerArea(r));

	}

}
