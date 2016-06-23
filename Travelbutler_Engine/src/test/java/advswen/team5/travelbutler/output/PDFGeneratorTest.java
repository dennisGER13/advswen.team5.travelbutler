// *************************************************************************************
// File:         [PDFGeneratorTest.java]
// Created:      [2016/06/23 Thursday]
// Last Changed: $Date: 2016/06/23 14:50:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für PDFGenerator
//				
//**************************************************************************************
package advswen.team5.travelbutler.output;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.TravelbriefingResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingCurrency;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingExchangeRate;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingLanguage;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater;


public class PDFGeneratorTest {
	
	private WikipediaResponse wikiResponse;
	private String pageid;
	private String title;
	private String extract;
	
	private TravelbriefingResponse travelResponse;
	private TravelbriefingAdviseList adviseList;
	private TravelbriefingCurrency trCurrency;
	private TravelbriefingElectricity travelElectricity;
	private TravelbriefingLanguage[] trLanguageArray;
	private TravelbriefingTimezone trTimezone;
	private TravelbriefingVaccination[] trVaccinationArray;
	private TravelbriefingWater trWater;
	
	private Response response;
	
	
	
	/**
	 * Preparation for tests: WikipediaResponse and TravelbriefingResponse are being created with dummy-data.
	 */
	@Before
	public void setup(){
		//Create WikipediaResponse
		pageid = "12";
		title = "title";
		extract = "This is an extract. It's generated for test-purposes";
		wikiResponse = new WikipediaResponse(pageid, title, extract);
		
		//Create TravelbriefingResponse
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		TravelbriefingExchangeRate exchangeRate1 = new TravelbriefingExchangeRate("Euro", 1);
		TravelbriefingExchangeRate exchangeRate2 = new TravelbriefingExchangeRate("Yen", 3);
		TravelbriefingExchangeRate[] exchangeRateArray = {exchangeRate1, exchangeRate2};
		trCurrency = new TravelbriefingCurrency("Euro", "currencysymbol", exchangeRateArray);
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		TravelbriefingLanguage trLanguage1 = new TravelbriefingLanguage("English", "German" );
		TravelbriefingLanguage trLanguage2 = new TravelbriefingLanguage("Spanish", "German" );
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
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * @throws Exception 
	 * The generated PDF should not be null.
	 */
	@Test
	public void testPDFShouldNotBeNullWithDummyDataAndThrowsException() throws Exception {
		response = new Response("Test-Destination1");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = new PDFGenerator(response).generate();
		assertNotNull(testpdf);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should not be null.
	 */
	@Test
	public void testPDFShouldNotBeNullWithDummyDataAndTryCatchBlock() {
		response = new Response("Test-Destination2");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(testpdf);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should be readable.
	 */
	@Test
	public void testPDFShouldBeReadable() {
		response = new Response("Test-Destination3");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(testpdf.canRead());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should be not be a directory
	 */
	@Test
	public void testPDFShouldNotBeADirectory() {
		response = new Response("Test-Destination4");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(testpdf.isFile() && !testpdf.isDirectory());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should have the name of the destination (provided as String to Response, in this case "Test-Destination5") 
	 * plus ".pdf" as file-extension.
	 */
	@Test
	public void testPDFNameShouldBeEqualToDestination() {
		response = new Response("Test-Destination5");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Test-Destination5.pdf", testpdf.getName());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should exist
	 */
	@Test
	public void testPDFNameShouldExist() {
		response = new Response("Test-Destination6");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(testpdf.exists());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.output.PDFGenerator#generate()}.
	 * The generated PDF should be in folder "output" and have the name of the destination (provided as String to Response, in this case "Test-Destination7") plus ".pdf" as file-extension.
	 */
	@Test
	public void testPDFShouldHaveCorrectNameAndBeInOutputFolder() {
		response = new Response("Test-Destination7");
		response.setWikipediaResponse(wikiResponse);
		response.setTravelbriefingResponse(travelResponse);
		File testpdf = null;
		try {
			testpdf = new PDFGenerator(response).generate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("output\\Test-Destination7.pdf", testpdf.getPath());
	}
}
