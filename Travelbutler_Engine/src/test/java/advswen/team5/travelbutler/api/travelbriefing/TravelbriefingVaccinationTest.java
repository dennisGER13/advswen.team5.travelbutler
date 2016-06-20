// *************************************************************************************
// File:         [TravelbriefingVaccinationTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/20 11:49:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingVaccination
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingVaccinationTest {
	
	private String name;
	private String message;
	private TravelbriefingVaccination trVaccination;

	/**
	 * Preparation for tests: TravelbriefingVaccination is being created with dummy-data
	 */
	@Before
	public void setup(){
		name = "Vaccination-Name";				
		message = "Vaccination-Message";
		trVaccination = new TravelbriefingVaccination(name, message);
	
		
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#TravelbriefingVaccination(java.lang.String, java.lang.String)}.
	 * TravelbriefingVaccination should not be null.
	 */
	@Test
	public void testTravelbriefingVaccinationShouldNotBeNull() {
	assertNotNull(trVaccination);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#getName()}.
	 * The method getName is being tested (generated dummy-data and returned values for name should be equal).
	 */
	@Test
	public void testGetNameShouldBeEqualToName() {
	assertEquals("Vaccination-Name", trVaccination.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#setName(java.lang.String)}.
	 * The method setName is being called and the new/changed name should be returned.
	 */
	@Test
	public void testGetNameShouldBeEqualToNewName() {
		trVaccination.setName("new name");
		assertEquals("new name", trVaccination.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#getMessage()}.
	 * The method getMessage is being tested (generated dummy-data and returned values for name should be equal).
	 */
	@Test
	public void testGetMessageShouldBeEqualToMessage() {
		assertEquals("Vaccination-Message", trVaccination.getMessage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#setMessage(java.lang.String)}.
	 * The method setMessage is being called and the new/changed message should be returned.
	 */
	@Test
	public void testGetMessageShouldBeEqualToNewMessage() {
	trVaccination.setMessage("new message");
		assertEquals("new message", trVaccination.getMessage());
	}

}
