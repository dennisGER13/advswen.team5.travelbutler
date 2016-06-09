package advswen.team5.travelbutler.api.google.images;

public class GoogleSearchItem {
	
	private String title;
	private GoogleSearchImage image;
	private String mime;
	
	public GoogleSearchItem(String title, GoogleSearchImage image, String mime) {
		super();
		this.title = title;
		this.image = image;
		this.mime = mime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GoogleSearchImage getImage() {
		return image;
	}

	public void setImage(GoogleSearchImage image) {
		this.image = image;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}
	
	
	

}
