package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerGoogleMapsTest {

	private IAPIContainer iapiContainer;
	String searchStringCity = "Moscow";
	String searchStringCountry = "Russia";
	private IAPIResponse processSearchCity;
	private IAPIResponse processSearchCountry;

	@Before
	public void setUp() throws Exception {
		
		iapiContainer = new APIContainerGoogleMaps();
		processSearchCity = iapiContainer.processSearch(searchStringCity);
		processSearchCountry = iapiContainer.processSearch(searchStringCountry);
	}

	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

	@Test
	public void processSearchShouldNotBeNullForValidCity() {
		System.out.println("processSearchShouldNotBeNullForValidCity");
		assertNotNull(processSearchCity);	
		// Testing that processSearch is not giving back null
	}
	@Test
	public void processSearchShouldNotBeNullForValidCity() {
		System.out.println("processSearchShouldNotBeNullForValidCity");
		assertNotNull(processSearchCountry);	
	}
	
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("isMissingShouldBeFalseForValidCity");
		assertFalse(processSearchCity.isMissing());
	}
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("isMissingShouldBeFalseForValidCountry");
		assertFalse(processSearchCountry.isMissing());
		
		 // The method processSearch should throw a NullPointerException, if null is provided
		 
	}
}
