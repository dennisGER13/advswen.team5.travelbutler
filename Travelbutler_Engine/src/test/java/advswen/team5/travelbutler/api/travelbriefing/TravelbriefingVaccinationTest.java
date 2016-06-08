// *************************************************************************************
// File:         [TravelbriefingVaccinationTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingVaccination
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingVaccinationTest {

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#TravelbriefingVaccination(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testTravelbriefingVaccination() {
		System.out.println("Test: testTravelbriefingVaccination");
		String name = "Vaccination-Name";				
		String message = "Vaccination-Message";
		TravelbriefingVaccination trVaccination = new TravelbriefingVaccination(name, message);
		assertNotNull(trVaccination);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#getName()}.
	 */
	@Test
	public void testGetName() {
		System.out.println("Test: testGetName");
		String name = "Vaccination-Name";				
		String message = "Vaccination-Message";
		TravelbriefingVaccination trVaccination = new TravelbriefingVaccination(name, message);
		assertEquals("Vaccination-Name", trVaccination.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		System.out.println("Test: testSetName");
		String name = "Vaccination-Name";				
		String message = "Vaccination-Message";
		TravelbriefingVaccination trVaccination = new TravelbriefingVaccination(name, message);
		trVaccination.setName("new name");
		assertEquals("new name", trVaccination.getName());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		System.out.println("Test: testGetMessage");
		String name = "Vaccination-Name";				
		String message = "Vaccination-Message";
		TravelbriefingVaccination trVaccination = new TravelbriefingVaccination(name, message);
		assertEquals("Vaccination-Message", trVaccination.getMessage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingVaccination#setMessage(java.lang.String)}.
	 */
	@Test
	public void testSetMessage() {
		System.out.println("Test: testSetName");
		String name = "Vaccination-Name";				
		String message = "Vaccination-Message";
		TravelbriefingVaccination trVaccination = new TravelbriefingVaccination(name, message);
		trVaccination.setMessage("new message");
		assertEquals("new message", trVaccination.getMessage());
	}

}
