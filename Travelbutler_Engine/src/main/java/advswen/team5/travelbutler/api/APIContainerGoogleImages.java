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

import advswen.team5.travelbutler.api.google.images.GoogleSearchItem;
import advswen.team5.travelbutler.api.response.GoogleImagesResponse;

public class APIContainerGoogleImages implements IAPIContainer {
	
	private final String API_KEY = "AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c";

	@Override
	public GoogleImagesResponse processSearch(String requestString) {
		Gson gson = new Gson();
		
		//Transform the JSON into a POJO and return it
		GoogleImagesResponse response = new GoogleImagesResponse(gson.fromJson(getPageAsJson(requestString), GoogleSearchItem[].class));
		return response;

	}
	
	// Returns the Google Custom Search API result as GSON JsonObject
	// TODO Error handling
	private JsonArray getPageAsJson(String requestString) {
		InputStream in = null;
		try {
			in = new URL("https://www.googleapis.com/customsearch/v1?key=" + API_KEY + "&limit=5&cx=011637653227000124025:pphpnrmqqlu&q=" + requestString.replace(" ", "+") + "&searchType=image&fileType=%22png,jpg%22").openStream();
			JsonParser parser = new JsonParser();
			return parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonArray("items");
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
