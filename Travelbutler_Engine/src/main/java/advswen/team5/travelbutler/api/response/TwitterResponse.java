package advswen.team5.travelbutler.api.response;

public class TwitterResponse implements IAPIResponse{

	private String user;
	private String tweet;
	private boolean missing = false;
	
	
	public TwitterResponse(String user, String tweet, boolean missing) {
		super();
		this.user = user;
		this.tweet = tweet;
		
		if (tweet == null || tweet.length() > 1) {
			this.missing = true;
		}

	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getTweet() {
		return tweet;
	}


	public void setTweet(String tweet) {
		this.tweet = tweet;
	}


	public boolean isMissing() {
		return missing;
	}


	public void setMissing(boolean missing) {
		this.missing = missing;
	}
	
}
