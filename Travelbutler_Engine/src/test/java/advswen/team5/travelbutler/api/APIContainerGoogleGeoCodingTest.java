package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerGoogleGeoCodingTest {

	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerGoogleGeoCoding();
	}
	@Test
	public void testProcessSearchWithValidCitySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerGoogleGeoCoding#processSearch(java.lang.String)}.
	 * The returned GoogleGeoCoding should not be Null, if a valid country is entered.
	 */
	
	@Test
	public void testProcessSearchWithValidCountrySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerGoogleGeoCoding#processSearch(java.lang.String)}.
	 * The method isMissing should be false, if a valid city is entered.
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 	 */
	
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
	}
}
