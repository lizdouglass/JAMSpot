package models;

public class StubPost extends Post {

	public StubPost() {
		super("title", "content");
	}

	@Override
	public String shortRepresentation() {
		return "Hello from Mars";
	}
}
