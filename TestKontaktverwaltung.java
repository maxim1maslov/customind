package test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project.Kontakt;
import project.Kontaktverwaltung;
import project.Kundenverwaltung;

public class TestKontaktverwaltung {

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
	public final void testKontakthinzufuegen() {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		Kontakt kontakt = new Kontakt(0, new java.sql.Date(2015, 2, 25),
				"Telefon", "Kurze Notiz", "groﬂe Beschreibung");
		assertTrue(kt.kontakthinzufuegen(kontakt));
	}

	@Test
	public final void testSfgetKontakt() {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		String[] tableTitle = { "KONTAKTNUMMER", "KONTAKTART", "DATUM",
				"KURZNOTIZ" };
		String[][] data = kt.sfgetKontakt(
				tableTitle, "KUNDENNUMMER", 0);
		
		assertEquals(data[0][1], "Telefon");
	}

	@Test
	public final void testGetKontakte() {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		String[][] data = kt.getKontakte(0);
		assertEquals(data[0][1], "0");
	}

	@Test
	public final void testGetTableTitle() {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		String[] data = kt.getTableTitle();
		assertEquals(data[0], "KONTAKTNUMMER");
	}

	@Test
	public final void testGetResultSet() throws SQLException {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		ResultSet res = kt.getResultSet(1);
		res.next();

		int t = res.getInt(1);

		int s = 1;
		assertEquals(t, s);
	}

	@Test
	public final void testKontaktloeschen() {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		assertTrue(kt.kontaktloeschen(0));
	}

}
