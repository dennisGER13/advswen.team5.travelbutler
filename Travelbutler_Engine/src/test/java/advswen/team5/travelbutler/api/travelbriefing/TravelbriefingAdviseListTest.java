// *************************************************************************************
// File:         [TravelbriefingAdviseListTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/18 17:55:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingAdviseList
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TravelbriefingAdviseListTest {
	
	/**
	 * Preparation for tests: TravelbriefingAdviseList and TravelbriefingAdvises are being created with dummy-data
	 */

	private TravelbriefingAdvise travelAdviseUA;
	private TravelbriefingAdvise travelAdviseUS;
	private TravelbriefingAdvise travelAdviseCA;
	private TravelbriefingAdviseList adviseList;
	private String concAdvUA;
	private String concAdvUS;
	private String concAdvCA;
	private String urlAdvUA;
	private String urlAdvUS;
	private String urlAdvCA;

	@Before
	public void setup(){
		concAdvUA = "concrete adviseUA";
		concAdvUS = "concrete adviseUS";
		concAdvCA = "concrete adviseCA";
		urlAdvUA = "www.example.ua";
		urlAdvUS = "www.example.us";
		urlAdvCA = "www.example.ca";
		travelAdviseUA = new TravelbriefingAdvise(concAdvUA, urlAdvUA);
		travelAdviseUS = new TravelbriefingAdvise(concAdvUS, urlAdvUS);
		travelAdviseCA = new TravelbriefingAdvise(concAdvCA, urlAdvCA);
		adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
	
	}
	
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#TravelbriefingAdviseList(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The TravelbriefingAdviseList should not be null.
	 */
	@Test
	public void testTravelbriefingAdviseListShouldNotBeNull() {
		assertNotNull(adviseList);	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUA()}.
	 * The method getUA is being tested (generated dummy-data and returned value for advise should be equal).
	 */
	@Test
	public void testGetUaGetAdviseShouldBeEqualToUaConcreteAdvise() {
		assertEquals("concrete adviseUA", adviseList.getUA().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUA()}.
	 * The method getUA is being tested (generated dummy-data and returned value for URL should be equal).
	 */
	@Test
	public void testGetUaGetUrlUrlShouldBeEqualToUaUrl() {
		assertEquals("www.example.ua", adviseList.getUA().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setUA is being called and the new/changed advise should be returned.
	 */
	@Test
	public void testGetUaGetAdviseShouldBeEqualToNewConcreteAdviseAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseUA = new TravelbriefingAdvise("new concrete adviseUA", "www.new-example.ua");
		adviseList.setUA(newTravelAdviseUA);
		assertEquals("new concrete adviseUA", adviseList.getUA().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setUA is being called and the new/changed URL should be returned.
	 */
	@Test
	public void testGetUaGetAdviseShouldBeEqualToNewUrlAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseUA = new TravelbriefingAdvise("new concrete adviseUA", "www.new-example.ua");
		adviseList.setUA(newTravelAdviseUA);
		assertEquals("www.new-example.ua", adviseList.getUA().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUS()}.
	 * The method getUA is being tested (generated dummy-data and returned value for advise should be equal).
	 */
	@Test
	public void testGetUsGetAdviseShouldBeEqualToUaConcreteAdvise() {
		assertEquals("concrete adviseUS", adviseList.getUS().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUS()}.
	 * The method getUA is being tested (generated dummy-data and returned value for URL should be equal).
	 */
	@Test
	public void testGetUsGetUrlUrlShouldBeEqualToUaUrl() {
		assertEquals("www.example.us", adviseList.getUS().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUS(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setUS is being called and the new/changed advise should be returned.
	 */
	@Test
	public void testGetUsGetAdviseShouldBeEqualToNewConcreteAdviseAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseUS = new TravelbriefingAdvise("new concrete adviseUS", "www.new-example.us");
		adviseList.setUS(newTravelAdviseUS);
		assertEquals("new concrete adviseUS", adviseList.getUS().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUS(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setUS is being called and the new/changed URL should be returned.
	 */
	@Test
	public void testGetUsGetAdviseShouldBeEqualToNewUrlAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseUS = new TravelbriefingAdvise("new concrete adviseUS", "www.new-example.us");
		adviseList.setUS(newTravelAdviseUS);
		assertEquals("www.new-example.us", adviseList.getUS().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getCA()}.
	 * The method getUA is being tested (generated dummy-data and returned value for advise should be equal).
	 */
	@Test
	public void testGetCaGetAdviseShouldBeEqualToUaConcreteAdvise() {
		assertEquals("concrete adviseCA", adviseList.getCA().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getCA()}.
	 * The method getUA is being tested (generated dummy-data and returned value for URL should be equal).
	 */
	@Test
	public void testGetCaGetUrlShouldBeEqualToUaUrl() {
		assertEquals("www.example.ca", adviseList.getCA().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setCA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setCA is being called and the new/changed concrete advise should be returned.
	 */
	@Test
	public void testGetCaGetAdviseShouldBeEqualToNewConcreteAdviseAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseCA = new TravelbriefingAdvise("new concrete adviseCA", "www.new-example.ca");
		adviseList.setCA(newTravelAdviseCA);
		assertEquals("new concrete adviseCA", adviseList.getCA().getAdvise());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setCA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 * The method setCA is being called and the new/changed URL should be returned.
	 */
	@Test
	public void testGetCaGetAdviseShouldBeEqualToNewUrlAfterSetMethod() {
		TravelbriefingAdvise newTravelAdviseCA = new TravelbriefingAdvise("new concrete adviseCA", "www.new-example.ca");
		adviseList.setCA(newTravelAdviseCA);
		assertEquals("www.new-example.ca", adviseList.getCA().getUrl());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getAll()}.
	 */
	@Test
	public void testGetAll() {
		TravelbriefingAdviseList adviseList2 = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		assertEquals(adviseList.getAll(), adviseList2.getAll());
	}

}
