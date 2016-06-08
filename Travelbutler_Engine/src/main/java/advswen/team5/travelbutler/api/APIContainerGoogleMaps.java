package advswen.team5.travelbutler.api;

/*
 * Dennis Wagenblast
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import advswen.team5.travelbutler.api.google.maps.GoogleGeoCode;
import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerGoogleMaps implements IAPIContainer{

	private boolean missing = false;
	private final String API_KEY ="AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c";
	
	@Override
	public GoogleMapsResponse processSearch(String requestedString) {

		try {
			GoogleMapsResponse response = new GoogleMapsResponse(getGeoCode(requestedString));
			
			return response;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}
	
	public GoogleGeoCode getGeoCode(String requestedString) throws Exception {

		// Erzeugen der URL für die Anfrage der geocoding-GoogleMaps API
		boolean ssl = true;
	    StringBuilder url = new StringBuilder("http");
	    if ( ssl ) {
	        url.append("s");
	    }
	   
	    url.append("://maps.googleapis.com/maps/api/geocode/json?");
	   
	    if ( ssl ) {
	        url.append("key=");
	        url.append(API_KEY);
	        url.append("&");
	    }
	    url.append("sensor=false&address=");
	    url.append( URLEncoder.encode(requestedString) );
	  
	    // Führe die Anfrage an die API aus
	    try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
	        HttpGet request = new HttpGet(url.toString());

	        try (CloseableHttpResponse response = httpclient.execute(request)) {
	            HttpEntity entity = response.getEntity();

	            StringBuilder result = new StringBuilder();
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    result.append(inputLine);
	                    result.append("\n");
	                }
	            }

	            // Mappen des Ergebnisses der Anfrage
	            ObjectMapper mapper = new ObjectMapper();
	            GoogleGeoCode geocode = mapper.readValue(result.toString(), GoogleGeoCode.class);

	            if (!"OK".equals(geocode.getStatus())) {
	                if (geocode.getError_message() != null) {
	                    throw new Exception(geocode.getError_message());
	                }
	                throw new Exception("Can not find geocode for: " + requestedString);
	            }
	            //Gebe das Ergbnisobjekt zurueck
	            return geocode;
	        }
	    }
	}
}
