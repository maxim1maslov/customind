package project;

public class Group {
	/**
	 * Objektklasse einer Kundengruppe.
	 * @author Maxim
	 * @version 2.0.0
	 */
int Gruppennummer;
String Bezeichnung;
String Beschreibung;


public Group(String bezeichnung, String beschreibung) {
	Bezeichnung = bezeichnung;
	Beschreibung = beschreibung;
}

public int getGruppennummer() {
	return Gruppennummer;
}
public void setGruppennummer(int gruppennummer) {
	Gruppennummer = gruppennummer;
}
public String getBezeichnung() {
	return Bezeichnung;
}
public void setBezeichnung(String bezeichnung) {
	Bezeichnung = bezeichnung;
}
public String getBeschreibung() {
	return Beschreibung;
}
public void setBeschreibung(String beschreibung) {
	Beschreibung = beschreibung;
}
}
