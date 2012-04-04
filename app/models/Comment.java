package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="Comment")
public class Comment extends Model {
	
	@Required
	private String content;
	
	private String author;
	
	private int views;
	
	@ManyToOne
	private Post post;
	
    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }
    
    public String shortRepresentation() {
        return post.shortRepresentation() + ", " + content.substring(0, 6) + "..." ;
    }

	public void updateViews(int count) {
		post.updateViewCount(count);
	}

	
	
}
