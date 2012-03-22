package models;
 
import play.data.binding.As;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post extends Model {
 
    @Required
    public String title;
    
    @Required @As("yyyy-MM-dd")
    public Date postedAt;
    
    @Lob
    @Required
    @MaxSize(10000)
    public String content;
     
    public Post(String title, String content) { 
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }
  
    public String toString() {
        return title;
    }
 
}
