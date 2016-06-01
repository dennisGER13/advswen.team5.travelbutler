package advswen.team5.travelbutler.api.response;

public class WikipediaResponse implements IAPIResponse {
	private String pageid;
	private String title;
	private String extract;
	private boolean missing = false;

	public WikipediaResponse(String pageid, String title, String extract) {
		super();
		this.pageid = pageid;
		this.title = title;
		this.extract = extract;

		// If no content is returend the page is not existing
		// TODO: Check for "Missing"-Attribute in response
		if (extract == null || extract.length() > 1) {
			this.missing = true;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPageid() {
		return pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public String getExtract() {
		return extract;
	}

	public void setExtract(String extract) {
		this.extract = extract;
	}

	public boolean isMissing() {
		return missing;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}

}
