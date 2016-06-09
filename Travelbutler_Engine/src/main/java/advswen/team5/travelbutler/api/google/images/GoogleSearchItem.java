package advswen.team5.travelbutler.api.google.images;

public class GoogleSearchItem {
	
	private String title;
	private String link;
	private GoogleSearchImage image;
	private String mime;
	
	public GoogleSearchItem(String title, String link, GoogleSearchImage image, String mime) {
		super();
		this.title = title;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	
	

}
