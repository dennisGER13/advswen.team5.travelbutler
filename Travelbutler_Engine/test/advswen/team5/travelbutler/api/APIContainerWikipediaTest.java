package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerWikipediaTest {
	
	private IAPIContainer iapiContainer;

	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerWikipedia();
	
	}
	

	@Test
	public void processSearchShouldNotBeNullForValidInputString() {
		System.out.println("Test: processSearchShouldNotBeNullForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch("Frankreich");
		assertNotNull(processSearch);
		
	}
	
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch("Frankreich");
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForBlankString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}


}
