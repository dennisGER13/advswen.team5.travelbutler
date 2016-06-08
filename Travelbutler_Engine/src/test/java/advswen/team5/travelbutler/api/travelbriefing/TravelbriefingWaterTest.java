// *************************************************************************************
// File:         [TravelbriefingWaterTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingWater
//				
//**************************************************************************************

package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingWaterTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#TravelbriefingWater(java.lang.String)}.
	 */
	@Test
	public void testTravelbriefingWater() {
		System.out.println("Test: testTravelbriefingWater");
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		assertNotNull(trWater);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		System.out.println("Test: testTravelbriefingWater");
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		assertEquals("description", trWater.getShortDescription());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#setShortDescription(java.lang.String)}.
	 */
	@Test
	public void testSetShortDescription() {
		System.out.println("Test: testTravelbriefingWater");
		String shortDescription = "description";				
		TravelbriefingWater trWater = new TravelbriefingWater(shortDescription);
		trWater.setShortDescription("new description");
		assertEquals("new description", trWater.getShortDescription());
	}

}
