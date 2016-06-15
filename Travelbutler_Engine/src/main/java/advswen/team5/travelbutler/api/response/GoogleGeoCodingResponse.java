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
	private GoogleGeoAdressComponent result;
	

	public GoogleGeoCodingResponse(GoogleGeoCode fromJson) {

		fromJson = geocode;
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
		
		result = new GoogleGeoAdressComponent();
		List <String> list = Arrays.asList(result.getTypes());
		
		if(list.contains("locality")){
			
			return GrainEnum.city;
			
		} else if(list.contains("country")){
			
			return GrainEnum.country;
			
		} else {
			
			return GrainEnum.unknown;
			
		}
		
	}

}
