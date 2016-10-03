package robots;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {
	
	@Test
	public void testDistanceFromOtherRobot() {
		Robot r = new Robot("r", 0, 0, 0, 0);
		Robot q = new Robot("q", 5, 5, 0, 0);
		Double dist = Math.sqrt(Math.pow(q.getxPos() - r.getxPos(), 2) + Math.pow(q.getyPos() - r.getyPos(), 2));
		assertTrue("Distance formula incorrect", r.distanceFrom(q) == dist);
	}

	@Test
	public void testRotate() {
		Robot r = new Robot("r", 0, 0, 0, 0);
		r.rotate("left");
		assertTrue("Orientation did not add 1 for left turn", r.getOrientation() == 1);
		r.rotate("right");
		assertTrue("Orientation did not subtract 1 for right turn", r.getOrientation() == 0);
	}
	
	@Test
	public void testRotatePastLimits() {
		Robot r = new Robot("r", 0, 0, 0, 0);
		r.rotate("right");
		assertTrue("Orientation did not change from -1 to 3 as expected", r.getOrientation() == 3);
		r.rotate("left");
		assertTrue("Orientation did not change from 4 to 0 as expected", r.getOrientation() == 0);
	}
	
	@Test
	public void testMoveNorth() {
		Robot r = new Robot("r", 0, 0, 10, 0);
		r.move();
		assertTrue("Did not move north as expected", r.getxPos() == 0 && r.getyPos() == r.getSpeed());
	}
	
	@Test
	public void testMoveWest() {
		Robot r = new Robot("r", 0, 0, 9, 1);
		r.move();
		assertTrue("Did not move west as expected", r.getxPos() == -r.getSpeed() && r.getyPos() == 0);
	}
	
	@Test
	public void testMoveSouth() {
		Robot r = new Robot("r", 0, 0, 8, 2);
		r.move();
		assertTrue("Did not move south as expected", r.getxPos() == 0 && r.getyPos() == -r.getSpeed());
	}
	
	@Test
	public void testMoveEast() {
		Robot r = new Robot("r", 0, 0, 7, 3);
		r.move();
		assertTrue("Did not move east as expected", r.getxPos() == r.getSpeed() && r.getyPos() == 0);
	}

}
