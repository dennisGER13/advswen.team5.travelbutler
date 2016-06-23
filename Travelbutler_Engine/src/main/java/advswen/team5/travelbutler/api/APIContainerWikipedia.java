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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class APIContainerWikipedia implements IAPIContainer {

	@Override
	public WikipediaResponse processSearch(String requestString) {
		Gson gson = new Gson();
		
		//Transform the JSON into a POJO and return it
		WikipediaResponse response = gson.fromJson(getPageAsJson(requestString), WikipediaResponse.class);
		return response;

	}
	
	// Returns the Wikipedia API result as GSON JsonObject
	// TODO Error handling
	private JsonObject getPageAsJson(String requestString) {
		InputStream in = null;
		JsonObject page = null;
		try {
			in = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&indexpageids=1&titles=" + requestString.replace(" ", "+") + "&utf8=1&exintro=1&explaintext=1").openStream();
			JsonParser parser = new JsonParser();
			JsonObject o = parser.parse(IOUtils.toString(in)).getAsJsonObject().getAsJsonObject("query");
			
			String pageId = o.getAsJsonArray("pageids").get(0).getAsString();
			return o.getAsJsonObject("pages").getAsJsonObject(pageId);
			
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
