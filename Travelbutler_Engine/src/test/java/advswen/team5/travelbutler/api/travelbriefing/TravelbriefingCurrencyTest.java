// *************************************************************************************
// File:         [TravelbriefingCurrencyTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/19 19:52:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingCurrency
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingCurrencyTest {
	
	private TravelbriefingExchangeRate exchangeRate1;
	private TravelbriefingExchangeRate exchangeRate2;
	private TravelbriefingExchangeRate[] exchangeRateArray;
	private TravelbriefingCurrency trCurrency;

	/**
	 * Preparation for tests: TravelbriefingCurrency is being created with dummy-data
	 */
	
	@Before
	public void setup(){
		exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		exchangeRateArray = new TravelbriefingExchangeRate[] {exchangeRate1, exchangeRate2};
		trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);		
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#TravelbriefingCurrency(java.lang.String, java.lang.String, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate[])}.
	 * TravelbriefingCurrency should not be null.
	 */
	@Test
	public void testTravelbriefingCurrencyShouldNotBeNull() {
		assertNotNull(trCurrency);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getName()}.
	 * The method getName is being tested (generated dummy-data and returned value for name should be equal).
	 */
	@Test
	public void testGetNameShouldBeEqualToName() {
		assertEquals("currencyname", trCurrency.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setName(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetNameShouldBeEqualToNameAfterSetMethod() {
		trCurrency.setName("new currency name");
		assertEquals("new currency name", trCurrency.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getSymbol()}.
	 * The method getSymbol is being tested (generated dummy-data and returned value for symbol should be equal).
	 */
	@Test
	public void testGetSymbolShouldBeEqualToSymbol() {
		assertEquals("currencysymbol", trCurrency.getSymbol());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setSymbol(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetSymbolShouldBeEqualToSymbolAfterSetMethod() {
		trCurrency.setSymbol("new symbol");
		assertEquals("new symbol", trCurrency.getSymbol());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getCompare()}.
	 * The method getCompare is being tested (generated dummy-data and returned value for symbol should be equal).
	 */
	@Test
	public void testGetCompareShouldBeEqualToCompare() {
		assertArrayEquals(exchangeRateArray, trCurrency.getCompare());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setCompare(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate[])}.
	 * The method setCompare is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetCompareShouldBeEqualToCompareAfterSetMethod() {
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("name3", 5);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("name4", 6);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate3, exchangeRate4};
		trCurrency.setCompare(exchangeRateArray2);
		assertArrayEquals(exchangeRateArray2, trCurrency.getCompare());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getExchangeRates()}.
	 */
	@Test
	public void testGetExchangeRates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setExchangeRates(java.util.Map)}.
	 */
	@Test
	public void testSetExchangeRates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getExchangeRate(java.lang.String)}.
	 */
	@Test
	public void testGetExchangeRate() {
		fail("Not yet implemented");
	}

}
