package advswen.team5.travelbutler.api.response;

import java.util.Map;

import advswen.team5.travelbutler.api.google.maps.GoogleGeoCode;

public class GoogleMapsResponse implements IAPIResponse{

	private GoogleGeoCode [] geocodes;
	private boolean missing = false;
	
	public GoogleMapsResponse(GoogleGeoCode[] geocodes) {
		super();
		this.geocodes = geocodes;

	}

	public GoogleGeoCode[] getGeocodes() {
		return geocodes;
	}

	public void setGeocodes(GoogleGeoCode[] geocodes) {
		this.geocodes = geocodes;
	}

	@Override
	public void setMissing(boolean missing) {
		
		this.missing=missing;
		
	}

	@Override
	public boolean isMissing() {

		return missing;
	}
		
}