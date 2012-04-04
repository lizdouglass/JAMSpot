package models;

import junit.framework.Assert;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommentTest {
	
	@Test
	//This test uses a 'hand rolled' stub
	public void shouldReturnAShortRepresentationForAComment() {
		Post post = new StubPost();
		String author = "Jonas";
		String content = "Do dum dah";
		Comment comment = new Comment(post, author, content);
		
		Assert.assertEquals("Hello from Mars, Do dum...", comment.shortRepresentation());
	}
	
	@Test
	//This test uses stubbing - via mockito 
	public void shouldReturnAShortRepresentationForAComment2() {
		Post post = mock(Post.class);
		String author = "Jonas";
		String content = "Do dum dah";
		Comment comment = new Comment(post, author, content);
		
		org.mockito.BDDMockito.when(post.shortRepresentation()).thenReturn("Post title...");
		
		Assert.assertEquals("Post title..., Do dum...", comment.shortRepresentation());
	}
	
	@Test
	//This test uses mocking
	public void shouldBeAbleToUpdateTheNumberOfViews(){
		Post post = mock(Post.class);
		String author = "Jonas";
		String content = "Do dum dah";
		Comment comment = new Comment(post, author, content);
		
		int count = 10;
		comment.updateViews(count);
		
		verify(post).updateViewCount(count);
	}
	
	@Test
	//This verifies our stub pre-canned expectations - redundant verification - Don't do this
	public void shouldReturnAShortRepresentationForAComment3() {
		Post post = mock(Post.class);
		String author = "Jonas";
		String content = "Do dum dah";
		Comment comment = new Comment(post, author, content);
		
		org.mockito.BDDMockito.when(post.shortRepresentation()).thenReturn("Post title...");
		
		Assert.assertEquals("Post title..., Do dum...", comment.shortRepresentation());
		verify(post).shortRepresentation();
	}

}
