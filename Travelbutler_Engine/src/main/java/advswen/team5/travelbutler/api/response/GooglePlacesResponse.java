package advswen.team5.travelbutler.api.response;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import advswen.team5.travelbutler.api.google.images.GoogleSearchItem;
import advswen.team5.travelbutler.api.google.places.GooglePlace;

/*
 * Andreas Tauscher
 */

public class GooglePlacesResponse implements IAPIResponse {
	private boolean missing = false;
	private GooglePlace[] results;
	
	public GooglePlacesResponse(GooglePlace[] results) {
		super();
		this.results = results;
	}
	public boolean isMissing() {
		return missing;
	}
	public void setMissing(boolean missing) {
		this.missing = missing;
	}
	public GooglePlace[] getResults() {
		return results;
	}
	public void setResults(GooglePlace[] results) {
		this.results = results;
	}

	
}
