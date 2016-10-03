package robots;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotMenuTest {

	@Test
	public void testMenuOptions() {
		RobotMenu rm = new RobotMenu();
		int option = rm.menuOptions();
		assertTrue("Invalid numerical selection", option > 0 && option < 7);
	}

}
