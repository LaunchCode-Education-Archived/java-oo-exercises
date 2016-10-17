package robots;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RobotMenu {

	private Scanner in;
	private ArrayList<Robot> robots;

	public RobotMenu() {
		this.in = new Scanner(System.in);
		this.robots = new ArrayList<Robot>();
	}

	public int menuOptions() {
		System.out.println("Robot Menu!\n" + "--------------------\n" + "1. Create a robot\n"
				+ "2. Display the list of available robots\n" + "3. Move a robot\n" + "4. Rotate a robot\n"
				+ "5. Compute the distance between two robots\n" + "6. Exit");
		System.out.println();
		int option;

		while (true) {
			System.out.println("Enter selection: ");
			try {
				option = in.nextInt();
				if (option > 0 && option < 7) {
					break;
				} else {
					;
				}
			} catch (InputMismatchException e) {
				;
			}
			System.out.println("Improper entry. Enter a number between 1-6");
			in.nextLine();
		}
		return option;
	}

	public void processOption(int option) {
		if (option == 1) {
			createRobot();
		} else if (option == 2) {
			displayRobots();
		} else if (option == 3) {
			moveRobot();
		} else if (option == 4) {
			rotateRobot();
		} else if (option == 5) {
			distanceBetweenRobots();
		} else {
			;
		}
	}

	public void createRobot() {
		String name;
		int xPos, yPos, speed, orientation;

		while (true) {
			System.out.println("Enter name of the robot: ");
			name = in.next();
			if (name != null) {
				break;
			}
		}
		while (true) {
			System.out.println("Enter x-position: ");
			try {
				xPos = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				;
			}
			in.nextLine();
		}
		while (true) {
			System.out.println("Enter y-position: ");
			try {
				yPos = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				;
			}
			in.nextLine();
		}
		while (true) {
			System.out.println("Enter speed: ");
			try {
				speed = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				;
			}
			in.nextLine();
		}
		while (true) {
			System.out.println("Enter orientation (0: North, 1: West, 2: South, 3: East): ");
			try {
				orientation = in.nextInt();
				if (orientation >= 0 && orientation < 4) {
					break;
				}
			} catch (InputMismatchException e) {
				;
			}
			System.out.println("Invalid input. Enter a number between 0-3");
			in.nextLine();
		}
		Robot r = new Robot(name, xPos, yPos, speed, orientation);
		robots.add(r);
	}

	public void displayRobots() {
		if (robots.size() != 0) {
			System.out.println("Robots:");
			for (int i = 0; i < robots.size(); i++) {
				System.out.println("  - Robot " + (i + 1) + ": " + robots.get(i));
			}
		} else {
			System.out.println("No robots");
		}
	}

	public void moveRobot() {
		if (robots.size() != 0) {
			displayRobots();
			int robot;
			while (true) {
				System.out.println("Select a robot:");
				try {
					robot = (in.nextInt() - 1);
					if (robot >= 0 && robot < robots.size()) {
						robots.get(robot).move();
						return;
					}
				} catch (InputMismatchException e) {
					;
				}
				System.out.println("Improper entry. Select a valid robot.");
				in.nextLine();
			}
		} else {
			System.out.println("No robots. Please add a robot.");
		}
	}

	public void rotateRobot() {
		if (robots.size() != 0) {
			displayRobots();
			int robot;
			while (true) {
				System.out.println("Select a robot:");
				try {
					robot = (in.nextInt() - 1);
					if (robot >= 0 && robot < robots.size()) {
						String rotation;
						while (true) {
							System.out.println("Enter a direction (left or right):");
							try {
								rotation = in.next().toLowerCase();
								if (rotation.equals("left") || rotation.equals("right")) {
									robots.get(robot).rotate(rotation);
									;
									return;
								}
							} catch (InputMismatchException e) {
								;
							}
						}

					}
				} catch (InputMismatchException e) {
					;
				}
				System.out.println("Improper entry. Select a valid robot.");
				in.nextLine();
			}
		} else {
			System.out.println("No robots. Please add a robot.");
		}
	}

	public void distanceBetweenRobots() {
		if (robots.size() < 2) {
			System.out.println("Minimum 2 robots needed to calculate distance. Create more robots.");
		} else {
			int robot1, robot2;
			displayRobots();
			while (true) {
				System.out.println("Select the first robot:");
				try {
					robot1 = (in.nextInt() - 1);
					if (robot1 >= 0 && robot1 < robots.size()) {
						break;
					}
				} catch (InputMismatchException e) {
					;
				}
				System.out.println("Improper entry. Select a valid robot.");
				in.nextLine();
			}
			while (true) {
				System.out.println("Select a second robot:");
				try {
					robot2 = (in.nextInt() - 1);
					if (robot2 >= 0 && robot2 < robots.size() && robot2 != robot1) {
						break;
					}
				} catch (InputMismatchException e) {
					;
				}
				System.out.println("Improper entry. Select a valid robot.");
				in.nextLine();
			}
			Robot r1 = robots.get(robot1);
			Robot r2 = robots.get(robot2);
			Double dist = r1.distanceFrom(r2);
			System.out.println(
					"The distance between " + r1.getName() + " and " + r2.getName() + " is " + dist + " units.");
		}
	}

	public static void main(String[] args) {
		int option;
		RobotMenu rm = new RobotMenu();
		do {
			System.out.println();
			option = rm.menuOptions();
			rm.processOption(option);
		} while (option != 6);
	}
}
