package advswen.team5.travelbutler.api;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Language;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class APIContainerOWM implements IAPIContainer {
	
	@Override
	public IAPIResponse processSearch(String requestString) {
		try {
			this.searchWeatherInformation(requestString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void searchWeatherInformation(String requestString)throws IOException, MalformedURLException, JSONException{
	// declaring object of "OpenWeatherMap" class
    OpenWeatherMap owm = new OpenWeatherMap(Units.METRIC, Language.GERMAN, "9d67ca64545f5cdd04e72bd82835d104");

    // getting current weather data for the "London" city
    CurrentWeather cwd = owm.currentWeatherByCityName(requestString);

	

    //printing city name from the retrieved data
    System.out.println("City: " + cwd.getCityName());

    // printing the max./min. temperature
    System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                        + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
	}
	
}
