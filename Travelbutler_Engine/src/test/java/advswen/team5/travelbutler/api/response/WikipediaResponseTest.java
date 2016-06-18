// *************************************************************************************
// File:         [WikipediaResponseTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/17 19:48:00 $
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



public class WikipediaResponseTest {

	/**
	 * Preparation for tests: WikipediaResponse wikiResponse is being created with dummy-data
	 */
	

	private WikipediaResponse wikiResponse;
	private String pageid;
	private String title;
	private String extract;
	
	

	@Before
	public void setup(){
		System.out.println("Setup");
		pageid = "12";
		title = "title";
		extract = "This is an extract. It's generated for test-purposes";
		wikiResponse = new WikipediaResponse(pageid, title, extract);
	
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#WikipediaResponse(java.lang.String, java.lang.String, java.lang.String)}.
	 * The WikipediaResponse should not be null.
	 */
	@Test
	public void testWikipediaResponseShouldNotBeNull() {
		assertNotNull(wikiResponse);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getTitle()}.
	 * The method getAdvise is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetTitleShouldBeEqualToTitle() {
		System.out.println("Test: testGetTitle");	
		assertEquals("title", wikiResponse.getTitle());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setTitle(java.lang.String)}.
	 * The method setTitle is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetTitleShouldBeEqualToTitle2AfterSetMethod() {
		String title2 = "title2";
		wikiResponse.setTitle(title2);
		assertEquals("title2", wikiResponse.getTitle());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getPageid()}.
	 * The method getPageid is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetPageidShouldBeEqualToPageid() {
		assertEquals("12", wikiResponse.getPageid());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setPageid(java.lang.String)}.
	 * The method setPageid is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetPageidShouldBeEqualToPageid2AfterSetMethod() {
		String pageid2 = "13";
		wikiResponse.setPageid(pageid2);
		assertEquals("13", wikiResponse.getPageid());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getExtract()}.
	 * The method getExtract is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetExtractShouldBeEqualToExtract() {
		assertEquals("This is an extract. It's generated for test-purposes", wikiResponse.getExtract());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setExtract(java.lang.String)}.
	 * The method setExtract is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetExtractShouldBeEqualToExtract2AfterSetMethod() {
		String extract2 = "This is another extract. It's also generated for test-purposes";
		wikiResponse.setExtract(extract2);
		assertEquals("This is another extract. It's also generated for test-purposes", wikiResponse.getExtract());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#isMissing()}.
	 * The method isMissing is being tested (isMissing should not be false).
	 */
	@Test
	public void testIsMissingShouldBeFalseForValidWikipediaResponse() {
		assertFalse(wikiResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#setMissing(boolean)}.
	 * The method setMissing is being called with parameter "true" and the returned value should be "true".
	 */
	@Test
	public void testIsMissingShouldBeTrueAfterSettingMethodWithTrue() {
		wikiResponse.setMissing(true);
		assertTrue(wikiResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getShortExtract(int)}.
	 * The method getShortExtract is being tested. This method ensures that the text in generated PDF is not too long.
	 * It also should detect the end of a sentence (by searching for a dot/"."), so that the text does not end within a sentence.
	 * It needs an Integer as parameter which declares the maximum length of the shortened extract.
	 */
	@Test
	public void testGetShortExtractShouldBeEqualToFirstSentenceOfTheGivenExtract() {
		WikipediaResponse wikiResponse2 = new WikipediaResponse(pageid, title, "This is an extract. It's generated for test-purposes");
		assertEquals("This is an extract.", wikiResponse2.getShortExtract(18));
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.WikipediaResponse#getShortExtract(int)}.
	 */
	@Test
	public void testShortExtractShouldAlsoBeEqualToFirstSentenceAndNotBeingCutOffWithinTheSecondSentence() {
		WikipediaResponse wikiResponse2 = new WikipediaResponse(pageid, title, "This is an extract. It's generated for test-purposes");
		assertEquals("This is an extract.", wikiResponse2.getShortExtract(26));
	}
	
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		
	}

}
