// *************************************************************************************
// File:         [TravelbriefingElectricityTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/20 10:12:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingElectricity
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravelbriefingElectricityTest {
	
	private String[] plugs;
	private TravelbriefingElectricity travelElectricity;

	/**
	 * Preparation for tests: TravelbriefingElectricity is being created with dummy-data
	 */
	
	@Before
	public void setup(){
		plugs = new String[] {"Plug1", "Plug2", "Plug3"};
		travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#TravelbriefingElectricity(java.lang.String, java.lang.String, java.lang.String[])}.
	 * TravelbriefingElectricity should not be null
	 */	
	@Test
	public void testTravelbriefingElectricityShouldNotBeNull() {
		assertNotNull(travelElectricity);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#getVoltage()}.
	 * The method getVoltage is being tested (generated dummy-data and returned value for voltage should be equal).
	 */
	@Test
	public void testGetVoltageShouldBeEqualToVoltage() {
		assertEquals("voltage1", travelElectricity.getVoltage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#setVoltage(java.lang.String)}.
	 * The method setVoltage is being called and the new/changed voltage should be returned.
	 */	
	@Test
	public void testGetVoltageShouldBeEqualToNewVoltage() {
		travelElectricity.setVoltage("voltage2");
		assertEquals("voltage2", travelElectricity.getVoltage());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#getFrequency()}.
	 * The method getFrequency is being tested (generated dummy-data and returned value for frequency should be equal).
	 */
	@Test
	public void testGetFrequencyShouldBeEqualToFrequency() {
		assertEquals("frequency", travelElectricity.getFrequency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#setFrequency(java.lang.String)}.
	 * The method setFrequency is being called and the new/changed frequency should be returned.
	 */
	@Test
	public void testGetFrequencyShouldBeEqualToNewFrequency() {
		travelElectricity.setFrequency("frequency2");
		assertEquals("frequency2", travelElectricity.getFrequency());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#getPlugs()}.
	 * The method getPlugs is being tested (generated dummy-data and returned values for plugs should be equal).
	 */
	@Test
	public void testGetPlugsShouldBeEqualToPlugs() {
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug1", "Plug2", "Plug3"});
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.travelbriefing.TravelbriefingElectricity#setPlugs(java.lang.String[])}.
	 * The method setPlugs is being called and the new/changed plugs should be returned.
	 */
	@Test
	public void testGetPlugsShouldBeEqualToNewPlugs() {
		String[] plugs2 = {"Plug4", "Plug5", "Plug6"};
		travelElectricity.setPlugs(plugs2);
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug4", "Plug5", "Plug6"});
	}

}
