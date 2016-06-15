package advswen.team5.travelbutler.api.response;

/*
 * Author: Dennis Wagenblast
 */

import java.io.File;

public class GoogleMapsResponse implements IAPIResponse{

private boolean missing = false;
private File file;
private String baseUrl;

	
	//GoogleMapsResponse gets the map picture
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