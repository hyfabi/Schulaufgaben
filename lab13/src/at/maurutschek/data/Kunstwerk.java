package at.maurutschek.data;

import java.time.LocalDate;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab13.1
 *
 */
public abstract class Kunstwerk{
	private String titel;
	private String kuenstler;
	private LocalDate jahr;

	public String getTitel(){
		return titel;
	}

	public void setTitel(String titel){
		if(titel != null && !titel.trim().isEmpty())
			this.titel = titel;
		else
			throw new IllegalArgumentException();
	}

	public String getKuenstler(){
		return kuenstler;
	}

	public void setKuenstler(String kuenstler){
		if(titel != null && !titel.trim().isEmpty())
			this.kuenstler = kuenstler;
		else
			throw new IllegalArgumentException();
	}

	public LocalDate getJahr(){
		return jahr;
	}

	public void setJahr(LocalDate jahr){
		if(jahr.isBefore(LocalDate.now()) || jahr.isEqual(LocalDate.now()))
			this.jahr = jahr;
		else
			throw new IllegalArgumentException();
	}

	public Kunstwerk(String titel, String kuenstler, LocalDate jahr){
		setTitel(titel);
		setKuenstler(kuenstler);
		setJahr(jahr);
	}

	@Override
	public String toString(){
		return titel + ";" + kuenstler + ";" + jahr;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuenstler == null) ? 0 : kuenstler.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Kunstwerk other = (Kunstwerk) obj;
		if(kuenstler == null){
			if(other.kuenstler != null) return false;
		}else if(!kuenstler.equals(other.kuenstler)) return false;
		return true;
	}

	public abstract float transportkosten();

}
