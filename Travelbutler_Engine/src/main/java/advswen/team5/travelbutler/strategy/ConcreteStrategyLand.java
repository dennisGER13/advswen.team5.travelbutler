package advswen.team5.travelbutler.strategy;

import advswen.team5.travelbutler.api.APIContainerGoogleImages;
import advswen.team5.travelbutler.api.APIContainerGoogleMaps;
import advswen.team5.travelbutler.api.APIContainerGoogleGeoCoding;
import advswen.team5.travelbutler.api.APIContainerTravelbriefing;
import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.response.GoogleImagesResponse;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class ConcreteStrategyLand implements ISearchStrategy {

	@Override
	public Response executeSearch(String requestString) {
		Response response = new Response(requestString);
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		TwitterResponse twitter = new APIContainerTwitter().processSearch(response.getDestination());
		GoogleMapsResponse googlemaps = new APIContainerGoogleMaps().processSearch(response.getDestination());
		TravelbriefingResponse travelbriefing = new APIContainerTravelbriefing().processSearch(response.getDestination());
		GoogleImagesResponse googleImages = new APIContainerGoogleImages().processSearch(response.getDestination());
		
		response.setWikipediaResponse(wiki);
		response.setTwitterResponse(twitter);
		response.setGoogleMapsResponse(googlemaps);
		response.setTravelbriefingResponse(travelbriefing);
		response.setGoogleImagesResponse(googleImages);
		return response;
	}

}
