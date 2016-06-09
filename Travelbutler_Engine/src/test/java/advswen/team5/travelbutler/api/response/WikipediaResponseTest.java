// *************************************************************************************
// File:         [WikipediaResponseTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für WikipediaResponse
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.response;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.IAPIContainer;

public class WikipediaResponseTest {

	
	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	

	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerWikipedia();
	
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#WikipediaResponse(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testWikipediaResponse() {
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertNotNull(wikiResponse);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		System.out.println("Test: testGetTitle");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("title", wikiResponse.getTitle());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		System.out.println("Test: testSetTitle");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setTitle("Title");
		assertEquals("Title", wikiResponse.getTitle());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getPageid()}.
	 */
	@Test
	public void testGetPageid() {
		System.out.println("Test: testGetPageid");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("12", wikiResponse.getPageid());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setPageid(java.lang.String)}.
	 */
	@Test
	public void testSetPageid() {
		System.out.println("Test: testSetPageid");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setPageid("13");
		assertEquals("13", wikiResponse.getPageid());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getExtract()}.
	 */
	@Test
	public void testGetExtract() {
		System.out.println("Test: testGetExtract");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("extract", wikiResponse.getExtract());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setExtract(java.lang.String)}.
	 */
	@Test
	public void testSetExtract() {
		System.out.println("Test: testSetExtract");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setExtract("new extract");
		assertEquals("new extract", wikiResponse.getExtract());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#isMissing()}.
	 */
	@Test
	public void testIsMissing() {
		System.out.println("Test: testIsMissing");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setMissing(false);
		assertFalse(wikiResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setMissing(boolean)}.
	 */
	@Test
	public void testSetMissing() {
		System.out.println("Test: testSetMissing");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setMissing(true);
		assertTrue(wikiResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getShortExtract(int)}.
	 */
//	@Test
//	public void testGetShortExtract() {
//		fail("Not yet implemented");
//	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
