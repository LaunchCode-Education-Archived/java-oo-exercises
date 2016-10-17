package blogz;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String username;
	private String password;
	private String hashedPassword;
	
	private static List<User> users = new ArrayList<User>();
	
	// Add a static property of type List<User> to hold the list of all users along with a method to return this list. 
	// This is similar to what you did in Gradebook Revisited. Note that List is an interface, 
	// so you'll need to choose an appropriate implemented type,
	// such as ArrayList, when initializing this property.
	
	public User(String pw) {
		this.password = pw;
		this.hashedPassword = User.hashPassword(pw);
		users.add(this);
	}
	
	private static List<User> getUsers() {
		return users;
	}
	
	private static String hashPassword(String pw) {
		// temporary method, will implement hashing behavior later
		return pw;
	}
	
	// verify a password against its hash
	private boolean isValidPassword (String pw) {
		return User.hashPassword(pw).equals(this.hashedPassword);
	}

	public String getUsername() {
		return username;
	}
	
	
	
}
