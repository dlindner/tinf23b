package de.dhbw.tinf23b.principles.tda;

import java.util.ArrayList;
import java.util.List;

public class Studierend {
	
	private final String matrikelnummer;
	private final String vorname;
	private final String nachname;
	private final List<Hobby> hobbies;
	
	public Studierend(
		String matrikelnummer,
		String vorname,
		String nachname
	) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.hobbies = new ArrayList<Hobby>();
	}
	
//	public List<Hobby> getHobbies() {
//		return List.copyOf(hobbies);
//	}
	
//	public String matrikelnummer() {
//		return matrikelnummer;
//	}
//	
//	public String vorname() {
//		return vorname;
//	}
//	
//	public String nachname() {
//		return nachname;
//	}

	public void erstelleEtikettAuf(Etikettendrucker drucker) {
		drucker.drucke(matrikelnummer + ": " + vorname + " " + nachname);
	}
}
