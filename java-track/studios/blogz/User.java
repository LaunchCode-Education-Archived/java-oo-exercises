package blogz;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String username;
	private String pwHash;
	private static final List<User> allUsers = new ArrayList<User>();
	
	public User(String username, String password) {
				
		this.username = username;
		this.pwHash = hashPassword(password);
		
		allUsers.add(this);
	}
	
	private static String hashPassword(String password) {
		// no hashing algorithm implemented yet; we'll do this later
		return password;
	}
	
	public boolean isValidPassword(String password) {
		return this.pwHash.equals(hashPassword(password));
	}
	
	public String getUsername() {
		return username;
	}
	
	public static List<User> getAllUsers() {
		return allUsers;
	}
	
	public boolean equals(Object o) {
		
		// exact same object literal
		if (this == o)
			return true;
		
		// null check
		if (o == null)
			return false;
		
		// type and cast check
		if (getClass() != o.getClass())
			return false;
		
		// cast to User for field comparison
		User user = (User) o;
		
		return user.getUsername() == username;
	}
	
}
