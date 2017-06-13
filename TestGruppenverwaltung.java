package test;

import static org.junit.Assert.*;

import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project.Group;
import project.Gruppenverwaltung;

public class TestGruppenverwaltung {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGruppehinzufuegen() {
		Gruppenverwaltung g = new Gruppenverwaltung();
		Group gruppe = new Group("Bezeichnung", "Beschreibung");
		assertTrue(g.gruppehinzufuegen(gruppe));		
	}

	@Test
	public final void testGetGruppen() {
		Gruppenverwaltung g = new Gruppenverwaltung();
		String[][] data = g.getGruppen();
		assertEquals(data[0][0], "1");
	}

	@Test
	public final void testGetTableTitle() {
		Gruppenverwaltung g = new Gruppenverwaltung();
		String[] data = g.getTableTitle();
		assertEquals(data[0], "GRUPPENNUMMER");
	}

	@Test
	public final void testGruppeloeschen() {
		Gruppenverwaltung g = new Gruppenverwaltung();
		assertTrue(g.gruppeloeschen(0));
		
	}

}
