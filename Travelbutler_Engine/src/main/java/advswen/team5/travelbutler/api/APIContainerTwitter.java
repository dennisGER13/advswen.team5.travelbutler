package advswen.team5.travelbutler.api;

import java.util.ArrayList;
import java.util.List;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.dialogue.InputDialogue;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class APIContainerTwitter implements IAPIContainer{
	
	@Override
	public TwitterResponse processSearch(String requestedString) {
		
		TwitterResponse response = new TwitterResponse(twitterFeed(requestedString));
		
		return response;
	}
	
	public List<Status> twitterFeed(String requestedString){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		//Twitter-API-Keys müssen anstelle der "null" eingesetzt werden!!!
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("cwIHzbPZzoe097AeWe7w5PnA2")
			.setOAuthConsumerSecret("HwCns5LD0NbvspTunsyEr0E4UJvXcuC0Qomh7SXiDfdi5dB59v")
			.setOAuthAccessToken("3040667098-r6eZUatWvdaiF618uVUxVPTSsRmyTjw5ewOsJgh")
			.setOAuthAccessTokenSecret("el1ZH6dEhniERoCCjhFIO6mCzM5ucYGLApUE7mAR29U9T");
		
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	    
		List<Status> tweets = null;
		List<Status> usedTweets = new ArrayList<Status>();
		
		try {
	    	  String queryString = requestedString + " travel OR holiday " + requestedString + " -filter:links"; 
	          Query query = new Query(queryString);
	          query.setLang("en");
	          QueryResult result;
	          
	          do {
	              result = twitter.search(query);
	              tweets = result.getTweets();
	             
	              for (Status tweet : tweets) {
	                  if(!tweet.isRetweet())
	                	  usedTweets.add(tweet);
	                  
	            	  System.out.println(tweet.getUser().getScreenName() + " ------ " + tweet.getText());
	              }
	         
	          } while ((query = result.nextQuery()) != null);
	     
	      } catch (TwitterException te) {
	          te.printStackTrace();
	          System.out.println("Failed to search tweets: " + te.getMessage());
	      }
		
		return  usedTweets;
		
	}

}
