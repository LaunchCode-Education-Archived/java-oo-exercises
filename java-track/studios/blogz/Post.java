package blogz;

import java.util.Date;

public class Post {

	private String title;
	private String body;
	private User author;
	private Date created;
	
	public Post(String title, String body, User author) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.created = new Date();
	}
	
	
	
}
