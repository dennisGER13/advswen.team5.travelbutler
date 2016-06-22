// *************************************************************************************
// File:         [APIContainerTwitterTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/22 19:16:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerTwitter
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;


public class APIContainerTwitterTest {
	
	private IAPIContainer iapiContainer;
	String searchString = "France";
	private IAPIResponse processSearch;
	
	/**
	 * Preparation for tests: IAPIResponse being created via valid search-strings
	 */
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
		processSearch = iapiContainer.processSearch(searchString);
	
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The IAPIResponse should not be null for a valid search-string.
	 */
	@Test
	public void testProcessSearchShouldNotBeNull() {
		System.out.println("testProcessSearch");
		assertNotNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * isMissing for the IAPIResponse should not return false for a valid
	 */
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		assertFalse(processSearch.isMissing());
	}
	
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}



}