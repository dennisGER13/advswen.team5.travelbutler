package advswen.team5.travelbutler.api.google.gecoding;

/*
 * Author: Dennis Wagenblast
 */

public class GoogleGeoBounds {

    private GoogleGeoLatLng northeast;
    private GoogleGeoLatLng southwest;
	
    public GoogleGeoLatLng getNortheast() {
		return northeast;
	}
	public void setNortheast(GoogleGeoLatLng northeast) {
		this.northeast = northeast;
	}
	public GoogleGeoLatLng getSouthwest() {
		return southwest;
	}
	public void setSouthwest(GoogleGeoLatLng southwest) {
		this.southwest = southwest;
	}
    
    
	
}