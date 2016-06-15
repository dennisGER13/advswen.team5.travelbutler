package advswen.team5.travelbutler.api.response;

import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoCode;

/*
 * Author: Dennis Wagenblast
 */

public class GoogleGeoCodingResponse implements IAPIResponse{

	private boolean missing;
	private GoogleGeoCode[] geocode;
	

	public GoogleGeoCodingResponse(GoogleGeoCode[] fromJson) {

		fromJson = geocode;
	}

	@Override
	public void setMissing(boolean missing) {

		this.missing=missing;
		
	}

	@Override
	public boolean isMissing() {
		// TODO Auto-generated method stub
		return missing;
	}

}
