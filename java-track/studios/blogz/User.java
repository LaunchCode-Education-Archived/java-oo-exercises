package blogz;

public class User {

	private String username;
	private String pwHash;
	
	public User(String username, String password) {
		this.username = username;
		this.pwHash = hashPassword(password);
	}
	
	private static String hashPassword(String password) {
		return null;
	}
	
	public boolean isValidPassword(String password) {
		return this.pwHash.equals(hashPassword(password));
	}
	
	public String getUsername() {
		return username;
	}
	
}
