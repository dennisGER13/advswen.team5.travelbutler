package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import net.aksingh.owmjapis.CurrentWeather;

public class APIContainerOWMTest {
	
	APIContainerOWM out;

	
	
	@Before
	public void setUp()throws Exception{
		out = new APIContainerOWM();
		out.processSearch("Berlin");
	}
	
	@Test
	public void testKonstruktorFunktioniert() {
		assertTrue(APIContainerOWM.class.isInstance(out));
	}
	
	@Test
	public void testAPIContainerOWMErzeugtOpenWeatherMap(){
	assertNotNull(out.getOwm());
	}
	
	@Test
	public void testAPIContainerOWMErzeugtResponseObjekt(){
	assertNotNull(out.getOwmresponse());
	}
	
	@Test
	public void currentMinTemperaturWirdBefüllt(){
		assertTrue(out.getCurrentMinTemperatur() != 0.0f);
	}
	
	@Test
	public void currentMaxTemperaturWirdBefüllt(){
		assertTrue(out.getCurrentMaxTemperatur() != 0.0f);
	}
	
	@Test
	public void currentHumidityWirdBefüllt(){
		assertTrue(out.getCurrentHumidity() != 0.0f);
	}
	
	@Test
	public void currentPressureWirdBefüllt(){
		assertTrue(out.getCurrentPressure() != 0.0f);
	}

	@Test
	public void currentGeneralWeatherWirdBefüllt(){
		assertNotNull(out.getCurrentGeneralWeather());
	}
	
	@Test
	public void forecastTempMinWirdBefüllt(){
		try{
		assertTrue(out.getForecastTempMin().get(0) != 0.0f);
		}catch(IndexOutOfBoundsException e){
			fail();
		}
	}
	
	@Test
	public void forecastTempMaxWirdBefüllt(){
		try{
		assertTrue(out.getForecastTempMax().get(0) != 0.0f);
		}catch(IndexOutOfBoundsException e){
			fail();
		}
	}
	
	@Test
	public void forecastGeneralWirdBefüllt(){
		try{
		assertNotNull(out.getForecastgeneral().get(0));
		}catch(IndexOutOfBoundsException e){
			fail();
		}
	}
}
