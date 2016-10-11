package fruit;

public class Peach implements Fruit{

	private String name = "peach";
	
	@Override
	public boolean isCitrus() {
		return false;
	}

	@Override
	public boolean isStone() {
		return true;
	}

	@Override
	public boolean isBerry() {
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	
	
}
