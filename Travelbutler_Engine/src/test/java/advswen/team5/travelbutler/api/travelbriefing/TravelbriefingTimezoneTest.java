// *************************************************************************************
// File:         [TravelbriefingTimezoneTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingTimezone
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;


public class TravelbriefingTimezoneTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#TravelbriefingTimezone(java.lang.String)}.
	 */
	@Test
	public void testTravelbriefingTimezone() {
		System.out.println("Test: testTravelbriefingTimezone");
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		assertNotNull(trTimezone);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#getName()}.
	 */
	@Test
	public void testGetName() {
		System.out.println("Test: testGetName");
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		assertEquals("timezone1", trTimezone.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		System.out.println("Test: testSetName");
		String tzName = "timezone1";				
		TravelbriefingTimezone trTimezone = new TravelbriefingTimezone(tzName);
		trTimezone.setName("new timezonename");
		assertEquals("new timezonename", trTimezone.getName());
	}

}
