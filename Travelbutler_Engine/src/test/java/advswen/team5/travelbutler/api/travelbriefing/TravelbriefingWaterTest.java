// *************************************************************************************
// File:         [TravelbriefingWaterTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/20 11:54:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingWater
//				
//**************************************************************************************

package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingWaterTest {
	
	private String shortDescription;
	private TravelbriefingWater trWater;

	/**
	 * Preparation for tests: TravelbriefingVaccination is being created with dummy-data
	 */
	@Before
	public void setup(){
		shortDescription = "description";				
		trWater = new TravelbriefingWater(shortDescription);
		
		
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#TravelbriefingWater(java.lang.String)}.
	 * TravelbriefingWater should not be null.
	 */
	@Test
	public void testTravelbriefingWaterShouldNotBeNull() {
		assertNotNull(trWater);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#getShortDescription()}.
	 * The method getShortDescription is being tested (generated dummy-data and returned values for shortDescription should be equal).
	 */
	@Test
	public void testGetShortDescriptionShouldBeEqualToShortDescription() {
		assertEquals("description", trWater.getShortDescription());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingWater#setShortDescription(java.lang.String)}.
	 * The method setShortDescription is being called and the new/changed setShortDescription should be returned.
	 */
	@Test
	public void testGetShortDescriptionShouldBeEqualToNewShortDescription() {
		trWater.setShortDescription("new short description");
		assertEquals("new short description", trWater.getShortDescription());
	}

}
