package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public class APIContainerWikipediaTest {

	@Test
	public void wikipediaResponse_should_not_be_null() {
		IAPIContainer iapiContainer = new APIContainerWikipedia();
		IAPIResponse processSearch = iapiContainer.processSearch("Frankreich");
		assertNotNull(processSearch);
		
	}
	
	@Test
	public void isMissing_should_be_false() {
		IAPIContainer iapiContainer = new APIContainerWikipedia();
		IAPIResponse processSearch = iapiContainer.processSearch("Frankreich");
		assertFalse(processSearch.isMissing());
	}

}
