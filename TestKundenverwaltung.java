package test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project.Gruppenverwaltung;
import project.Kontakt;
import project.Kontaktverwaltung;
import project.Kunde;
import project.Kundenverwaltung;

public class TestKundenverwaltung {

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
	public final void testKundehinzufuegen() {
		Kundenverwaltung k = new Kundenverwaltung();
		Kunde kunde = new Kunde("Maxim", "Maslov", "Pablo-Picasso", "5",
				"Berlin", "13057", "web@web.de", "14.09.1995", "03075923688");
		assertTrue(k.kundehinzufuegen(kunde));
	}

	@Test
	public final void testLangenichtkontaktiert() {
		Kundenverwaltung k = new Kundenverwaltung();
		Kontaktverwaltung kt = new Kontaktverwaltung();
		Kontakt kontakt = new Kontakt(0, new java.sql.Date(2015, 2, 25), "Telefon", "Kurze Notiz", "groﬂe Beschreibung");
		kt.kontakthinzufuegen(kontakt);
		String[][] data = k.langenichtkontaktiert();
		if (data == null) {
			assertNull(data);
		} else {
			assertEquals(data[0][0], "0");
		}
	}

	@Test
	public final void testKundezugruppehinzufuegen() {
		Kundenverwaltung k = new Kundenverwaltung();
		Gruppenverwaltung g = new Gruppenverwaltung();
		DefaultTableModel test = new DefaultTableModel(g.getGruppen(),
				g.getTableTitle()) {
			public Class<?> getColumnClass(int colIndex) {
				if (colIndex == 3) {
					return Boolean.class;
				} else {
					return Object.class;
				}

			}
		};
		test.addColumn("");
		JTable table = new JTable(test);
		table.setAutoCreateRowSorter(true);
		assertTrue(k.kundezugruppehinzufuegen(table));
	}

	@Test
	public final void testGetTableTitle() {
		Kundenverwaltung k = new Kundenverwaltung();
		String[] data = k.getTableTitle();
		assertEquals(data[0], "KUNDENNUMMER");
	}

	@Test
	public final void testGetKundenStringString() {
		Kundenverwaltung k = new Kundenverwaltung();
		String[][] data = k.getKunden("VORNAME", "MAXIM");
		assertEquals(data[0][1], "Maxim");
	}

	@Test
	public final void testGetKunden() {
		Kundenverwaltung k = new Kundenverwaltung();
		String[][] data = k.getKunden();
		assertEquals(data[0][0], "0");
	}

	@Test
	public final void testGetResultSet() throws SQLException {
		Kundenverwaltung k = new Kundenverwaltung();
		ResultSet res = k.getResultSet(0);
		res.next();
		
		int t = res.getInt(1);
		
		int s = 0;
		assertEquals(t, s);
	}

	@Test
	public final void testKundeaendern() {
		Kundenverwaltung k = new Kundenverwaltung();
		Kunde kunde = new Kunde("Yannik", "Poetsch", "Wendelschloﬂ", "¥29",
				"Berlin", "13591", "yannik@web.de", "02.08.1996", "03075923688");
		assertTrue(k.kundehinzufuegen(kunde));
	}

	@Test
	public final void testKundeloeschen() {
		Kundenverwaltung k = new Kundenverwaltung();
		assertTrue(k.kundeloeschen(1));
	}

}
