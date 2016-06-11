package advswen.team5.travelbutler.api;

import java.io.IOException;

/*
 * Dennis Wagenblast
 */

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.google.maps.GoogleGeoCode;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;

public class APIContainerGoogleMaps implements IAPIContainer{

	private final String API_KEY ="AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c";
	
	@Override
	public GoogleMapsResponse processSearch(String requestString) {

		Gson gson = new Gson();
		GoogleMapsResponse response = new GoogleMapsResponse(gson.fromJson(getGeoCode(requestString), GoogleGeoCode[].class));
		
		return response;
		
	}
	
	private JsonArray getGeoCode(String requestString){

		InputStream in = null;
			
			try {
				
				in = new URL("https://maps.googleapis.com/maps/api/geocode/json?key=" + API_KEY + "&sensor=false&address=" + requestString).openStream();
				JsonParser parser = new JsonParser();
				return parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonArray("geocodes");
			
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		return null;
		
	}
}
