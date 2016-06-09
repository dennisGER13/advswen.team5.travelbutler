// *************************************************************************************
// File:         [TravelbriefingResponseTest.java]
// Created:      [2016/06/09 Thursday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingResponse
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.response;

import static org.junit.Assert.*;

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

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#TravelbriefingResponse(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage[], advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination[], advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater)}.
	 */
	@Test
	public void testTravelbriefingResponse() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertNotNull(travelResponse);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getAdvise()}.
	 */
	@Test
	public void testGetAdvise() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertEquals(adviseList, travelResponse.getAdvise());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setAdvise(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList)}.
	 */
	@Test
	public void testSetAdvise() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingAdvise travelAdvise4 = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		TravelbriefingAdvise travelAdvise5 = new TravelbriefingAdvise("concrete advise5", "www.example.com5");
		TravelbriefingAdvise travelAdvise6 = new TravelbriefingAdvise("concrete advise6", "www.example.com6");
		TravelbriefingAdviseList adviseList2 = new TravelbriefingAdviseList(travelAdvise4, travelAdvise5, travelAdvise6);
		travelResponse.setAdvise(adviseList2);
		assertEquals(adviseList2, travelResponse.getAdvise());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getCurrency()}.
	 */
	@Test
	public void testGetCurrency() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertEquals(trCurrency, travelResponse.getCurrency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setCurrency(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency)}.
	 */
	@Test
	public void testSetCurrency() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingExchangeRate exchangeRate3 = new TravelbriefingExchangeRate("name3", 1);
		TravelbriefingExchangeRate exchangeRate4 = new TravelbriefingExchangeRate("name4", 3);
		TravelbriefingExchangeRate[] exchangeRateArray2 = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency2 = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		travelResponse.setCurrency(trCurrency2);
		assertEquals(trCurrency2, travelResponse.getCurrency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getElectricity()}.
	 */
	@Test
	public void testGetElectricity() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertEquals(travelElectricity, travelResponse.getElectricity());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setElectricity(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity)}.
	 */
	@Test
	public void testSetElectricity() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		String[] plugs2 = {"Plug4", "Plug5", "Plug6"};
		TravelbriefingElectricity travelElectricity2 = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		travelResponse.setElectricity(travelElectricity2);
		assertEquals(travelElectricity2, travelResponse.getElectricity());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getLanguage()}.
	 */
	@Test
	public void testGetLanguage() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertArrayEquals(trLanguageArray, travelResponse.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setLanguage(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage[])}.
	 */
	@Test
	public void testSetLanguage() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingLanguage trLanguage3 = new TravelbriefingLanguage("German", "French" );
		TravelbriefingLanguage trLanguage4 = new TravelbriefingLanguage("Chinese", "French" );
		TravelbriefingLanguage[] trLanguageArray2 = { trLanguage1, trLanguage2};
		travelResponse.setLanguage(trLanguageArray2);
		assertArrayEquals(trLanguageArray2, travelResponse.getLanguage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getTimezone()}.
	 */
	@Test
	public void testGetTimezone() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertEquals(trTimezone, travelResponse.getTimezone());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setTimezone(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone)}.
	 */
	@Test
	public void testSetTimezone() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingTimezone trTimezone2 = new TravelbriefingTimezone("timezone2");
		travelResponse.setTimezone(trTimezone2);
		assertEquals(trTimezone2, travelResponse.getTimezone());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getVaccinations()}.
	 */
	@Test
	public void testGetVaccinations() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertArrayEquals(trVaccinationArray, travelResponse.getVaccinations());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setVaccinations(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination[])}.
	 */
	@Test
	public void testSetVaccinations() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingVaccination trVaccination3 = new TravelbriefingVaccination("Vaccination-Name3", "Vaccination-Message3");
		TravelbriefingVaccination trVaccination4 = new TravelbriefingVaccination("Vaccination-Name4", "Vaccination-Message4");
		TravelbriefingVaccination[] trVaccinationArray2 = {trVaccination3, trVaccination4};
		travelResponse.setVaccinations(trVaccinationArray2);
		assertArrayEquals(trVaccinationArray2, travelResponse.getVaccinations());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#getWater()}.
	 */
	@Test
	public void testGetWater() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertEquals(trWater, travelResponse.getWater());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setWater(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater)}.
	 */
	@Test
	public void testSetWater() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone("timezone1");
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		TravelbriefingWater trWater = new TravelbriefingWater("description");
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		TravelbriefingWater trWater2 = new TravelbriefingWater("description2");
		travelResponse.setWater(trWater2);
		assertEquals(trWater2, travelResponse.getWater());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#isMissing()}.
	 */
	@Test
	public void testIsMissing() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		assertFalse(travelResponse.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TravelbriefingResponse#setMissing(boolean)}.
	 */
	@Test
	public void testSetMissing() {
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name1", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name2", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "French" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "French" );
		TravelbriefingLanguage[] trLanguageArray = { trLanguage1, trLanguage2};
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		TravelbriefingVaccination trVaccination1 = new TravelbriefingVaccination("Vaccination-Name", "Vaccination-Message");
		TravelbriefingVaccination trVaccination2 = new TravelbriefingVaccination("Vaccination-Name2", "Vaccination-Message2");
		TravelbriefingVaccination[] trVaccinationArray = {trVaccination1, trVaccination2};
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		TravelbriefingResponse travelResponse = new TravelbriefingResponse(adviseList, trCurrency, travelElectricity, trLanguageArray, trTimezone, trVaccinationArray, trWater);
		travelResponse.setMissing(true);
		assertTrue(travelResponse.isMissing());
	}

}
