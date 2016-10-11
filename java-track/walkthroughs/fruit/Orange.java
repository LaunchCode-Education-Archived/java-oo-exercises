package fruit;

public class Orange implements Fruit {

	private String name = "orange";
	
	@Override
	public boolean isCitrus() {
		return true;
	}

	@Override
	public boolean isStone() {
		return false;
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
