package studio2;

public class BaseballPlayer {
	/**
	 * 	BaseballPlayer
	
	A baseball player has a name and a jersey number. Most players hit either right or left, but some can hit either way. 
	This object should be able to react when a player completes a game, recording how many hits and RBIs the player earned in that game. 
	A player has a certain number of runs and RBIs he or she has recorded over all games played. 
	A player has a certain number of games he or she has played.
	
	 */
	
	// fields
	
	private String firstName, lastName, plateSide;
	private int jerseyNumber, hits, rbi, gamesPlayed;
	private boolean switchHitter;
	
	// methods
	
	public BaseballPlayer(String firstName, String lastName, String plateSide, int jerseyNumber, boolean switchHitter) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.plateSide = plateSide;
		this.jerseyNumber = jerseyNumber;
		this.switchHitter = switchHitter;
		this.hits = 0;
		this.rbi = 0;
		this.gamesPlayed = 0;
	}
	
	public void playGame(int hits, int rbi) {
		this.gamesPlayed += 1;
		this.hits += hits;
		this.rbi += rbi;
	}

	public String toString() {
		return firstName + " " + lastName + " #" + jerseyNumber + "\n" +
		"Hits: " + hits + ", RBI: " + rbi + ", Games played: " + gamesPlayed;
	}

	public static void main(String[] args) {
		BaseballPlayer s = new BaseballPlayer("Starlin", "Castro", "R", 12, false);
		System.out.println(s);
		s.playGame(2, 3);
		System.out.println(s);
	}

}
