package robots;

public class SlowBendingBehavior implements RobotBehavior {

	public boolean doNextMove(Bender b) {
		if (b.getBendStrength() > 1) {
			b.setBendStrength(b.getBendStrength() - 1);
			System.out.println("Bending slower! Strength: " + b.getBendStrength());
		}
		if (b.getGirderAngle() < 90) {
			b.bend();
			System.out.println(b.getGirderAngle());
			return false;
		}
		else {
			System.out.println("Girder bent.");
			return true;
		}
	}

	
	
}
