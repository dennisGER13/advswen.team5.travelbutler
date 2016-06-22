// *************************************************************************************
// File:         [APIContainerTwitterExceptionsTest.java]
// Created:      [2016/06/22 Wednesday]
// Last Changed: $Date: 2016/06/22 19:20:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerTwitter
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;


public class APIContainerTwitterExceptionsTest {

	private IAPIContainer iapiContainer;
	String searchString = "France";
	private IAPIResponse processSearch;
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
	
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The method processSearch should throw an AssertionError for null as provided parameter
	 */
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForNullString");
		processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The method processSearch should throw an AssertionError for a blank string
	 */
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForBlankString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForBlankString");
		processSearch = iapiContainer.processSearch("");
		assertNull(processSearch);
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
