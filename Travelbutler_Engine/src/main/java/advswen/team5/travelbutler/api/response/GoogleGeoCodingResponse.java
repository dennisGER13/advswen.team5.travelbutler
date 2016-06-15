package advswen.team5.travelbutler.api.response;

import java.util.Arrays;
import java.util.List;

import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoAdressComponent;
import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoCode;
import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoResult;
import advswen.team5.travelbutler.search.GrainEnum;

/*
 * Author: Dennis Wagenblast
 */

public class GoogleGeoCodingResponse implements IAPIResponse{

	private boolean missing;
	private GoogleGeoCode geocode;
	private GoogleGeoResult[] results;
	

	public GoogleGeoCodingResponse(GoogleGeoResult[] results) {

		this.results = results;
	}

	@Override
	public void setMissing(boolean missing) {

		this.missing=missing;
		
	}

	@Override
	public boolean isMissing() {

		return missing;
	
	}
	
	//Method to get the Grain out of GoogleGeoCoding request
	public GrainEnum getGrain(){
		if(results.length < 1)
			return GrainEnum.unknown;
		
		List <String> list = Arrays.asList(results[0].getTypes());
		
		if(list.contains("locality")){
			
			return GrainEnum.city;
			
		} else if(list.contains("country")){
			
			return GrainEnum.country;
			
		} else {
			
			return GrainEnum.unknown;
			
		}
		
	}

}
