package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Gruppenverwaltung implements IFGruppe {
	/**
	 * Container-Klasse der Objekt-Klasse Gruppe
	 * @author Maxim
	 * @version 2.0.0
	 */
	@Override
	public boolean gruppehinzufuegen(Group gruppe) {

		Persistenz p = new Persistenz();
		p.sendGroup(gruppe);
		p.close();

		return true;

	}

	@Override
	public String[][] getGruppen() {

		Persistenz p = new Persistenz();
		String[][] data = p.fill(p.getData("GRUPPE"));
		p.close();

		return data;
	}

	@Override
	public String[] getTableTitle() {

		Persistenz p = new Persistenz();
		String[] data = p.getTableTitle("GRUPPE");
		p.close();

		return data;
	}

	@Override
	public boolean gruppeloeschen(int zeile) {

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
		p.delete("GRUPPEKUNDE", "KUNDENNUMMER", wert);
		p.close();

		return true;
	}

	public String[][] sfgetGruppe(String[] select, String[] from, String where,
			Object id) {

		Persistenz p = new Persistenz();
		String st = new String();
		String fr = new String();
		for (int i = 0; i < select.length; i++) {
			if (i+1 != select.length) {
				st = st + select[i] + " , ";

			} else {
				st = st + select[i];
			}
		}

		for (int i = 0; i < from.length; i++) {
			if (i+1 != from.length) {
				fr = fr + from[i] + " , ";

			} else {
				fr = fr + from[i];
			}

		}
		String[][] data = p.fill(p.sendStatement("SELECT " + st + " FROM " + fr
				+ " WHERE " + where + " =" + id));
		p.close();
		
		return data;
	}

}
