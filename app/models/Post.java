package models;
 
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import play.data.binding.As;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Post extends Model {
 
    @Required
    public String title;
    
    @Required
    public Date postedAt;
    
    @Lob
    @Required
    @MaxSize(10000)
    public String content;
    
    @OneToMany(mappedBy="post")
    public List<Comment> comments;
     
    public Post(String title, String content) { 
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }
  
    public String toString() {
        return title;
    }

	public String shortRepresentation() {
		return null;
	}

	public void updateViewCount(int count) {
		
	}
 
}
