package blogz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private String title;
	private String body;
	private User author;
	private Date created;
	private static final List<Post> allPosts = new ArrayList<Post>();
	
	public Post(String title, String body, User author) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.created = new Date();
		allPosts.add(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public Date getCreated() {
		return created;
	}
	
	private static List<Post> getPostsByUser(User user) {
		List<Post> postsByUser = new ArrayList<Post>();
		
		for (Post post : allPosts) {
			if (post.getAuthor().equals(user)) {
				postsByUser.add(post);
			}
		}
		
		return postsByUser;
	}
	
}
