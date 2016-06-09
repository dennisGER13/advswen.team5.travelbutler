// *************************************************************************************
// File:         [APIContainerTravelbriefingTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
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
	 */
	@Test
	public void testProcessSearch() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 */
	@Test
	public void testProcessSearchForCountryNotNull() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 */
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
	 */
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTravelbriefing#processSearch(java.lang.String)}.
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
