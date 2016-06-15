package advswen.team5.travelbutler.strategy;

import advswen.team5.travelbutler.api.APIContainerGoogleImages;
import advswen.team5.travelbutler.api.APIContainerGoogleMaps;
import advswen.team5.travelbutler.api.APIContainerGooglePlaces;
import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.response.GoogleImagesResponse;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.GooglePlacesResponse;

/*
 * Author: any author
 */

import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class ConcreteStrategyCity implements ISearchStrategy {

	public Response executeSearch(String requestString) {
		Response response = new Response(requestString);
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		TwitterResponse twitter = new APIContainerTwitter().processSearch(response.getDestination());
		GoogleMapsResponse googlemaps = new APIContainerGoogleMaps().processSearch(response.getDestination());
		GoogleImagesResponse googleImages = new APIContainerGoogleImages().processSearch(response.getDestination() + "+panorama");
		GooglePlacesResponse googlePlaces = new APIContainerGooglePlaces().processSearch("hotels in " + response.getDestination());

		response.setWikipediaResponse(wiki);
		response.setTwitterResponse(twitter);
		response.setGoogleMapsResponse(googlemaps);
		response.setGoogleImagesResponse(googleImages);
		response.setGooglePlacesResponse(googlePlaces);

		return response;
	}

}
