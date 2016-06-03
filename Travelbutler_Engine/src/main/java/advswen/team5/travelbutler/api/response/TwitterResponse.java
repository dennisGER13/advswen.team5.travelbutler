package advswen.team5.travelbutler.api.response;

import java.util.List;

import twitter4j.Status;
import twitter4j.api.TweetsResources;

public class TwitterResponse implements IAPIResponse{
	
	private List <Status> tweets;
	private boolean missing = false;
	
	public TwitterResponse(List <Status> tweets){
		
		this.tweets = tweets;
		
		//Bei leerer Liste keine Ergebnisse zu Tweets
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