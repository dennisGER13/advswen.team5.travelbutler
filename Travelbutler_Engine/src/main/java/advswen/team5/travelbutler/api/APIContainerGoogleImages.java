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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.response.GoogleImagesResponse;
import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class APIContainerGoogleImages implements IAPIContainer {

	@Override
	public GoogleImagesResponse processSearch(String requestString) {
		Gson gson = new Gson();
		
		//Transform the JSON into a POJO and return it
		GoogleImagesResponse response = gson.fromJson(getPageAsJson(requestString), GoogleImagesResponse.class);
		return response;

	}
	
	// Returns the Google Custom Search API result as GSON JsonObject
	// TODO Error handling
	private JsonObject getPageAsJson(String requestString) {
		InputStream in = null;
		JsonObject page = null;
		try {
			in = new URL("https://www.googleapis.com/customsearch/v1?key=AIzaSyA5Fo9hzLVtie6kO8eQhQNCLXbL-QMtnQs&cx=011637653227000124025:pphpnrmqqlu&q=" + requestString.replace(" ", "+") + "+panorama&searchType=image&fileType=%22png,jpg%22").openStream();
			JsonParser parser = new JsonParser();
			return parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonObject("items");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		
		return page;
	}
}
