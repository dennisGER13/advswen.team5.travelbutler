package advswen.team5.travelbutler.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class APIContainerWikipedia implements IAPIContainer {

	@Override
	public WikipediaResponse processSearch(String requestString) {
		Gson gson = new Gson();
		
		WikipediaResponse response = gson.fromJson(getPageAsJson(requestString), WikipediaResponse.class);
		
		System.out.println(response.getExtract());
		return response;

	}
	
	private JsonObject getPageAsJson(String requestString) {
		InputStream in = null;
		JsonObject page = null;
		try {
			in = new URL("https://de.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&indexpageids=1&titles=" + requestString + "&utf8=1&exintro=1&explaintext=1").openStream();
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
