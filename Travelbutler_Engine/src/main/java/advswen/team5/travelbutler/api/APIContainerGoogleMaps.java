package advswen.team5.travelbutler.api;

/*
 * Author: Dennis Wagenblast
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import advswen.team5.travelbutler.api.response.GoogleMapsResponse;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerGoogleMaps implements IAPIContainer{

	@Override
	public GoogleMapsResponse processSearch(String requestString) {
		
		APIContainerGoogleMaps googleMaps = new APIContainerGoogleMaps();
		
		//Das Responseobjekt holt sich das Bild 
		GoogleMapsResponse response = new GoogleMapsResponse(googleMaps.getGoogleMapsImage(requestString));
		
		return response;
	}

	//Anfrage an GoogleMaps mit RequestString und der Groesse (500x500) des Bildes/der Karte
	public File getGoogleMapsImage(String requestString){
		try {
		   BufferedImage img = ImageIO.read(new URL("https://maps.googleapis.com/maps/api/staticmap?center="
				   + requestString + "&language=en&size=500x500"));
		    
		   File outputfile = new File("map.png");
		   ImageIO.write(img, "png", outputfile);
		   
		   return outputfile;
		   
		    } catch (Exception ex) {
		         System.out.println("Error uccured at processing Google Maps API request!" + ex);
		    }
		return null;
	}
}

