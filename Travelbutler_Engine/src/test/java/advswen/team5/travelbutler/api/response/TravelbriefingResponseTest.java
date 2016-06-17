// *************************************************************************************
// File:         [TravelbriefingResponseTest.java]
// Created:      [2016/06/09 Thursday]
// Last Changed: $Date: 2016/06/17 17:30:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingResponse
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.response;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater;


public class TravelbriefingResponseTest {
	
	private TravelbriefingResponse travelResponse;
	private TravelbriefingAdviseList adviseList;
	private TravelbriefingCurrency trCurrency;
	private TravelbriefingElectricity travelElectricity;
	private TravelbriefingLanguage[] trLanguageArray;
	private TravelbriefingTimezone trTimezone;
	private TravelbriefingVaccination[] trVaccinationArray;
	private TravelbriefingWater trWater;

	/**
	 * Preparation for tests: TravelbriefingResponse travelResponse is being created with dummy-data
	 */
	
	
	@Before
	public void setup(){
		System.out.println("Setup");
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		trLanguageArray = new TravelbriefingLanguage[] { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		trVaccinationArray = new TravelbriefingVaccination[] {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		trWater = new TravelbriefingWater(shortDescription);
		travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#TravelbriefingResponse(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage[], advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination[], advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater)}.
	 * The TravelbriefingResponse should not be null.
	 */
	@Test
	public void testTravelbriefingShouldNotBeNull() {
		assertNotNull(travelResponse);
	}
	

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getAdvise()}.
	 * The method getAdvise is being tested (generated dummy-data and returned value should be equal).
	 */
	  
	@Test
	public void testGetAdviseShouldBeEqualToAdviseList() {
		assertEquals(adviseList, travelResponse.getAdvise());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setAdvise(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList)}.
	 * The method setAdvise is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetAdviseShouldBeEqualToAdviseList2AfterSetMethod() {
		TravelbriefingAdvise travelAdvise4 = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		TravelbriefingAdvise travelAdvise5 = new TravelbriefingAdvise("concrete advise5", "www.example.com5");
		TravelbriefingAdvise travelAdvise6 = new TravelbriefingAdvise("concrete advise6", "www.example.com6");
		TravelbriefingAdviseList adviseList2 = new TravelbriefingAdviseList(travelAdvise4, travelAdvise5, travelAdvise6);
		travelResponse.setAdvise(adviseList2);
		assertEquals(adviseList2, travelResponse.getAdvise());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getCurrency()}.
	 * The method getCurrency is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetCurrencyShouldBeEqualToTrCurrency() {
		assertEquals(trCurrency, travelResponse.getCurrency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setCurrency(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency)}.
	 * The method setCurrency is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetCurrencyShouldBeEqualToTrCurrency2AfterSetMethod() {
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("name3", 1);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("name4", 3);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate3, exchangeRate4};
		TravelbriefingCurrency trCurrency2 = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray2);
		travelResponse.setCurrency(trCurrency2);
		assertEquals(trCurrency2, travelResponse.getCurrency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getElectricity()}.
	 * The method getElectricity is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetElectricityShouldBeEqualToTravelElectricity() {
		assertEquals(travelElectricity, travelResponse.getElectricity());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setElectricity(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity)}.
	 * The method setElectricity is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetElectricityShouldBeEqualToTravelElectricity2AfterSetMethod() {
		String[] plugs2 = {"Plug4", "Plug5", "Plug6"};
		TravelbriefingElectricity travelElectricity2 = new TravelbriefingElectricity("voltage1", "frequency", plugs2);
		travelResponse.setElectricity(travelElectricity2);
		assertEquals(travelElectricity2, travelResponse.getElectricity());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getLanguage()}.
	 * The method getLanguage is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetLanguageShouldBeEqualToTrLanguageArray() {
		assertArrayEquals(trLanguageArray, travelResponse.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setLanguage(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage[])}.
	 * The method setLanguage is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetlanguageShouldBeEqualToTrLanguageArray2AfterSetMethod() {
		TravelbriefingLanguage trLanguage3 = new TravelbriefingLanguage("German", "French" );
		TravelbriefingLanguage trLanguage4 = new TravelbriefingLanguage("Chinese", "French" );
		TravelbriefingLanguage[] trLanguageArray2 = { trLanguage3, trLanguage4};
		travelResponse.setLanguage(trLanguageArray2);
		assertArrayEquals(trLanguageArray2, travelResponse.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getTimezone()}.
	 * The method getTimezone is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetTimezoneShouldBeEqualToTrTimezone() {
		assertEquals(trTimezone, travelResponse.getTimezone());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setTimezone(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone)}.
	 * The method setTimezone is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetTimezoneShouldBeEqualToTrTimezone2AfterSetMethod() {
		TravelbriefingTimezone trTimezone2 = new TravelbriefingTimezone("timezone2");
		travelResponse.setTimezone(trTimezone2);
		assertEquals(trTimezone2, travelResponse.getTimezone());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getVaccinations()}.
	 * The method getVaccinations is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetVaccinationsShouldBeEqualToTrVaccinationArray() {
		assertArrayEquals(trVaccinationArray, travelResponse.getVaccinations());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setVaccinations(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination[])}.
	 * The method setVaccinations is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetVaccinationsShouldBeEqualToTrVaccinationArray2AfterSetMethod() {
		TravelbriefingVaccination trVaccination3 = new TravelbriefingVaccination("Vaccination-Name3", "Vaccination-Message3");
		TravelbriefingVaccination trVaccination4 = new TravelbriefingVaccination("Vaccination-Name4", "Vaccination-Message4");
		TravelbriefingVaccination[] trVaccinationArray2 = {trVaccination3, trVaccination4};
		travelResponse.setVaccinations(trVaccinationArray2);
		assertArrayEquals(trVaccinationArray2, travelResponse.getVaccinations());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getWater()}.
	 * The method getWater is being tested (generated dummy-data and returned value should be equal).
	 */
	@Test
	public void testGetWaterShouldBeEqualToTrWater() {
		assertEquals(trWater, travelResponse.getWater());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setWater(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater)}.
	 * The method setWater is being called and the new/changed values should be returned.
	 */
	@Test
	public void testGetWaterShouldBeEqualToTrWater2AfterSetMethod() {
		TravelbriefingWater trWater2 = new TravelbriefingWater("description2");
		travelResponse.setWater(trWater2);
		assertEquals(trWater2, travelResponse.getWater());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#isMissing()}.
	 * The method isMissing is being tested (isMissing should not be false).
	 */
	@Test
	public void testIsMissingShouldBeFalseForValidTravelResponse() {
		assertFalse(travelResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setMissing(boolean)}.
	 * The method setMissing is being called with parameter "true" and the returned value should be "true".
	 */
	@Test
	public void testIsMissingShouldBeTrueAfterSettingMethodWithTrue() {

		travelResponse.setMissing(true);
		assertTrue(travelResponse.isMissing());
	}

}
