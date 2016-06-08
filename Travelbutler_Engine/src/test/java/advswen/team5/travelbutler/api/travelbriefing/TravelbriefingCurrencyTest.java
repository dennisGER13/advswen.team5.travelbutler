// *************************************************************************************
// File:         [TravelbriefingCurrencyTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingCurrency
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingCurrencyTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#TravelbriefingCurrency(java.lang.String, java.lang.String, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate[])}.
	 */
	@Test
	public void testTravelbriefingCurrency() {
		System.out.println("Test: testTravelbriefingCurrency");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		assertNotNull(trCurrency);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getName()}.
	 */
	@Test
	public void testGetName() {
		System.out.println("Test: testGetName");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		assertEquals("currencyname", trCurrency.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		System.out.println("Test: testSetName");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		trCurrency.setName("new currency name");
		assertEquals("new currency name", trCurrency.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getSymbol()}.
	 */
	@Test
	public void testGetSymbol() {
		System.out.println("Test: testGetSymbol");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		assertEquals("currencysymbol", trCurrency.getSymbol());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setSymbol(java.lang.String)}.
	 */
	@Test
	public void testSetSymbol() {
		System.out.println("Test: testGetSymbol");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		trCurrency.setSymbol("new symbol");
		assertEquals("new symbol", trCurrency.getSymbol());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getCompare()}.
	 */
	@Test
	public void testGetCompare() {
		System.out.println("Test: testGetCompare");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		assertArrayEquals(exchangeRateArray, trCurrency.getCompare());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setCompare(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate[])}.
	 */
	@Test
	public void testSetCompare() {
		System.out.println("Test: testGetCompare");
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("name3", 5);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("name4", 6);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate3, exchangeRate4};
		trCurrency.setCompare(exchangeRateArray2);
		assertArrayEquals(exchangeRateArray2, trCurrency.getCompare());
	}

}
