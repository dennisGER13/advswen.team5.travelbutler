package advswen.team5.travelbutler.api.response;

/*
 * Author: Dennis Wagenblast
 */

import java.util.List;

import twitter4j.Status;

public class TwitterResponse implements IAPIResponse{
	
	private List <Status> tweets;
	private boolean missing = false;
	
	public TwitterResponse(List <Status> tweets){
		
		this.tweets = tweets;
		
		if(tweets.isEmpty()){
		
			this.missing = true;
		 
		}
		
	}
	
	public List<Status> getTweets() {
		return tweets;
	}

	public void setTweets(List<Status> tweets) {
		this.tweets = tweets;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}

	public boolean isMissing() {
		return missing;
	}
	
}
