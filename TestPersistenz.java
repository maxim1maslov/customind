package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project.*;

public class TestPersistenz {

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
	public final void testPersistenz() {
		
	}

	

	@Test
	public final void testSendCustomer() {
		Persistenz p = new Persistenz();

		Kunde k = new Kunde("sadkjfhsdkjfgh", "sadkjfhsdkjfgh",
				"sadkjfhsdkjfgh", "sadkjfhsdkjfgh", "sadk", "sadk",
				"sadkjfhsdkjfgh", "sadkjfhsdkjfgh", "sadkjfhsdkjfgh");
		assertTrue(p.sendCustomer(k));

		p.close();
	}

	@Test
	public final void testSendContact() {
		Persistenz p = new Persistenz();

		Kontakt kt = new Kontakt(123, new java.sql.Date(2015, 7, 25), "Mail",
				"bla", "grossbla");
		assertTrue(p.sendContact(kt));

		p.close();
	}

	@Test
	public final void testSendGroup() {
		Persistenz p = new Persistenz();

		Group g = new Group("Hi", "hinochmal");
		assertTrue(p.sendGroup(g));

		p.close();
	}

	@Test
	public final void testSendCustomerGroup() {
		Persistenz p = new Persistenz();

		assertTrue(p.sendCustomerGroup(0, 0));

		p.close();
	}

	@Test
	public final void testUpdateCustomer() {
		Persistenz p = new Persistenz();

		Kunde k = new Kunde("sadkjfhsdkjfgh", "sadkjfhsdkjfgh",
				"sadkjfhsdkjfgh", "sadkjfhsdkjfgh", "sadk", "sadk",
				"sadkjfhsdkjfgh", "sadkjfhsdkjfgh", "sadkjfhsdkjfgh");
		assertTrue(p.updateCustomer(k));

		p.close();
	}

	@Test
	public final void testCreate() {
		Persistenz p = new Persistenz();

		assertTrue(p.create());

		p.close();
	}

	@Test
	public final void testGetData() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.getData("KUNDE");
		res.next();
		
		int t = res.getInt(1);
		
		int s = 1;
		assertEquals(t, s);

		p.close();
	}

	@Test
	public final void testGetDataWHERE() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.getDataWHERE("KUNDE", "KUNDENNUMMER", 1);
		res.next();
		
		int t = res.getInt(1);
		
		int s = 1;
		assertEquals(t, s);

		p.close();
	}

	@Test
	public final void testGetDataWhereInclude() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.getDataWhereInclude("KUNDE", "VORNAME", "sadkjfhsdkjfgh");
		res.next();
		
		int t = res.getInt(1);
		
		int s = 1;
		assertEquals(t, s);

		p.close();
	}

	@Test
	public final void testGetDataWhereIncludeCast() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.getDataWhereIncludeCast("KUNDE", "KUNDENNUMMER", "1");
		res.next();
		
		int t = res.getInt(1);
		
		int s = 1;
		assertEquals(t, s);

		p.close();

	}

	@Test
	public final void testSendStatement() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.sendStatement("SELECT * FROM KUNDE");
		res.next();
		
		int t = res.getInt(1);
		
		int s = 1;
		assertEquals(t, s);

		p.close();

	}

	@Test
	public final void testClose() {
		Persistenz p = new Persistenz();

		assertTrue(p.close());

		p.close();
	}

	@Test
	public final void testShutdown() {
		Persistenz p = new Persistenz();

		assertTrue(p.shutdown());

		p.close();
	}

	@Test
	public final void testGetTableTitle() {
		Persistenz p = new Persistenz();

		String [] s = p.getTableTitle("KUNDE");
		
		
		assertEquals("VORNAME" , s[1]);

		p.close();

	}

	@Test
	public final void testFill() throws SQLException {
		Persistenz p = new Persistenz();

		ResultSet res = p.getData("KUNDE");
		res.next();
		int t = res.getInt(1) + 1;
		String[][] data = p.fill(res);
		int s = Integer.parseInt(data[0][0]);
		assertEquals(t, s);

		p.close();
	}

	@Test
	public final void testDelete() {
		Persistenz p = new Persistenz();

		// ????
		assertTrue(p.delete("KUNDE", "KUNDENNUMMER", 0));

		p.close();
	}
}
