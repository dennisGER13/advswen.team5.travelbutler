package advswen.team5.travelbutler.api.response;

/*
 * Andreas Tauscher
 */

// Wrapper for all response objects
public class Response {
	private String destination = null;
	private WikipediaResponse wikipediaResponse = null;
	private TwitterResponse twitterResponse = null;
	private GoogleMapsResponse googlemapsResponse = null;
	private TravelbriefingResponse travelbriefingResponse = null;
	private GoogleImagesResponse googleImagesResponse = null;
	private GooglePlacesResponse googlePlacesResponse = null;
	private OWMResponse openWeatherMapResponse = null;
	
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

	public GoogleMapsResponse getGoogleMapsResponse() {
		return googlemapsResponse;
	}

	public void setGoogleMapsResponse(GoogleMapsResponse googlemapsResponse) {
		this.googlemapsResponse = googlemapsResponse;
	}

	public TravelbriefingResponse getTravelbriefingResponse() {
		return travelbriefingResponse;
	}

	public void setTravelbriefingResponse(TravelbriefingResponse travelbriefingResponse) {
		this.travelbriefingResponse = travelbriefingResponse;
	}

	public GoogleImagesResponse getGoogleImagesResponse() {
		return googleImagesResponse;
	}

	public void setGoogleImagesResponse(GoogleImagesResponse googleImagesResponse) {
		this.googleImagesResponse = googleImagesResponse;
	}

	public GoogleMapsResponse getGooglemapsResponse() {
		return googlemapsResponse;
	}

	public void setGooglemapsResponse(GoogleMapsResponse googlemapsResponse) {
		this.googlemapsResponse = googlemapsResponse;
	}

	public GooglePlacesResponse getGooglePlacesResponse() {
		return googlePlacesResponse;
	}

	public void setGooglePlacesResponse(GooglePlacesResponse googlePlacesResponse) {
		this.googlePlacesResponse = googlePlacesResponse;
	}

	public OWMResponse getOpenWeatherMapResponse() {
		return openWeatherMapResponse;
	}

	public void setOpenWeatherMapResponse(OWMResponse openWeatherMapResponse) {
		this.openWeatherMapResponse = openWeatherMapResponse;
	}
	
	
	
	
}
