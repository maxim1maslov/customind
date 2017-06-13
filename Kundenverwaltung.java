package project;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

public class Kundenverwaltung implements IFKunde {
	/**
	 * Container-Klasse der Objekt-Klasse Kunde
	 * @author Yannik
	 * @version 2.0.0
	 */
	@Override
	public boolean kundehinzufuegen(Kunde kunde) {

		Persistenz p = new Persistenz();
		p.sendCustomer(kunde);
		p.close();
		return true;
	}

	@Override
	public boolean kundeloeschen(int zeile) {

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
		p.delete("KUNDE", "KUNDENNUMMER", wert);
		p.close();

		return true;
	}

	@Override
	public String[][] langenichtkontaktiert() {

		Persistenz p = new Persistenz();
		String sql = "SELECT KONTAKT.KUNDENNUMMER, VORNAME, NAME, MAX (DATUM) FROM KONTAKT JOIN KUNDE ON KONTAKT.KUNDENNUMMER = KUNDE.KUNDENNUMMER WHERE DATEDIFF('month', DATUM, CURRENT_DATE) >=3 GROUP BY KUNDENNUMMER, VORNAME, NAME";
		String[][] data = p.fill(p.sendStatement(sql));

		p.close();

		return data;
	}

	public boolean kundezugruppehinzufuegen(JTable table) {

		Persistenz p = new Persistenz();
		ResultSet rs = p.sendStatement("SELECT MAX(KUNDENNUMMER) FROM KUNDE");
		String kn = "";
		try {
			rs.next();
			kn = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 3) != null) {
				if ((boolean) table.getValueAt(i, 3) == true) {
					p.sendCustomerGroup(Integer.parseInt(kn),
							Integer.parseInt((String) table.getValueAt(i, 0)));
				}
			}

		}
		p.close();

		return true;
	}

	@Override
	public String[] getTableTitle() {
		
		Persistenz p = new Persistenz();
		String[] data = p.getTableTitle("KUNDE");
		p.close();
		
		return data;
	}

	@Override
	public String[][] getKunden(String chosenItem, String suchfragment) {
		
		Persistenz p = new Persistenz();
		String[][] data = p.fill(p.getDataWhereIncludeCast("KUNDE", chosenItem,
				suchfragment));
		System.out.println (data [0][0]);
		p.close();
		
		return data;
	}

	@Override
	public String[][] getKunden() {
		
		Persistenz p = new Persistenz();
		String[][] data = p.fill(p.getData("KUNDE"));
		p.close();
		
		return data;
	}

	@Override
	public ResultSet getResultSet(int id) {
		
		Persistenz pe = new Persistenz();
		ResultSet res = pe.getDataWHERE("KUNDE", "KUNDENNUMMER", id);
		pe.close();
		
		return res;
	}

	@Override
	public boolean kundeaendern(Kunde kunde) {

		Persistenz p = new Persistenz();
		p.updateCustomer(kunde);
		p.close();
		
		return true;

	}

}
