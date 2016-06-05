package advswen.team5.travelbutler.starter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import advswen.team5.travelbutler.api.APIContainerGoogleMaps;
import advswen.team5.travelbutler.api.APIContainerTravelbriefing;
import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;
import advswen.team5.travelbutler.dialogue.*;
import advswen.team5.travelbutler.output.PDFGenerator;

public class Starter {
	
	private static final Logger logger = LogManager.getLogger(Starter.class);

	public static void main(String[] args){
		
//		InputDialogue inputdialogue = new InputDialogue();
//		inputdialogue.run();
		
		Response response = new Response("Syria");
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		TwitterResponse twitter = new APIContainerTwitter().processSearch(response.getDestination());
		GoogleMapsResponse googlemaps = new APIContainerGoogleMaps().processSearch(response.getDestination());
		TravelbriefingResponse travelbriefing = new APIContainerTravelbriefing().processSearch(response.getDestination());
		
		response.setWikipediaResponse(wiki);
		response.setTwitterResponse(twitter);
		response.setGooglemapsResponse(googlemaps);
		response.setTravelbriefingResponse(travelbriefing);
		
		try {
			new PDFGenerator(response).generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}