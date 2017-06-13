package project;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Kontakt {
	/**
	 * Objektklasse einer Kontaktaktivität.
	 * @author Maxim
	 * @version 2.0.0
	 */
	private int kontaktnummer;
	private int kundennummer;
	private Date datum;
	private String kontaktart;
	private String kurznotiz;
	private String beschreibung;
	
	

	public Kontakt(int kundennummer, Date datum, String kontaktart,
			String kurznotiz, String beschreibung) {
		this.kundennummer = kundennummer;
		this.datum = datum;
		this.kontaktart = kontaktart;
		this.kurznotiz = kurznotiz;
		this.beschreibung = beschreibung;
	}

	public int getKontaktnummer() {
		return kontaktnummer;
	}

	public void setKontaktnummer(int kontaktnummer) {
		this.kontaktnummer = kontaktnummer;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getKontaktart() {
		return kontaktart;
	}

	public void setKontaktart(String kontaktart) {
		this.kontaktart = kontaktart;
	}

	public String getKurznotiz() {
		return kurznotiz;
	}

	public void setKurznotiz(String kurznotiz) {
		this.kurznotiz = kurznotiz;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

}
