package advswen.team5.travelbutler.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import advswen.team5.travelbutler.api.response.GoogleMapsResponse;
import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.google.maps.api.support.GoogleGeoCode;

public class APIContainerGoogleMaps implements IAPIContainer{

	private boolean missing = false;
	private final String API_KEY ="AIzaSyDCfERTe9pquhxM38YqEhayDdjemtKBD0c";
	
	@Override
	public IAPIResponse processSearch(String requestedString) {

		GoogleMapsResponse response = null;
		try {
			response = new GoogleMapsResponse(getGeoCode(requestedString));
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return response;
	}
	
	public GoogleGeoCode getGeoCode(String requestedString) throws Exception {

		// build url
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
	   
	    // request url like: http://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address) + "&sensor=false"
	    // do request
	    try (CloseableHttpClient httpclient = HttpClients.createDefault();) {
	        HttpGet request = new HttpGet(url.toString());

	        try (CloseableHttpResponse response = httpclient.execute(request)) {
	            HttpEntity entity = response.getEntity();

	            // recover String response (for debug purposes)
	            StringBuilder result = new StringBuilder();
	            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
	                String inputLine;
	                while ((inputLine = in.readLine()) != null) {
	                    result.append(inputLine);
	                    result.append("\n");
	                }
	            }

	            // parse result
	            ObjectMapper mapper = new ObjectMapper();
	            GoogleGeoCode geocode = mapper.readValue(result.toString(), GoogleGeoCode.class);

	            if (!"OK".equals(geocode.getStatus())) {
	                if (geocode.getError_message() != null) {
	                    throw new Exception(geocode.getError_message());
	                }
	                throw new Exception("Can not find geocode for: " + requestedString);
	            }
	            return geocode;
	        }
	    }
	}
}
