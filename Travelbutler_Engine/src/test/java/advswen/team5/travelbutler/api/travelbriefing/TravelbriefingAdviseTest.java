// *************************************************************************************
// File:         [TravelbriefingAdviseTest.java]
// Created:      [2016/06/07 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerTravelbriefing
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;


public class TravelbriefingAdviseTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#TravelbriefingAdvise(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTravelbriefingAdvise() {
		System.out.println("Test: testTravelbriefingAdvise");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("advise", "www.example.com");
		assertNotNull(travelAdvise);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getAdvise()}.
	 */
	@Test
	public void testGetAdvise() {
		System.out.println("Test: testGetAdvise");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertEquals(travelAdvise.getAdvise(), "concrete advise");	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setAdvise(java.lang.String)}.
	 */
	@Test
	public void testSetAdvise() {
		System.out.println("Test: testSetAdvise");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setAdvise("new advise");
		assertEquals(travelAdvise.getAdvise(), "new advise");	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getUrl()}.
	 */
	@Test
	public void testGetUrl() {
		System.out.println("Test: testGetUrl");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertEquals(travelAdvise.getUrl(), "www.example.com");	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setUrl(java.lang.String)}.
	 */
	@Test
	public void testSetUrl() {
		System.out.println("Test: testSetUrl");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setUrl("www.example2.com");
		assertEquals(travelAdvise.getUrl(), "www.example2.com");	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#getSource()}.
	 */
	@Test
	public void testGetSource() {
		System.out.println("Test: testGetSource");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertNull(travelAdvise.getSource());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise#setSource(java.lang.String)}.
	 */
	@Test
	public void testSetSource() {
		System.out.println("Test: testSetSource");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setSource("Source");
		assertEquals(travelAdvise.getSource(), "Source");	
	}	

}
