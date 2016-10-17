package blogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	
	private String username;
	private String password;
	private String hashedPassword;
	
	private static List<User> users = new ArrayList<User>();
	
	public User(String username, String pw) {
		if (!User.isValidUsername(username)) {
			throw new IllegalArgumentException();
		} 
		this.username = username;
		this.password = pw;
		this.hashedPassword = User.hashPassword(pw);
		users.add(this);
	}
	
	/*
	 * In the User class, write a static method isValidUsername that returns a boolean signifying whether or not the given string is valid. 
	 * A username should be considered valid if it is 4-12 characters long, starts with a letter, and contains only letters, numbers, -, and _. 
	 * This check should happen in the constructor, and an appropriate exception should be thrown if the username is not valid. 
	 * For this task, use the Pattern class, following the pattern used near the top of the linked reference page. 
	 * The regular expression to use is: [a-zA-Z][a-zA-Z0-9_-]{4,11}.
	 */
	public static boolean isValidUsername(String username) {
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}

	
	public static List<User> getUsers() {
		return users;
	}
	
	private static String hashPassword(String pw) {
		// temporary method, will implement hashing behavior later
		return pw;
	}
	
	// verify a password against its hash
	public boolean isValidPassword (String pw) {
		return User.hashPassword(pw).equals(this.hashedPassword);
	}

	public String getUsername() {
		return username;
	}
	
	
	
}
