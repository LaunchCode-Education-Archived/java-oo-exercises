package studio2;

public class Fraction {
	
	// fields
	private int numerator, denominator;
	
	// methods
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Fraction() {
		this.numerator = 0;
		this.denominator = 0;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public static int gcd(int x, int y) {

		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
	
	public Fraction add(Fraction b) {
		int common = this.denominator * b.denominator;
		int numThis = this.numerator * b.denominator;
		int numB = b.numerator * this.denominator;
		return new Fraction(numThis + numB, common);
	}
	
	public Fraction subtract(Fraction b) {
		return this.add(new Fraction(-b.numerator, b.denominator));
	}
	
	public Fraction multiply(Fraction b) {
		return new Fraction(this.numerator * b.numerator, this.denominator * b.denominator);
	}
	
	public Fraction divide(Fraction b) {
		return this.multiply(new Fraction(b.denominator, b.numerator));
	}
	
	public void reduce() {

		int factor = 0;
		if (numerator > denominator) {
			factor = gcd(numerator, denominator);
		} else if (denominator > numerator) {
			factor = gcd(denominator, numerator);
		} else { // num == denom
			factor = numerator;
		}
		this.numerator = numerator / factor;
		this.denominator = denominator / factor;
	}
	

	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public static void main(String[] args) {
		Fraction f = new Fraction(1,5);
		System.out.println("f: " + f);
		Fraction b = new Fraction(2,7);
		System.out.println("b: " + b);
		Fraction n = new Fraction();
		System.out.println("n: " + n);
		n = f.subtract(b);
		n.reduce();
		System.out.println(n);
		System.out.println("f + b: " + n);
		System.out.println(f.numerator + "  " + f.denominator);
		System.out.println(gcd(56, 42));
		f.reduce();
		System.out.println(f.divide(b));
	}

}
