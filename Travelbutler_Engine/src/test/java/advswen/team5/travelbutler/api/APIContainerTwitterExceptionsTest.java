/**
 * 
 */
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
	 */
	// Funktioniert nur mit @Before, nicht mit @BeforeClass?!
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForNullString");
		processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 */
	// Funktioniert nur mit @Before, nicht mit @BeforeClass?!
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
