// *************************************************************************************
// File:         [APIContainerTravelbriefingTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/13 16:08:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerTravelbriefing
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerTravelbriefingTest {

	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTravelbriefing();
	
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * The returned TravelbriefingResponse should not be Null, if a valid city is entered.
	 */
	@Test
	public void testProcessSearchWithValidCitySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * The returned TravelbriefingResponse should not be Null, if a valid country is entered.
	 */
	@Test
	public void testProcessSearchWithValidCountrySearchString() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * The method isMissing should be false, if a valid city is entered.
	 */
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("Test: isMissingShouldBeFalseForValidCity");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * The method isMissing should be false, if a valid country is entered.
	 */
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("Test: isMissingShouldBeFalseForValidCountry");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * The method processSearch should throw a NullPointerException, if Null is provided.
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 * Travelbriefing returns information about the Netherlands as default values, so the method processSearch should not be Null, if a blank string is provided
	 */
	@Test
	public void processSearchWithBlankInputString() {
		System.out.println("Test: processSearchWithBlankInputString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNotNull(processSearch);
	}	


	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
