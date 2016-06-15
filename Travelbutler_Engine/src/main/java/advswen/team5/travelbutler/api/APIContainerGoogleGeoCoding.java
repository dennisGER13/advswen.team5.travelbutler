package advswen.team5.travelbutler.api;

/*
 * Dennis Wagenblast
 */

import java.io.IOException;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoCode;
import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoResult;
import advswen.team5.travelbutler.api.response.GoogleGeoCodingResponse;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;

public class APIContainerGoogleGeoCoding implements IAPIContainer{

	private final String API_KEY ="AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c";
	
	@Override
	public GoogleGeoCodingResponse processSearch(String requestString) {

		Gson gson = new Gson();
		GoogleGeoCodingResponse response = new GoogleGeoCodingResponse(
				gson.fromJson(getGeoCode(requestString), GoogleGeoResult[].class));
		
		//Giving back response object including geocode object
		return response;
		
	}
	
	//Perform Google GeoCoding request
	private JsonArray getGeoCode(String requestString){

		InputStream in = null;
			
			try {
				
				in = new URL("https://maps.googleapis.com/maps/api/geocode/json?key="
						+ API_KEY + "&sensor=false&address=" + requestString.replace(" ", "+")).openStream();
				
				JsonParser parser = new JsonParser();
				return parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonArray("results");
			
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(in);
			}
			
		return null;
		
	}
}
