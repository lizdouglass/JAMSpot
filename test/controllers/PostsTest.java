package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Post;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

public class PostsTest extends FunctionalTest {
	
	List<Post> posts = new ArrayList<Post>();
	
	@Before
	public void setUp() {
	    Fixtures.deleteDatabase();
	    loadPosts();
	}
	
	private void loadPosts(){
		Post firstPost = new Post("42", "The meaning of life");
		firstPost.save();
		posts.add(firstPost);
		
		Post secondPost = new Post("Beyond Earth", "My week on the moon");
		secondPost.save();
		posts.add(secondPost);
	}
	
	@Test
    public void shouldBeAbleToListAllPosts() {
		Response response = GET("/posts");
    	
		assertIsOk(response);
    	List<Post> renderedPosts = (List<Post>) renderArgs("posts");
    	assertThat(renderedPosts, is(posts));
    }
	
	@Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
	
	@Test
	public void shouldBeAbleToDeleteAPost(){
		long existingPostId = posts.get(0).id;
		
		Response response = DELETE("/posts/" + existingPostId);
		
		assertStatus(302, response);
		assertHeaderEquals("Location", "/", response);
	}

}
