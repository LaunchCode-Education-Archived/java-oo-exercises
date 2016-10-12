package robots;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.Color;

public class RoboGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoboGUI window = new RoboGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoboGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ROBO-GUI");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateARobot = new JButton("Create a Robot");
		btnCreateARobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create a robot
				String name;
				int xPos; int yPos; int speed; int orientation;
					// get name, xPos, yPos, speed, orientation
				name = JOptionPane.showInputDialog(frame, 
						"Enter robot name:", 
						"ROBOT NAME", 
						JOptionPane.PLAIN_MESSAGE);
				xPos = getNumberInput("Enter x-position:", "X POSITION");
				yPos = getNumberInput("Enter y-position:", "Y POSITION");
				speed = getNumberInput("Enter speed:", "SPEED");
				orientation = getNumberInput("Enter orientation (0: north, 1: west, 2: south, 3: east):", "ORIENTATION");
				
				Robot r = new Robot(name, xPos, yPos, speed, orientation);
				System.out.println(r);
			}
		});
		btnCreateARobot.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnCreateARobot);
		
	}
	
	public int getNumberInput(String message, String title) {
		String num = JOptionPane.showInputDialog(frame, message, title, JOptionPane.PLAIN_MESSAGE);
		return Integer.parseInt(num);
	}

}
