// *************************************************************************************
// File:         [TravelbriefingLanguageTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingLanguage
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;


public class TravelbriefingLanguageTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#TravelbriefingLanguage(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTravelbriefingLanguage() {
		System.out.println("Test: testTravelbriefingLanguage");
		String language = "English";				
		String official = "French";
		TravelbriefingLanguage trLanguage = new TravelbriefingLanguage(language, official );
		assertNotNull(trLanguage);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#getLanguage()}.
	 */
	@Test
	public void testGetLanguage() {
		System.out.println("Test: testGetLanguage");
		String language = "English";				
		String official = "French";
		TravelbriefingLanguage trLanguage = new TravelbriefingLanguage(language, official );
		assertEquals("English", trLanguage.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#setLanguage(java.lang.String)}.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("Test: testSetLanguage");
		String language = "English";				
		String official = "French";
		TravelbriefingLanguage trLanguage = new TravelbriefingLanguage(language, official );
		assertEquals("English", trLanguage.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#getOfficial()}.
	 */
	@Test
	public void testGetOfficial() {
		System.out.println("Test: testGetOfficial");
		String language = "English";				
		String official = "French";
		TravelbriefingLanguage trLanguage = new TravelbriefingLanguage(language, official );
		assertEquals("French", trLanguage.getOfficial());
		}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#setOfficial(java.lang.String)}.
	 */
	@Test
	public void testSetOfficial() {
		System.out.println("Test: testSetOfficial");
		String language = "English";				
		String official = "French";
		TravelbriefingLanguage trLanguage = new TravelbriefingLanguage(language, official );
		trLanguage.setOfficial("Spanish");
		assertEquals("Spanish", trLanguage.getOfficial());
		}

}
