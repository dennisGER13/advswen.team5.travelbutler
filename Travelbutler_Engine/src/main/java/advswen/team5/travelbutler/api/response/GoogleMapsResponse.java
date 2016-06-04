package advswen.team5.travelbutler.api.response;

import advswen.team5.travelbutler.google.maps.api.support.GoogleGeoCode;

public class GoogleMapsResponse implements IAPIResponse{

	private GoogleGeoCode geocode;
	private boolean missing = true;
	
	public GoogleMapsResponse(GoogleGeoCode geoCode) {
		
		this.geocode = geocode;

	}

	@Override
	public void setMissing(boolean missing) {
		
		this.missing=missing;
		
	}

	@Override
	public boolean isMissing() {

		return false;
	}

}
