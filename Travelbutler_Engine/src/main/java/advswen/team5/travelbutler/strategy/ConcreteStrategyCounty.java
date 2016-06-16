package advswen.team5.travelbutler.strategy;

import java.util.ArrayList;
import java.util.List;

/*
 * Andreas Tauscher
 */

import advswen.team5.travelbutler.api.APIContainerGoogleImages;
import advswen.team5.travelbutler.api.APIContainerGoogleMaps;
import advswen.team5.travelbutler.api.APIContainerTravelbriefing;
import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.response.GoogleImagesResponse;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;
import advswen.team5.travelbutler.search.Listener;

public class ConcreteStrategyCounty extends AbstractSearchStrategy {
	
	@Override
	public Response executeSearch(String requestString) {
		Response response = new Response(requestString);
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		setProgress(getProgress() + 20);
		TwitterResponse twitter = new APIContainerTwitter().processSearch(response.getDestination());
		setProgress(getProgress() + 20);
		GoogleMapsResponse googlemaps = new APIContainerGoogleMaps().processSearch(response.getDestination());
		setProgress(getProgress() + 20);
		TravelbriefingResponse travelbriefing = new APIContainerTravelbriefing().processSearch(response.getDestination());
		setProgress(getProgress() + 20);
		GoogleImagesResponse googleImages = new APIContainerGoogleImages().processSearch(response.getDestination() + "+panorama");
		setProgress(getProgress() + 20);
		
		response.setWikipediaResponse(wiki);
		response.setTwitterResponse(twitter);
		response.setGoogleMapsResponse(googlemaps);
		response.setTravelbriefingResponse(travelbriefing);
		response.setGoogleImagesResponse(googleImages);
		
		return response;
	}
}
