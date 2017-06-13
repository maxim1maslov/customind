package project;

import java.sql.ResultSet;

public interface IFPersistenz {

	public boolean sendCustomer(Kunde Customer);

	public boolean sendContact(Kontakt contact);

	public boolean sendGroup(Group Gruppe);

	public boolean sendCustomerGroup(int Kundennummer, int Gruppennummer);

	public boolean updateCustomer(Kunde Customer);

	public boolean create();

	public boolean delete(String Tabelle, String spalte, Object wert);

	public ResultSet getData(String Klasse);

	public ResultSet getDataWHERE(String Klasse, String Spalte, Object Bedingung);

	public ResultSet getDataWhereInclude(String Klasse, String Spalte,
			Object Bedingung);

	public ResultSet getDataWhereIncludeCast(String Klasse, String Spalte,
			Object Bedingung);

	public ResultSet sendStatement(String sql);

	public boolean close();

	public boolean shutdown();

	public String[] getTableTitle(String TableName);

	public String[][] fill(ResultSet rs);

}
