package advswen.team5.travelbutler.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import twitter4j.Status;




public class APIContainerTwitterMockTest {
	String searchStringCountry = "France";
	String searchStringCity = "Paris";
			
	public List <Status>  status = new ArrayList<Status>();
	
	
	
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
