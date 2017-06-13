package project;

public class Kunde {
	/**
	 * Objektklasse eines Kunden
	 * @author Yannik
	 * @version 2.0.0
	 */
	int Kundennummer;
	String Vorname;
	String Name;
	String Adresse;
	String Hausnummer;
	String ort;
	String plz;
	String Mailadresse;
	String Geburtsdatum;
	String Telefon;

	public Kunde(String Vorname, String Name, String Adresse, String Hausnummer, String ort, String plz, 
			String Mailadresse, String Geburtsdatum, String Telefon) {
		this.Vorname = Vorname;
		this.Name = Name;
		this.Adresse = Adresse;
		this.Hausnummer = Hausnummer;
		this.ort=ort;
		this.plz=plz;
		this.Mailadresse = Mailadresse;
		this.Geburtsdatum = Geburtsdatum;
		this.Telefon = Telefon;
	}
	
	
	public int getKundennummer() {
		return Kundennummer;
	}

	public void setKundennummer(int kundennummer) {
		Kundennummer = kundennummer;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getHausnummer() {
		return Hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		Hausnummer = hausnummer;
	}

	public String getMailadresse() {
		return Mailadresse;
	}

	public void setMailadresse(String mailadresse) {
		Mailadresse = mailadresse;
	}

	public String getGeburtsdatum() {
		return Geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		Geburtsdatum = geburtsdatum;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

}
