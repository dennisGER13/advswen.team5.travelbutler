// *************************************************************************************
// File:         [TravelbriefingAdviseTest.java]
// Created:      [2016/06/07 Wednesday]
// Last Changed: $Date: 2016/06/19 10:42:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingAdvise
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TravelbriefingAdviseTest {
	
	/**
	 * Preparation for tests: TravelbriefingAdvise is being created with dummy-data
	 */
	
	private TravelbriefingAdvise travelAdvise;

	@Before
	public void setup(){
		travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");

	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#TravelbriefingAdvise(java.lang.String, java.lang.String)}.
	 * TravelbriefingAdvise should not be null.
	 */
	@Test
	public void testTravelbriefingAdviseShouldNotBeNull() {
		assertNotNull(travelAdvise);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getAdvise()}.
	 * The method getAdvise is being tested (generated dummy-data and returned value for advise should be equal).
	 */
	@Test
	public void testGetAdviseShouldBeEqualToConcreteAdvise() {
		assertEquals(travelAdvise.getAdvise(), "concrete advise");	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setAdvise(java.lang.String)}.
	 * The method setAdvise is being called and the new/changed concrete advise should be returned.
	 */
	@Test
	public void testGetAdviseShouldBeEqualToConcreteAdviseAfterSetMethod() {
		travelAdvise.setAdvise("new advise");
		assertEquals("new advise", travelAdvise.getAdvise());	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getUrl()}.
	 * The method getUrl is being tested (generated dummy-data and returned value for URL should be equal).
	 */
	@Test
	public void testGetUrlShouldBeEqualToUrl() {
		assertEquals("www.example.com", travelAdvise.getUrl());	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setUrl(java.lang.String)}.
	 * The method setUrl is being called and the new/changed URL should be returned.
	 */
	@Test
	public void testGetUrlShouldBeEqualToUrlAfterSetMethod() {
		travelAdvise.setUrl("www.example2.com");
		assertEquals("www.example2.com", travelAdvise.getUrl());	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getSource()}.
	 * The method getSource is being tested (should be null).
	 */
	@Test
	public void testGetSourceShouldBeNull() {
		assertNull(travelAdvise.getSource());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setSource(java.lang.String)}.
	 * The method setSource is being called and the new/changed source should be returned.
	 */
	@Test
	public void testGetSourceShouldBeEqualToSourceAfterSetMethod() {
		travelAdvise.setSource("source");
		assertEquals("source", travelAdvise.getSource());	
	}	

}
