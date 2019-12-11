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
	private Form form;

	private class Ort{
		private int halle;
		private int regal;

		public Ort(int halle, int regal){
			setHalle(halle);
			setRegal(regal);
		}

		public void setHalle(int halle){
			if(halle > 0 && halle <= 50)
				this.halle = halle;
			else
				throw new GetraenkeException();
		}

		public void setRegal(int regal){
			if(regal > 0 && regal <= 100)
				this.regal = regal;
			else
				throw new GetraenkeException();
		}

		public int getHalle(){
			return halle;
		}

		public int getRegal(){
			return regal;
		}

		@Override
		public String toString(){
			return ",halle=" + halle + ",regal=" + regal;
		}

	}

	public String getBesitzer(){
		return besitzer;
	}

	public Form getForm(){
		return form;
	}

	public void setForm(Form form){
		this.form = form;
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

	public int getHalle(){
		return ort.getHalle();
	}

	public int getRegal(){
		return ort.getRegal();
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

	public Getraenk(String besitzer, String bezeichnung, int halle, int ort, int menge, Form form){
		setBesitzer(besitzer);
		setBezeichnung(bezeichnung);
		setOrt(halle, ort);
		setMenge(menge);
		setForm(form);
	}

	@Override
	public String toString(){
		return "Getraenk [besitzer=" + besitzer + ",bezeichnung=" + bezeichnung + ort
					+ ",menge=" + menge + ",Form=" + form + "]";
	}

	public static Getraenk getGetraenk(String s){
		s = s.substring(s.indexOf('[') + 1, s.indexOf(']'));
		String[] x = s.split(",");
		System.out.println(s);
		return new Getraenk(x[0].substring(x[0].indexOf('=') + 1),
					x[1].substring(x[1].indexOf('=') + 1),
					Integer.parseInt(x[2].substring(x[2].indexOf('=') + 1)),
					Integer.parseInt(x[3].substring(x[3].indexOf('=') + 1)),
					Integer.parseInt(x[4].substring(x[4].indexOf('=') + 1)),
					Form.valueOf(x[5].substring(x[5].indexOf('=') + 1)));
	}

}
