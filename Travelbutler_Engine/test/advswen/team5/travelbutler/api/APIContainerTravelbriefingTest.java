package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate;
import twitter4j.Status;


public class APIContainerTravelbriefingTest {

	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTravelbriefing();
	
	}

	@Test
	public void testProcessSearchForCityNotNull() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	
	@Test
	public void testProcessSearchForCountryNotNull() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	
	
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
	@Test
	public void processSearchWithBlankInputString() {
		System.out.println("Test: processSearchWithBlankInputString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNotNull(processSearch);
	}
	
	
	
	@Test
	public void testGetAdvise() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertEquals(travelAdvise.getAdvise(), "concrete advise");	
	}
	
	@Test
	public void testSetAdvise() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setAdvise("new advise");
		assertEquals(travelAdvise.getAdvise(), "new advise");	
	}
	
	@Test
	public void testGetURL() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertEquals(travelAdvise.getUrl(), "www.example.com");	
	}
	
	@Test
	public void testSetURL() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setUrl("www.example2.com");
		assertEquals(travelAdvise.getUrl(), "www.example2.com");	
	}
	
	@Test
	public void testGetSource() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		assertNull(travelAdvise.getSource());
	}
	
	@Test
	public void testSetSource() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise = new TravelbriefingAdvise("concrete advise", "www.example.com");
		travelAdvise.setSource("Source");
		assertEquals(travelAdvise.getSource(), "Source");	
	}
	
	@Test
	public void testConstructorOfTravelAdviseList() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		assertNotNull(adviseList);	
	}
	
	@Test
	public void testTravelAdviseListGetUA() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseUA = adviseList.getUA();
		assertEquals(adviseUA.getAdvise(), "concrete advise1");
	}
	
	@Test
	public void testTravelAdviseListGetUS() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseUS = adviseList.getUS();
		assertEquals(adviseUS.getAdvise(), "concrete advise2");
	}
	
	@Test
	public void testTravelAdviseListGetCA() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseCA = adviseList.getCA();
		assertEquals(adviseCA.getAdvise(), "concrete advise3");
	}
	
	@Test
	public void testTravelAdviseListSetUA() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseUA = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setUA(newTravelAdviseUA);
		TravelbriefingAdvise adviseUA = adviseList.getUA();
		assertEquals(adviseUA.getAdvise(), "concrete advise4");
	}
	
	@Test
	public void testTravelAdviseListSetCA() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseCA = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setCA(newTravelAdviseCA);
		TravelbriefingAdvise adviseCA = adviseList.getCA();
		assertEquals(adviseCA.getAdvise(), "concrete advise4");
	}
	
	@Test
	public void testTravelAdviseListSetUS() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseUS = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setUS(newTravelAdviseUS);
		TravelbriefingAdvise adviseUS = adviseList.getUS();
		assertEquals(adviseUS.getAdvise(), "concrete advise4");
	}
	
	@Test
	public void testTravelAdviseListGetAll() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList1 = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdviseList adviseList2 = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		assertEquals(adviseList1.getAll(), adviseList2.getAll());
	}
	
	@Test
	public void testGetVoltage() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertEquals("voltage1", travelElectricity.getVoltage());
	}
	
	@Test
	public void testSetVoltage() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		travelElectricity.setVoltage("voltage2");
		assertEquals("voltage2", travelElectricity.getVoltage());
	}
	
	@Test
	public void testGetFrequency() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertEquals("frequency", travelElectricity.getFrequency());
	}
	
	@Test
	public void testSetFrequency() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		travelElectricity.setFrequency("frequency2");
		assertEquals("frequency2", travelElectricity.getFrequency());
	}
	
	@Test
	public void testGetPlugs() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug1", "Plug2", "Plug3"});
	}
	
	@Test
	public void testSetPlugs() {
		System.out.println("Test: testIfTweetsContainsCountry");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		String[] plugs2 = {"Plug4", "Plug5", "Plug6"};
		travelElectricity.setPlugs(plugs2);
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug4", "Plug5", "Plug6"});
	}
	
//	@Test
//	public void testGetCompare() {
//		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("name", 1.4);
//		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("name", 1.8);
//		TravelbriefingExchangeRate[] compare = null;
//		compare[1] = exchangeRate1;
//		compare[2] = exchangeRate2;
//		TravelbriefingCurrency trCurrency = new TravelbriefingCurrency("currencyname", "currencysymbol", compare);
//	}
	

	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}


}