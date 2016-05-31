package advswen.team5.travelbutler.api;

import java.util.List;

import advswen.team5.travelbutler.api.response.IAPIResponse;
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
	public IAPIResponse processSearch(String requestedString) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		//Twitter-API-Keys müssen anstelle der "null" eingesetzt werden!!!
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(null)
			.setOAuthConsumerSecret(null)
			.setOAuthAccessToken(null)
			.setOAuthAccessTokenSecret(null);
		
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	      try {
	    	  
	          Query query = new Query(requestedString);
	          QueryResult result;
	          
	          do {
	              result = twitter.search(query);
	              List<Status> tweets = result.getTweets();
	             
	              for (Status tweet : tweets) {
	                  System.out.println(tweet.getUser().getScreenName() + " ------ " + tweet.getText());
	              }
	         
	          } while ((query = result.nextQuery()) != null);
	          System.exit(0);
	     
	      } catch (TwitterException te) {
	          te.printStackTrace();
	          System.out.println("Failed to search tweets: " + te.getMessage());
	          System.exit(-1);
	      }
		
	      //Rückgabewert muss ausgewählt werden!!!
		return null;
	}

}
