// *************************************************************************************
// File:         [TravelbriefingElectricityTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TravelbriefingElectricity
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravelbriefingElectricityTest {

	@Test
	public void testTravelbriefingElectricity() {
		System.out.println("Test: testTravelbriefingElectricity");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertNotNull(travelElectricity);
	}

	@Test
	public void testGetVoltage() {
		System.out.println("Test: testGetVoltage");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertEquals("voltage1", travelElectricity.getVoltage());
	}

	@Test
	public void testSetVoltage() {
		System.out.println("Test: testSetVoltage");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		travelElectricity.setVoltage("voltage2");
		assertEquals("voltage2", travelElectricity.getVoltage());
	}

	@Test
	public void testGetFrequency() {
		System.out.println("Test: testGetFrequency");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertEquals("frequency", travelElectricity.getFrequency());
	}

	@Test
	public void testSetFrequency() {
		System.out.println("Test: testSetFrequency");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		travelElectricity.setFrequency("frequency2");
		assertEquals("frequency2", travelElectricity.getFrequency());
	}

	@Test
	public void testGetPlugs() {
		System.out.println("Test: testGetPlugs");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug1", "Plug2", "Plug3"});
	}

	@Test
	public void testSetPlugs() {
		System.out.println("Test: testSetPlugs");
		String[] plugs = {"Plug1", "Plug2", "Plug3"};
		TravelbriefingElectricity travelElectricity = new TravelbriefingElectricity("voltage1", "frequency", plugs);
		String[] plugs2 = {"Plug4", "Plug5", "Plug6"};
		travelElectricity.setPlugs(plugs2);
		assertArrayEquals(travelElectricity.getPlugs(), new String[]{"Plug4", "Plug5", "Plug6"});
	}

}
