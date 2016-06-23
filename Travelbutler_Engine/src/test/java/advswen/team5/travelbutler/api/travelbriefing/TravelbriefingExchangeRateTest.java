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

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingExchangeRateTest {
	
	private TravelbriefingExchangeRate exchangeRate1;

	/**
	 * Preparation for tests: TravelbriefingExchangeRate is being created with dummy-data
	 */
		
	@Before
	public void setup(){
		exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		
	}
	

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#TravelbriefingExchangeRate(java.lang.String, double)}.
	 * TravelbriefingExchangeRate should not be null.
	 */
	@Test
	public void testTravelbriefingExchangeRateShouldNotBeNull() {
		assertNotNull(exchangeRate1);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#getName()}.
	 * The method getName is being tested (generated dummy-data and returned value for name should be equal).
	 */
	@Test
	public void testGetNameShouldBeEqualToName() {
		assertEquals("name1", exchangeRate1.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#setName(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetNameShouldBeEqualToNewName() {
		exchangeRate1.setName("new name");
		assertEquals("new name", exchangeRate1.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#getRate()}.
	 * The method getRate is being tested (generated dummy-data and returned value for rate should be equal, delta is set to 0, thus there is no difference between the values).
	 */
	@Test
	public void testGetRateShouldBeEqualToRate() {
		assertEquals(1, exchangeRate1.getRate(), 0);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate#setRate(double)}.
	 * The method setRate is being called and the new/changed rate should be returned (delta is set to 0, thus there is no difference between the values).
	 */
	@Test
	public void testGetRateShouldBeEqualToNewRate() {
		exchangeRate1.setRate(2);
		assertEquals(2, exchangeRate1.getRate(), 0);
	}
	

}
