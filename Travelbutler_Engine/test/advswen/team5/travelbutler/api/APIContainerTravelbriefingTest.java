package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;


public class APIContainerTravelbriefingTest {

	private IAPIContainer iapiContainer;
	String searchString = "Barcelona";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTravelbriefing();
	
	}

	@Test
	public void testProcessSearchNotNull() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertNotNull(processSearch);
	}
	
	
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
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