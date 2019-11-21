package at.maurutschek.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * TODO setMethoden verbessern
 * 
 * @author Fabian Maurutschek
 * @version 1.0 lab09
 *
 */
public class Handy{
	private String besitzer;
	private Tarif tarif;
	private String telefonnummer;
	private LocalDate kaufdatum;
	private boolean gesperrt;
	private int laufzeit;

	public Handy(	String besitzer,
					Tarif tarif,
					String telefonnummer,
					LocalDate kaufdatum,
					boolean gesperrt,
					int laufzeit){
		setBesitzer(besitzer);
		setTarif(tarif);
		setTelefonnummer(telefonnummer);
		setKaufdatum(kaufdatum);
		setGesperrt(gesperrt);
		setLaufzeit(laufzeit);
	}

	public String getBesitzer(){
		return besitzer;
	}

	public void setBesitzer(String besitzer){
		if(besitzer != null && !besitzer.trim().isEmpty())
			this.besitzer = besitzer;
		else
			throw new NullPointerException();
	}

	public Tarif getTarif(){
		return tarif;
	}

	public void setTarif(Tarif tarif){
		this.tarif = tarif;
	}

	public String getTelefonnummer(){
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer){
		if(telefonnummer != null && !telefonnummer.trim().isEmpty() && telefonnummer.length() > 9)
			this.telefonnummer = telefonnummer;
		else
			throw new RuntimeException();
	}

	public LocalDate getKaufdatum(){
		return kaufdatum;
	}

	public void setKaufdatum(LocalDate kaufdatum){
		if(kaufdatum.isBefore(LocalDate.now()) || kaufdatum.isEqual(LocalDate.now()))
			this.kaufdatum = kaufdatum;
		else
			kaufdatum = LocalDate.now().minusYears(1);
	}

	public boolean isGesperrt(){
		return gesperrt;
	}

	public void setGesperrt(boolean gesperrt){
		this.gesperrt = gesperrt;
	}

	public int getLaufzeit(){
		return laufzeit;
	}

	public void setLaufzeit(int laufzeit){
		if(laufzeit > 0)
			this.laufzeit = laufzeit;
		else
			throw new RuntimeException();
	}

	public static Handy getHandy(String s){
		String[] a = s.split(":");
		return new Handy(a[0], Tarif.valueOf(a[1]), a[2],
					LocalDate.parse(a[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")),
					Boolean.getBoolean(a[4]),
					Integer.parseInt(a[5]));
	}

	@Override
	public String toString(){
		return "Handy [besitzer=" + besitzer + ", tarif=" + tarif + ", telefonnummer="
					+ telefonnummer + ", kaufdatum="
					+ kaufdatum.format(DateTimeFormatter.ofPattern("dd.MMM.yy")) + ", gesperrt="
					+ gesperrt
					+ ", laufzeit=" + laufzeit + "]";
	}

	public Period wielange(){
		return Period.between(kaufdatum, LocalDate.now());
	}

	public Period noch(){
		if(LocalDate.now().isAfter(kaufdatum.plusYears(laufzeit)))
			return null;
		return Period.between(LocalDate.now(), kaufdatum.plusYears(laufzeit));
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + laufzeit;
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Handy other = (Handy) obj;
		if(laufzeit != other.laufzeit) return false;
		return true;
	}

}
