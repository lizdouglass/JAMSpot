package controllers;

import java.util.List;
import models.Post;
import play.mvc.*;

public class Posts extends Controller {
	
	public static void index(){
		List<Post> posts = Post.findAll();
		render(posts);
	}
	
	public static void show(int id){
		// TODO: implement show
	}
}
