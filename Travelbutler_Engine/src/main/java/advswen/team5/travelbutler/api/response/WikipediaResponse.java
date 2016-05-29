package advswen.team5.travelbutler.api.response;

public class WikipediaResponse implements ApiResponse {
	private String title;
	private String content;
	private boolean missing = false;
	
	public WikipediaResponse(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		
		if(content == null || content.length() > 1){
			this.missing = true;
		}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isMissing() {
		return missing;
	}
	public void setMissing(boolean missing) {
		this.missing = missing;
	}
	
	

}
