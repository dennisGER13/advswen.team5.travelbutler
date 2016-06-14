package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import advswen.team5.travelbutler.api.response.IAPIResponse;




public class APIContainerTwitterMockTest {
	String searchStringCountry = "France";
	String searchStringCity = "Paris";
			
	
	
	IAPIContainer container;
	@Before
	public void setUp(){
		// mock erstellen
	    container = Mockito.mock(IAPIContainer.class);
	    
		when(container.processSearch(searchStringCity)).thenReturn(null);
		when(container.processSearch(searchStringCountry)).thenReturn(null);
		
		assertEquals(container.processSearch(searchStringCity),"paris");
		
	}
	@Test
	public void testProcessSearch() {
		assertNotNull(container);
	}

	@Test
	public void testTwitterFeed() {
		fail("Not yet implemented");
	}

}
