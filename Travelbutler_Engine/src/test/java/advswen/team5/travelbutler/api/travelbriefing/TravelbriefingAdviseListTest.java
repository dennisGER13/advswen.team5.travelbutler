// *************************************************************************************
// File:         [TravelbriefingAdviseListTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 16:39:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingAdviseList
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingAdviseListTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#TravelbriefingAdviseList(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise, advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 */
	@Test
	public void testTravelbriefingAdviseList() {
		System.out.println("Test: testTravelbriefingAdviseList");
		TravelbriefingAdvise travelAdvise1 = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdvise2 = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdvise3 = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdvise1, travelAdvise2, travelAdvise3);
		assertNotNull(adviseList);	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUA()}.
	 */
	@Test
	public void testGetUA() {
		System.out.println("Test: testGetUA");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseUA = adviseList.getUA();
		assertEquals(adviseUA.getAdvise(), "concrete advise1");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 */
	@Test
	public void testSetUA() {
		System.out.println("Test: testSetUA");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseUA = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setUA(newTravelAdviseUA);
		TravelbriefingAdvise adviseUA = adviseList.getUA();
		assertEquals(adviseUA.getAdvise(), "concrete advise4");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getUS()}.
	 */
	@Test
	public void testGetUS() {
		System.out.println("Test: testGetUS");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseUS = adviseList.getUS();
		assertEquals(adviseUS.getAdvise(), "concrete advise2");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setUS(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 */
	@Test
	public void testSetUS() {
		System.out.println("Test: testSetUS");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseUS = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setUS(newTravelAdviseUS);
		TravelbriefingAdvise adviseUS = adviseList.getUS();
		assertEquals(adviseUS.getAdvise(), "concrete advise4");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getCA()}.
	 */
	@Test
	public void testGetCA() {
		System.out.println("Test: testGetCA");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise adviseCA = adviseList.getCA();
		assertEquals(adviseCA.getAdvise(), "concrete advise3");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#setCA(advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise)}.
	 */
	@Test
	public void testSetCA() {
		System.out.println("Test: testSetCA");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdvise newTravelAdviseCA = new TravelbriefingAdvise("concrete advise4", "www.example.com4");
		adviseList.setCA(newTravelAdviseCA);
		TravelbriefingAdvise adviseCA = adviseList.getCA();
		assertEquals(adviseCA.getAdvise(), "concrete advise4");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList#getAll()}.
	 */
	@Test
	public void testGetAll() {
		System.out.println("Test: testGetAll");
		TravelbriefingAdvise travelAdviseUA = new TravelbriefingAdvise("concrete advise1", "www.example.com1");
		TravelbriefingAdvise travelAdviseUS = new TravelbriefingAdvise("concrete advise2", "www.example.com2");
		TravelbriefingAdvise travelAdviseCA = new TravelbriefingAdvise("concrete advise3", "www.example.com3");
		TravelbriefingAdviseList adviseList1 = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		TravelbriefingAdviseList adviseList2 = new TravelbriefingAdviseList(travelAdviseUA, travelAdviseUS, travelAdviseCA);
		assertEquals(adviseList1.getAll(), adviseList2.getAll());
	}

}
