// *************************************************************************************
// File:         [TravelbriefingExchangeRateTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingExchangeRate
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingExchangeRateTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#TravelbriefingExchangeRate(java.lang.String, double)}.
	 */
	@Test
	public void testTravelbriefingExchangeRate() {
		System.out.println("Test: testTravelbriefingExchangeRate");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		assertNotNull(exchangeRate1);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#getName()}.
	 */
	@Test
	public void testGetName() {
		System.out.println("Test: testGetName");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		assertEquals("name1", exchangeRate1.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		System.out.println("Test: testSetName");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		exchangeRate1.setName("new name");
		assertEquals("new name", exchangeRate1.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#getRate()}.
	 */
	@Test
	public void testGetRate() {
		System.out.println("Test: testGetRate");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		assertEquals(1, exchangeRate1.getRate(), 0);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#setRate(double)}.
	 */
	@Test
	public void testSetRate() {
		System.out.println("Test: testSetRate");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		exchangeRate1.setRate(2);
		assertEquals(2, exchangeRate1.getRate(), 0);
	}
	

}
