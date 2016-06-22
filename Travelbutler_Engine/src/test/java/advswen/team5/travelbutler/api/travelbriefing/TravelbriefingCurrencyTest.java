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

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingCurrencyTest {
	
	private TravelbriefingExchangeRate exchangeRate1;
	private TravelbriefingExchangeRate exchangeRate2;
	private TravelbriefingExchangeRate[] exchangeRateArray;
	private Map<String, TravelbriefingExchangeRate> exchangeRateMap;
	private TravelbriefingCurrency trCurrency;

	/**
	 * Preparation for tests: TravelbriefingCurrency is being created with dummy-data
	 */
	
	@Before
	public void setup(){
		exchangeRate1 = new TravelbriefingExchangeRate("Euro", 1);
		exchangeRate2 = new TravelbriefingExchangeRate("US-Dollar", 1.5);
		exchangeRateArray = new TravelbriefingExchangeRate[] {exchangeRate1, exchangeRate2};
		trCurrency = new TravelbriefingCurrency("Euro", "currencysymbol", exchangeRateArray);
		exchangeRateMap = new HashMap<String, TravelbriefingExchangeRate>();
		for (TravelbriefingExchangeRate rate : exchangeRateArray) {
			exchangeRateMap.put(rate.getName(), rate);
		}
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
		assertEquals("Euro", trCurrency.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setName(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetNameShouldBeEqualToNewName() {
		trCurrency.setName("Yen");
		assertEquals("Yen", trCurrency.getName());
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
	public void testGetSymbolShouldBeEqualToNewSymbol() {
		trCurrency.setSymbol("new symbol");
		assertEquals("new symbol", trCurrency.getSymbol());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getCompare()}.
	 * The method getCompare is being tested (generated dummy-data and returned value for symbol should be equal).
	 */
	@Test
	public void testGetCompareShouldBeEqualToExchangeRateArray() {
		assertArrayEquals(exchangeRateArray, trCurrency.getCompare());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setCompare(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate[])}.
	 * The method setCompare is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetCompareShouldBeEqualToNewExchangeRate() {
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("name3", 5);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("name4", 6);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate3, exchangeRate4};
		trCurrency.setCompare(exchangeRateArray2);
		assertArrayEquals(exchangeRateArray2, trCurrency.getCompare());
	}
	
	/**
	 * ExchangeRateMap should not be null
	 */
	@Test
	public void testExchangeRateMapShouldNotBeNull() {
		assertNotNull(exchangeRateMap);
		
	}
	
	/**
	 * The object Map<String, TravelbriefingExchangeRate> exchangeRateMap should contain the name of ExchangeRate1 as key and ExchangeRate1 as value
	 */
	@Test
	public void testExchangeRateMapShouldContainExchangeRate1NameAsKeyAndExchangeRate1AsValue() {
//		System.out.println(exchangeRateMap.equals(exchangeRateMap));
//		System.out.println(map2.equals(map2))
		boolean blnExistsKey = exchangeRateMap.containsKey("Euro");
		boolean blnExistsValue = exchangeRateMap.containsValue(exchangeRate1);
		assertTrue(blnExistsKey && blnExistsValue);

	}
	
	/**
	 * The object Map<String, TravelbriefingExchangeRate> exchangeRateMap should contain the name of ExchangeRate2 as key and ExchangeRate2 as value
	 */
	@Test
	public void testExchangeRateMapShouldContainExchangeRate2NameAsKeyAndExchangeRate2AsValue() {
		boolean blnExistsKey = exchangeRateMap.containsKey("US-Dollar");
		boolean blnExistsValue = exchangeRateMap.containsValue(exchangeRate2);
		assertTrue(blnExistsKey && blnExistsValue);

	}
		
	/**
	 * 
	 */
	@Test
	public void testRateFromExchangeRate1ShouldBeEqualToCorrespondingRateFromExchangeRateMap() {
		assertEquals(1.0, trCurrency.getExchangeRates().get("Euro").getRate(), 0);			
	}
	
	/**
	 * 
	 */
	@Test
	public void testRateFromExchangeRate2ShouldBeEqualToCorrespondingRateFromExchangeRateMap() {
		assertEquals(1.5, trCurrency.getExchangeRates().get("US-Dollar").getRate(), 0);			
	}

	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getExchangeRates()}.
	 */
	@Test
	public void testGetExchangeRatesShouldBeEqualToExchangeRateMap() {
		assertEquals(exchangeRateMap, trCurrency.getExchangeRates());
		
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#setExchangeRates(java.util.Map)}.
	 */
	@Test
	public void testSetExchangeRateMap() {
		Map<String, TravelbriefingExchangeRate> exchangeRateMap2;
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("Yen", 3);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("CA-Dollar", 4);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate3, exchangeRate4};
		exchangeRateMap2 = new HashMap<String, TravelbriefingExchangeRate>();
		for (TravelbriefingExchangeRate rate : exchangeRateArray2) {
			exchangeRateMap2.put(rate.getName(), rate);
		}
		trCurrency.setExchangeRates(exchangeRateMap2);
		assertEquals(exchangeRateMap2, trCurrency.getExchangeRates());
		

	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency#getExchangeRate(java.lang.String)}.
	 */
	@Test
	public void testGetExchangeRate() {
//		System.out.println(trCurrency.getExchangeRate("currencyname"));
//		System.out.println(trCurrency.getExchangeRate("name1"));
//		System.out.println(trCurrency.getExchangeRate("name2"));
		assertEquals( 1.5, trCurrency.getExchangeRate("US-Dollar"), 0);
	}
	


}
