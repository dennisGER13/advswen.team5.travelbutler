// *************************************************************************************
// File:         [TravelbriefingTimezoneTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/23 14:55:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingTimezone
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TravelbriefingTimezoneTest {
	
	private String tzName;
	private TravelbriefingTimezone trTimezone;

	/**
	 * Preparation for tests: TravelbriefingTimezone is being created with dummy-data
	 */
	@Before
	public void setup(){
		tzName = "timezone1";				
		trTimezone = new TravelbriefingTimezone(tzName);
	
		
	}


	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#TravelbriefingTimezone(java.lang.String)}.
	 * TravelbriefingTimezone should not be null.
	 */
	@Test
	public void testTravelbriefingTimezoneShouldNotBeNull() {
	assertNotNull(trTimezone);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#getName()}.
	 * The method getName is being tested (generated dummy-data and returned values for name should be equal).
	 */
	@Test
	public void testGetNameShouldBeEqualToName() {
		assertEquals("timezone1", trTimezone.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTimezone#setName(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetNameShouldBeEqualToNewName() {
		trTimezone.setName("new timezonename");
		assertEquals("new timezonename", trTimezone.getName());
	}

}
