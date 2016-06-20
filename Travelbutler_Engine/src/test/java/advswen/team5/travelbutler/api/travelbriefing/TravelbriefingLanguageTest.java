// *************************************************************************************
// File:         [TravelbriefingLanguageTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/20 10:48:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingLanguage
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TravelbriefingLanguageTest {
	
	private String language;
	private String official;
	private TravelbriefingLanguage trLanguage;

	/**
	 * Preparation for tests: TravelbriefingExchangeRate is being created with dummy-data
	 */
	@Before
	public void setup(){
		language = "English";				
		official = "French";
		trLanguage = new TravelbriefingLanguage(language, official );
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#TravelbriefingLanguage(java.lang.String, java.lang.String)}.
	 * TravelbriefingLanguage should not be null.
	 */
	@Test
	public void testTravelbriefingLanguage() {
		assertNotNull(trLanguage);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#getLanguage()}.
	 * The method getLanguage is being tested (generated dummy-data and returned values for language should be equal).
	 */
	@Test
	public void testGetLanguageShouldBeEqualToLanguage() {
		assertEquals("English", trLanguage.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#setLanguage(java.lang.String)}.
	 * The method setLanguage is being called and the new/changed language should be returned.
	 */
	@Test
	public void testGetLanguageShouldBeEqualToNewLanguage() {
		trLanguage.setLanguage("Spanish");
		assertEquals("Spanish", trLanguage.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#getOfficial()}.
	 * The method getOfficial is being tested (generated dummy-data and returned values for official should be equal).
	 */
	@Test
	public void testGetOfficialShouldBeEqualToOfficial() {
		assertEquals("French", trLanguage.getOfficial());
		}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage#setOfficial(java.lang.String)}.
	 * The method setOfficial is being called and the new/changed official should be returned.
	 */
	@Test
	public void testGetOfficialShouldBeEqualToNewOfficial() {
		trLanguage.setOfficial("Spanish");
		assertEquals("Spanish", trLanguage.getOfficial());
		}

}
