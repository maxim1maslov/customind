package project;

import java.sql.ResultSet;

public interface IFKontakt {

	public boolean kontakthinzufuegen(Kontakt kontakt);
	public boolean kontaktloeschen(int zeile);
	public ResultSet getResultSet(int id);
	public String[][] sfgetKontakt(String[] select, String where, Object id); 
	public String[][] getKontakte(int id);
	public String [] getTableTitle();
}
