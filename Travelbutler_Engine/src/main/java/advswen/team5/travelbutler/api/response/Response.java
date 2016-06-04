package advswen.team5.travelbutler.api.response;

public class Response {
	private String destination = null;
	private WikipediaResponse wikipediaResponse = null;
	private TwitterResponse twitterResponse = null;
	private GoogleMapsResponse googlemapsResponse = null;
	
	//Konstruktor, welcher das Reiseziel angibt
	public Response(String destination) {
		super();
		this.destination = destination;
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

	public String getDestination() {
		return destination;
	}

	public void setGoogleMapsResponse(GoogleMapsResponse googlemaps) {
		this.googlemapsResponse = googlemapsResponse;
		
	}
	
	public GoogleMapsResponse getGoogleMapsResponse(){
		
		if(googlemapsResponse.isMissing()){
			return null;
		}else{
			return googlemapsResponse;
		}
	}
}
