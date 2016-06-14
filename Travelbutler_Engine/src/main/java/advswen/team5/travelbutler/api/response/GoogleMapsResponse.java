package advswen.team5.travelbutler.api.response;

import java.io.File;
import java.util.Map;

import advswen.team5.travelbutler.api.APIContainerGoogleMaps;
import advswen.team5.travelbutler.api.google.gecoding.GoogleGeoCode;

public class GoogleMapsResponse implements IAPIResponse{

private boolean missing = false;
private File file;
private String baseUrl;

	
	//GoogleMapsResponse enthält das Bild mit der Karte
	public GoogleMapsResponse(File file, String url) {
		super();
		this.file = file;
		this.baseUrl = url;
	}

	@Override
	public void setMissing(boolean missing) {
		
		this.missing=missing;
		
	}

	@Override
	public boolean isMissing() {

		return missing;
	}

	public File getFile() {
		return file;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
	
	public String getUrl(int dimX, int dimY){
		return baseUrl + "&size=" + dimX + "x" + dimY;
	}

		
}