package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Persistenz implements IFPersistenz {
	/**
	 * Diese Klasse stellt alle Datenbankoperationen zur Verfügung
	 * @author Yannik
	 * @version 2.0.0
	 */
	Connection c;

	public Persistenz() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			String s = System.getProperty("user.name");
			this.c = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/"
					+ s + "/Documents/mydb.db;shutdown=true", "SA", "");
			c.setAutoCommit(true);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public boolean sendCustomer(Kunde Customer) {
		try {
			PreparedStatement St = c
					.prepareStatement("INSERT INTO KUNDE (VORNAME, NAME, ADRESSE, HAUSNUMMER, ORT, PLZ, MAILADRESSE, GEBURTSDATUM, TELEFON) VALUES ("
							+ "'"
							+ Customer.getVorname()
							+ "',"
							+ "'"
							+ Customer.getName()
							+ "','"
							+ Customer.getAdresse()
							+ "', '"
							+ Customer.getHausnummer()
							+ "','"
							+ Customer.getOrt()
							+ "', '"
							+ Customer.getPlz()
							+ "','"
							+ Customer.getMailadresse()
							+ "','"
							+ Customer.getGeburtsdatum()
							+ "','"
							+ Customer.getTelefon() + "')");
			St.execute();
			St.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally  {
			
		}
		return false;
	}

	public boolean sendContact(Kontakt contact) {
		try {
			PreparedStatement St = c
					.prepareStatement("INSERT INTO KONTAKT (KUNDENNUMMER, DATUM, KONTAKTART, KURZNOTIZ, BESCHREIBUNG) VALUES ("
							+ "'"
							+ contact.getKundennummer()
							+ "',"
							+ "'"
							+ contact.getDatum().toString()
							+ "','"
							+ contact.getKontaktart()
							+ "', '"
							+ contact.getKurznotiz()
							+ "','"
							+ contact.getBeschreibung() + "')");
			St.execute();
			St.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean sendGroup(Group Gruppe) {
		try {
			PreparedStatement St = c
					.prepareStatement("INSERT INTO Gruppe (BEZEICHNUNG, BESCHREIBUNG) VALUES ("
							+ "'"
							+ Gruppe.getBezeichnung()
							+ "', '"
							+ Gruppe.getBeschreibung() + "')");
			St.execute();
			St.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean sendCustomerGroup(int Kundennummer, int Gruppennummer) {
		try {
			PreparedStatement St = c
					.prepareStatement("INSERT INTO GRUPPEKUNDE (KUNDENNUMMER, GRUPPENNUMMER) VALUES ("
							+ "'"
							+ Kundennummer
							+ "', '"
							+ Gruppennummer
							+ "')");
			St.execute();
			St.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateCustomer(Kunde Customer) {
		try {

			PreparedStatement St = c

			.prepareStatement("UPDATE KUNDE SET"

			+ " VORNAME ='" + Customer.getVorname() + "' , NAME ='"
					+ Customer.getName() + "' , ADRESSE ='"
					+ Customer.getAdresse() + "' , HAUSNUMMER ='"
					+ Customer.getHausnummer() + "' , ORT ='"
					+ Customer.getOrt() + "' , PLZ ='" + Customer.getPlz()
					+ "' , MAILADRESSE ='" + Customer.getMailadresse()
					+ "' , GEBURTSDATUM ='" + Customer.getGeburtsdatum()
					+ "' , TELEFON ='" + Customer.getTelefon()
					+ "' WHERE KUNDENNUMMER ='" + Customer.getKundennummer()
					+ "'");
			St.execute();
			St.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean create() {

		String crt = "CREATE TABLE IF NOT EXISTS KUNDE(KUNDENNUMMER IDENTITY, "
				+ "VORNAME VARCHAR (50) NOT NULL, "
				+ "NAME VARCHAR (50) NOT NULL, "
				+ "ADRESSE VARCHAR (50) NOT NULL, "
				+ "HAUSNUMMER VARCHAR (50) NOT NULL,	"
				+ "ORT VARCHAR (50) NOT NULL, " + "PLZ VARCHAR (10) NOT NULL,	"
				+ "MAILADRESSE VARCHAR (50) NOT NULL, "
				+ "GEBURTSDATUM VARCHAR (50) NOT NULL, " + "TELEFON VARCHAR (50) NOT NULL)";

		String crt2 = "CREATE TABLE IF NOT EXISTS KONTAKT(KONTAKTNUMMER IDENTITY, "
				+ "KUNDENNUMMER INTEGER NOT NULL, "
				+ "DATUM DATE NOT NULL, "
				+ "KONTAKTART VARCHAR (50) NOT NULL, "
				+ "KURZNOTIZ VARCHAR (50) NOT NULL,	"
				+ "BESCHREIBUNG LONGVARCHAR NOT NULL)";

		String crt3 = "CREATE TABLE IF NOT EXISTS GRUPPE(GRUPPENNUMMER IDENTITY, "
				+ "BEZEICHNUNG VARCHAR (50) NOT NULL, "
				+ "BESCHREIBUNG VARCHAR (50) NOT NULL)";

		String crt4 = "CREATE TABLE IF NOT EXISTS GRUPPEKUNDE(ZUORDNUNGSNUMMERKG IDENTITY, "
				+ "KUNDENNUMMER INTEGER NOT NULL, "
				+ "GRUPPENNUMMER INTEGER NOT NULL)";

		Statement stmt;
		Statement stmt2;
		Statement stmt3;
		Statement stmt4;
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(crt);
			stmt.close();

			stmt2 = c.createStatement();
			stmt2.executeUpdate(crt2);
			stmt2.close();

			stmt3 = c.createStatement();
			stmt3.executeUpdate(crt3);
			stmt3.close();

			stmt4 = c.createStatement();
			stmt4.executeUpdate(crt4);
			stmt4.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;

	}

	public boolean delete(String Tabelle, String spalte, Object wert) {
		try {
			PreparedStatement St = c.prepareStatement("DELETE FROM " + Tabelle
					+ " WHERE " + spalte + "=" + "'" + wert.toString() + "'");
			St.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet getData(String Klasse) {
		ResultSet rs = null;
		Statement St;

		try {
			St = c.createStatement();
			rs = St.executeQuery("SELECT * FROM " + Klasse);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rs;
	}

	public ResultSet getDataWHERE(String Klasse, String Spalte, Object Bedingung) {
		ResultSet rs = null;
		Statement St;

		try {
			St = c.createStatement();
			rs = St.executeQuery("SELECT * FROM " + Klasse + " WHERE " + Spalte
					+ " ='" + Bedingung.toString() + "'");
			St.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rs;
	}

	public ResultSet getDataWhereInclude(String Klasse, String Spalte,
			Object Bedingung) {
		ResultSet rs = null;
		Statement St;

		try {
			St = c.createStatement();
			rs = St.executeQuery("SELECT * FROM " + Klasse + " WHERE UPPER("
					+ Spalte + ") LIKE UPPER('%" + Bedingung.toString() + "%')");
			St.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rs;
	}

	public ResultSet getDataWhereIncludeCast(String Klasse, String Spalte,
			Object Bedingung) {
		ResultSet rs = null;
		Statement St;

		try {
			St = c.createStatement();
			String strg = "SELECT * FROM " + Klasse + " WHERE UPPER(CAST("
					+ Spalte + " AS LONGVARCHAR)) LIKE UPPER('%" + Bedingung
					+ "%')";
			System.out.println(strg);
			rs = St.executeQuery(strg);
			St.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rs;
	}

	public ResultSet sendStatement(String sql) {
		ResultSet rs = null;
		Statement St;

		try {
			St = c.createStatement();
			rs = St.executeQuery(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rs;
	}

	public boolean close() {
		try {
			this.c.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean shutdown() {
		try {
			c.prepareStatement("SHUTDOWN").execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public String[] getTableTitle(String TableName) {

		try {
			ResultSetMetaData rsmd = getData(TableName).getMetaData();
			String[] title = new String[rsmd.getColumnCount()];
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				title[i - 1] = rsmd.getColumnName(i);

			}

			return title;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return null;
	}

	public String[][] fill(ResultSet rs) {

		String[][] rowData = null;
		try {

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			ArrayList<String[]> rows = new ArrayList();
			while (rs.next()) {
				String[] row = new String[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					row[i - 1] = rs.getString(i);
				}
				rows.add(row);

				rowData = (String[][]) rows
						.toArray(new String[rows.size()][columnCount]);

			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return rowData;
	}
}
