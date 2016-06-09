package advswen.team5.travelbutler.api.google.images;

public class GoogleSearchImage {
	private String contextLink;
	private int width;
	private int height;
	
	public GoogleSearchImage(String contextLink, int width, int height) {
		super();
		this.contextLink = contextLink;
		this.width = width;
		this.height = height;
	}

	public String getContextLink() {
		return contextLink;
	}

	public void setContextLink(String contextLink) {
		this.contextLink = contextLink;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
