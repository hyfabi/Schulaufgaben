/**
 * 
 */
package at.maurutschek.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import at.maurutschek.exceptions.Fehlertyp;
import at.maurutschek.exceptions.WetterException;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab12
 *
 */
public class Messwert{
	private LocalDate datum;
	private byte temperatur;
	private byte windstaerke;

	public Messwert(LocalDate datum, byte temperatur, byte windstaerke){
		setDatum(datum);
		setTemperatur(temperatur);
		setWindstaerke(windstaerke);
	}

	public LocalDate getDatum(){
		return datum;
	}

	public void setDatum(LocalDate datum){
		this.datum = datum;
	}

	public byte getTemperatur(){
		return temperatur;
	}

	public void setTemperatur(byte temperatur){
		if(temperatur >= -90 && temperatur <= 65)
			this.temperatur = temperatur;
		else
			throw new WetterException(Fehlertyp.MESSDATAEN);
	}

	public byte getWindstaerke(){
		return windstaerke;
	}

	public void setWindstaerke(byte windstaerke){
		if(windstaerke >= 0 && windstaerke <= 12)
			this.windstaerke = windstaerke;
		else
			throw new WetterException(Fehlertyp.MESSDATAEN);
	}

	@Override
	public String toString(){
		return datum.format(
					DateTimeFormatter.ofPattern("dd.MM.yy")) + ":" + temperatur + ":" + windstaerke;
	}

	public static Messwert getMesswert(String s){
		String[] x = s.split(":");
		if(x.length != 3)
			throw new IllegalArgumentException();
		return new Messwert(LocalDate.parse(x[0], DateTimeFormatter.ofPattern("dd.MM.yy")),
					Byte.parseByte(x[1]), Byte.parseByte(x[2]));
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Messwert other = (Messwert) obj;
		if(!datum.isEqual(other.getDatum()))
			return false;
		return true;
	}

}
