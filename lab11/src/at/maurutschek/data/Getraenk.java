/**
 * 
 */
package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab11
 *
 */
public class Getraenk{
	private String besitzer;
	private String bezeichnung;
	private Ort ort;
	private int menge;

	private class Ort{
		private int halle;
		private int ort;

		public Ort(int halle, int ort){
			setHalle(halle);
			setOrt(ort);
		}

		public int getHalle(){
			return halle;
		}

		public void setHalle(int halle){
			if(halle > 0 && halle <= 50)
				this.halle = halle;
			else
				throw new GetraenkeException();
		}

		public int getOrt(){
			return ort;
		}

		public void setOrt(int ort){
			if(ort > 0 && ort <= 100)
				this.ort = ort;
			else
				throw new GetraenkeException();
		}

		@Override
		public String toString(){
			return "halle=" + halle + ", ort=" + ort;
		}

	}

	public String getBesitzer(){
		return besitzer;
	}

	public void setBesitzer(String besitzer){
		if(besitzer != null && !besitzer.trim().isEmpty())
			this.besitzer = besitzer;
		else
			throw new GetraenkeException();
	}

	public String getBezeichnung(){
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung){
		if(bezeichnung != null && !bezeichnung.trim().isEmpty())
			this.bezeichnung = bezeichnung;
		else
			throw new GetraenkeException();
	}

	public Ort getOrt(){
		return ort;
	}

	public void setOrt(	int halle,
						int ort){
		this.ort = new Ort(halle, ort);
	}

	public int getMenge(){
		return menge;
	}

	public void setMenge(int menge){
		if(menge >= 0)
			this.menge = menge;
		else
			throw new GetraenkeException();
	}

	public Getraenk(String besitzer, String bezeichnung, int halle, int ort, int menge){
		setBesitzer(besitzer);
		setBezeichnung(bezeichnung);
		setOrt(halle, ort);
		setMenge(menge);
	}

	@Override
	public String toString(){
		return "Getraenk [besitzer=" + besitzer + ", bezeichnung=" + bezeichnung + ", ort=" + ort
					+ ", menge=" + menge + "]";
	}

	public static Getraenk getGetraenk(String s){
		s = s.substring(s.indexOf('[') + 1, s.indexOf(']'));
		System.out.println(s);
		return null;
	}

}
