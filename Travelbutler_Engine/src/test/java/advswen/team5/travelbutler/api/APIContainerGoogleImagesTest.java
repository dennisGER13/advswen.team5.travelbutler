package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerGoogleImagesTest {
	
	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";



	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerGoogleImages();
	}

	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
	}

	@Test
	public void testProcessSearchWithValidCitySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerGoogleImages#processSearch(java.lang.String)}.
	 * The returned GoogleImages should not be Null, if a valid country is entered.
	 */
	@Test
	public void testProcessSearchWithValidCountrySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerGoogleImages#processSearch(java.lang.String)}.
	 * The returned GoogleImages should not be Null, if a valid country is entered.
	 */
	
}
