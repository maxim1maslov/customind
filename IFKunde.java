package project;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;

public interface IFKunde {
	
	public boolean kundehinzufuegen(Kunde kunde);
	public ResultSet getResultSet(int id);
	public boolean kundeaendern(Kunde kunde);
	public String[][] getKunden(String chosenItem, String suchfragment);
	public String[][] getKunden();
	public String [] getTableTitle();
	public boolean kundeloeschen(int zeile);
	public String[][] langenichtkontaktiert();
	public boolean kundezugruppehinzufuegen (JTable table);

}
