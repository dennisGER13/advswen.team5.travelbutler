package advswen.team5.travelbutler.api;

/*
 * Author: Dennis Wagenblast
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import advswen.team5.travelbutler.api.response.GoogleMapsResponse;

public class APIContainerGoogleMaps implements IAPIContainer {

	@Override
	public GoogleMapsResponse processSearch(String requestString) {

		APIContainerGoogleMaps googleMaps = new APIContainerGoogleMaps();

		// Response object is about to get the map picture
		GoogleMapsResponse response = new GoogleMapsResponse(googleMaps.getGoogleMapsImage(requestString), getBaseUrl(requestString));

		return response;
	}

	// Perform request call to Google Maps 
	private File getGoogleMapsImage(String requestString) {
		try {
			BufferedImage img = ImageIO.read(new URL(getBaseUrl(requestString) + "&size=500x500"));

			File outputfile = new File("map.png");
			ImageIO.write(img, "png", outputfile);

			return outputfile;

		} catch (Exception ex) {
			System.out.println("Error uccured at processing Google Maps API request!" + ex);
		}
		return null;
	}

	private String getBaseUrl(String requestString){
		return "https://maps.googleapis.com/maps/api/staticmap?center="
				   + requestString.replace(" ", "+") + "&language=en";
	}
}
