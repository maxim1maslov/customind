package project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kontaktverwaltung implements IFKontakt {
	/**
	 * Container-Klasse der Objekt-Klasse Kontakt.
	 * @author Maxim
	 * @version 2.0.0
	 */
	@Override
	public boolean kontakthinzufuegen(Kontakt kontakt) {

		Persistenz p = new Persistenz();
		p.sendContact(kontakt);
		p.close();

		return true;
	}

	@Override
	public boolean kontaktloeschen(int zeile) {

		Persistenz p = new Persistenz();
		ResultSet data = p.getData("KUNDE");
		for (int i = 0; i <= zeile; i++) {
			try {
				data.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String wert = "";
		try {
			wert = data.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.delete("KONTAKT", "KUNDENNUMMER", wert);

		p.close();

		return true;
	}

	public String[][] sfgetKontakt(String[] select, String where, Object id) {

		Persistenz p = new Persistenz();
		String st = new String();
		
		for (int i = 0; i < select.length; i++) {
			if (i+1 != select.length) {
				st = st + select[i] + " , ";

			} else {
				st = st + select[i];
			}
		}

		
		String[][] data = p.fill(p.sendStatement("SELECT " + st + " FROM KONTAKT WHERE " + where + " =" + id));

		return data;

	}

	@Override
	public String[][] getKontakte(int id) {
		
		Persistenz p = new Persistenz();
		String[][] data = p.fill(p.getDataWHERE("KONTAKT", "KUNDENNUMMER", id));
		p.close();
		
		return data;

	}

	@Override
	public String[] getTableTitle() {
		
		Persistenz p = new Persistenz();
		String[] data = p.getTableTitle("KONTAKT");
		p.close();
		
		return data;
	}

	@Override
	public ResultSet getResultSet(int id) {
		
		Persistenz pe = new Persistenz();
		ResultSet res = pe.getDataWHERE("KONTAKT", "KONTAKTNUMMER", id);
		pe.close();
		
		return res;
	}
}