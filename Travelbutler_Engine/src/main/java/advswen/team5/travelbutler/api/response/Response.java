package advswen.team5.travelbutler.api.response;

public class Response {
	private WikipediaResponse wikipediaResponse = null;
	private TwitterResponse twitterResponse = null;
	
	public Response() {

	}

	public WikipediaResponse getWikipediaResponse() {
		if(wikipediaResponse.isMissing()){
			return null;
		}else{
			return wikipediaResponse;
		}
		
	}

	public void setWikipediaResponse(WikipediaResponse wikipediaResponse) {
		this.wikipediaResponse = wikipediaResponse;
	}

	public TwitterResponse getTwitterResponse() {
		if(twitterResponse.isMissing()){
			return null;
		}else{
			return twitterResponse;
		}
	}

	public void setTwitterResponse(TwitterResponse twitterResponse) {
		this.twitterResponse = twitterResponse;
	}
	
	
	
	

}
