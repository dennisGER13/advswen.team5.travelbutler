package advswen.team5.travelbutler.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;

import advswen.team5.travelbutler.api.response.OWMResponse;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Language;
import net.aksingh.owmjapis.OpenWeatherMap.Units;


public class APIContainerOWM implements IAPIContainer {
	

	private float currentMinTemperatur;
	private float currentMaxTemperatur;
	private float currentHumidity;
	private float currentPressure;
	private String currentGeneralWeather;
	private String currentWeatherIcon;
	private ArrayList<Float> forecastTempMin= new ArrayList<Float>();
	private ArrayList<Float> forecastTempMax= new ArrayList<Float>();
	private ArrayList<String> forecastgeneral = new ArrayList<String>();
	OWMResponse owmresponse;
	OpenWeatherMap owm;
	@Override
	public OWMResponse processSearch(String requestString) {
		try {
			 owmresponse = new OWMResponse();
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
		
		return owmresponse;
	}
	
	
	
	public float getCurrentMinTemperatur() {
		return currentMinTemperatur;
	}



	public float getCurrentMaxTemperatur() {
		return currentMaxTemperatur;
	}



	public float getCurrentHumidity() {
		return currentHumidity;
	}



	public float getCurrentPressure() {
		return currentPressure;
	}



	public String getCurrentGeneralWeather() {
		return currentGeneralWeather;
	}



	public ArrayList<Float> getForecastTempMin() {
		return forecastTempMin;
	}



	public ArrayList<Float> getForecastTempMax() {
		return forecastTempMax;
	}



	public ArrayList<String> getForecastgeneral() {
		return forecastgeneral;
	}



	public OWMResponse getOwmresponse() {
		return owmresponse;
	}



	public OpenWeatherMap getOwm() {
		return owm;
	}



	public void searchWeatherInformation(String requestString)throws IOException, MalformedURLException, JSONException{

    owm = new OpenWeatherMap(Units.METRIC, Language.ENGLISH, "9d67ca64545f5cdd04e72bd82835d104");

    //Abrufen der Wetterinformationen des Strings
    CurrentWeather cwd = owm.currentWeatherByCityName(requestString);
    
    owmresponse.setCurrentMinTemperatur(currentMinTemperatur = cwd.getMainInstance().getMinTemperature());
    owmresponse.setCurrentMaxTemperatur(currentMaxTemperatur = cwd.getMainInstance().getMaxTemperature());
    owmresponse.setCurrentHumidity(currentHumidity = cwd.getMainInstance().getHumidity());
    owmresponse.setCurrentPressure(currentPressure = cwd.getMainInstance().getPressure());
    owmresponse.setCurrentGeneralWeather(currentGeneralWeather = cwd.getWeatherInstance(0).getWeatherDescription());
    owmresponse.setCurrentWeatherIcon(currentGeneralWeather = cwd.getWeatherInstance(0).getWeatherIconName());
    
   DailyForecast df = owm.dailyForecastByCityName(requestString, (byte) 5);
   for(int i=0;i<5;i++){
 	forecastTempMin.add(i, df.getForecastInstance(i).getTemperatureInstance().getMinimumTemperature());	
 	owmresponse.setForecastTempMin(forecastTempMin.get(i), i);
   	forecastTempMax.add(i, df.getForecastInstance(i).getTemperatureInstance().getMaximumTemperature());	
   	owmresponse.setForecastTempMax(forecastTempMax.get(i), i);
   	forecastgeneral.add(i, df.getForecastInstance(i).getWeatherInstance(0).getWeatherDescription());
   	owmresponse.setForecastgeneral(forecastgeneral.get(i), i);
   	
//   	System.out.println("Generell: " + df.getForecastInstance(i).getWeatherInstance(0).getWeatherDescription());
//   	System.out.println("Min Temp für Tag " + i + " " +forecastTempMin.get(i));
// 	System.out.println("Max Temp für Tag " + i + " " +forecastTempMax.get(i));
   }
    
    
//    System.out.println("Heute hat min" + currentMinTemperatur +" Grad");
//    System.out.println("Heute hat max" + currentMaxTemperatur +" Grad");  
//    System.out.println("Heute haben wir eine Humidity von:" + currentHumidity +" Prozent");
//    System.out.println("Heute haben wir eine Pressure von:" + currentPressure +" hpa");
//    System.out.println(currentGeneralWeather);
   

   
	}
	
}
