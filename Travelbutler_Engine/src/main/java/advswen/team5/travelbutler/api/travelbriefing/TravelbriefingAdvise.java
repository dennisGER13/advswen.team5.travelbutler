package advswen.team5.travelbutler.api.travelbriefing;

public class TravelbriefingAdvise {
	private String advise;
	private String url;
	
	public TravelbriefingAdvise(String advise, String url) {
		super();
		this.advise = advise;
		this.url = url;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
