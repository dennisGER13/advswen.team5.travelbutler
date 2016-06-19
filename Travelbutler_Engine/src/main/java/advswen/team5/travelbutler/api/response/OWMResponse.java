package advswen.team5.travelbutler.api.response;

import java.util.ArrayList;

import advswen.team5.travelbutler.api.IAPIContainer;

public class OWMResponse implements IAPIResponse{

	private String cityname;
	private float currentMinTemperatur;
	private float currentMaxTemperatur;
	private float currentHumidity;
	private float currentPressure;
	private String currentGeneralWeather;
	private ArrayList<Float> forecastTempMin= new ArrayList<Float>();
	private ArrayList<Float> forecastTempMax= new ArrayList<Float>();
	private ArrayList<String> forecastgeneral = new ArrayList<String>();
	
	public OWMResponse(){
		super();
	}
	public String getCityname() {
		return cityname;
	}



	public void setCityname(String cityname) {
		this.cityname = cityname;
	}



	public float getCurrentMinTemperatur() {
		return currentMinTemperatur;
	}



	public void setCurrentMinTemperatur(float currentMinTemperatur) {
		this.currentMinTemperatur = currentMinTemperatur;
	}



	public float getCurrentMaxTemperatur() {
		return currentMaxTemperatur;
	}



	public void setCurrentMaxTemperatur(float currentMaxTemperatur) {
		this.currentMaxTemperatur = currentMaxTemperatur;
	}



	public float getCurrentHumidity() {
		return currentHumidity;
	}



	public void setCurrentHumidity(float currentHumidity) {
		this.currentHumidity = currentHumidity;
	}



	public float getCurrentPressure() {
		return currentPressure;
	}



	public void setCurrentPressure(float currentPressure) {
		this.currentPressure = currentPressure;
	}



	public String getCurrentGeneralWeather() {
		return currentGeneralWeather;
	}



	public void setCurrentGeneralWeather(String currentGeneralWeather) {
		this.currentGeneralWeather = currentGeneralWeather;
	}



	public ArrayList<Float> getForecastTempMin() {
		return forecastTempMin;
	}



	public void setForecastTempMin(float forecastTempMin, int tplus) {
		this.forecastTempMin.add(tplus, forecastTempMin);
	}



	public ArrayList<Float> getForecastTempMax() {
		return forecastTempMax;
	}



	public void setForecastTempMax(Float forecastTempMax, int tplus) {
		this.forecastTempMax.add(tplus, forecastTempMax);
	}




	public ArrayList<String> getForecastgeneral() {
		return forecastgeneral;
	}



	public void setForecastgeneral(String forecastgeneral, int tplus) {
		this.forecastgeneral.add(tplus, forecastgeneral);
	}


	

		

	
	@Override
	public void setMissing(boolean missing) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMissing() {
		// TODO Auto-generated method stub
		return false;
	}



	
}
