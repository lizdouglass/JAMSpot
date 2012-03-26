package controllers;

import java.util.List;

import models.Post;
import play.mvc.Controller;

public class Posts extends Controller {
	
	public static void index(){
		List<Post> posts = Post.findAll();
		render(posts);
	}
	
	public static void show(int id){
		// TODO: implement show
	}
	
	public static void delete(long id){
		Post post = Post.findById(id);
		post.delete();
		Posts.index();
	}
	
}
