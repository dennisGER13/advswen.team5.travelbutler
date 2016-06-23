package advswen.team5.travelbutler.api;

/*
 * Andreas Tauscher
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.google.places.GooglePlace;
import advswen.team5.travelbutler.api.response.GooglePlacesResponse;

public class APIContainerGooglePlaces implements IAPIContainer {

//	public GooglePlacesResponse processSearch(double lat, double lon, GooglePlaceType type) {
//		Gson gson = new Gson();
//
//		// Transform the JSON into a POJO and return it
//		GooglePlacesResponse response = new GooglePlacesResponse(
//				gson.fromJson(getAsJson(requestString), GooglePlace[].class));
//		return response;
//
//	}

	@Override
	public GooglePlacesResponse processSearch(String requestString) {
		Gson gson = new Gson();

		// Transform the JSON into a POJO and return it
		GooglePlacesResponse response = new GooglePlacesResponse(
				gson.fromJson(getAsJson(requestString), GooglePlace[].class));
		return response;
	}

	// Returns the Google Custom Search API result as GSON JsonObject
	// TODO Error handling
	private JsonArray getAsJson(String requestString) {
		InputStream in = null;
		try {
			in = new URL(
					"https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + requestString.replace(" ", "+") + "&key=AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c")
									.openStream();
			JsonParser parser = new JsonParser();
			return parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonArray("results");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}

		return null;
	}
}
