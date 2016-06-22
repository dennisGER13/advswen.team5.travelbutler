package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

public class APIContainerOWMTest {
	
	@Mock
	CurrentWeather cw;
	
	@InjectMocks
	APIContainerOWM out;
	
	
	
	@Before
	public void setUp()throws Exception{
		out = new APIContainerOWM();
		MockitoAnnotations.initMocks(this);
		Mockito.when(cw.getMainInstance().getMinTemperature()).thenReturn(10.0F);
	}
	
	@Test
	public void testKonstruktorFunktioniert() {
		assertTrue(APIContainerOWM.class.isInstance(out));
	}
	
	@Test
	public void testAPIContainerOWMErzeugtCurrentWeatherObjekt(){
	fail();
	}
	
	@Test
	public void testeSetCurrentWeather(){
		float f = cw.getMainInstance().getMinTemperature();
		assertEquals(10.0F, f, 0);
	}

	
}
