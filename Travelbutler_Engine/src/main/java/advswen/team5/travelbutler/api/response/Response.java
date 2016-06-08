package advswen.team5.travelbutler.api.response;

/*
 * Andreas Tauscher
 */

public class Response {
	private String destination = null;
	private WikipediaResponse wikipediaResponse = null;
	private TwitterResponse twitterResponse = null;
	private GoogleMapsResponse googlemapsResponse = null;
	private TravelbriefingResponse travelbriefingResponse = null;
	
	//Konstruktor, welcher das Reiseziel angibt
	public Response(String destination) {
		super();
		this.destination = destination;
	}

	public WikipediaResponse getWikipediaResponse() {
		return wikipediaResponse;
	}

	public void setWikipediaResponse(WikipediaResponse wikipediaResponse) {
		this.wikipediaResponse = wikipediaResponse;
	}

	public TwitterResponse getTwitterResponse() {
		return twitterResponse;
	}

	public void setTwitterResponse(TwitterResponse twitterResponse) {
		this.twitterResponse = twitterResponse;
	}

	public String getDestination() {
		return destination;
	}

	public GoogleMapsResponse getGooglemapsResponse() {
		return googlemapsResponse;
	}

	public void setGooglemapsResponse(GoogleMapsResponse googlemapsResponse) {
		this.googlemapsResponse = googlemapsResponse;
	}

	public TravelbriefingResponse getTravelbriefingResponse() {
		return travelbriefingResponse;
	}

	public void setTravelbriefingResponse(TravelbriefingResponse travelbriefingResponse) {
		this.travelbriefingResponse = travelbriefingResponse;
	}
	
	
}
