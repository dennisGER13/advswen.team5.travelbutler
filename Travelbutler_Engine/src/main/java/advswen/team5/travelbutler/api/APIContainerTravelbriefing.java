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

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class APIContainerTravelbriefing implements IAPIContainer {

	@Override
	public TravelbriefingResponse processSearch(String requestString) {
		Gson gson = new Gson();

		//Transform the JSON into a POJO and return it
		TravelbriefingResponse response = gson.fromJson(getPageAsJson(requestString), TravelbriefingResponse.class);
		return response;

	}

	// Returns the Wikipedia API result as GSON JsonObject
	// TODO Error handling
	private JsonObject getPageAsJson(String requestString) {
		InputStream in = null;
		JsonObject page = null;
		try {
			in = new URL("https://travelbriefing.org/" + requestString.replace(" ", "_") + "?format=json").openStream();
			JsonParser parser = new JsonParser();
			return parser.parse(IOUtils.toString(in)).getAsJsonObject();

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
