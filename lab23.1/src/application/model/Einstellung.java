/**
 * 
 */
package application.model;

import java.io.Serializable;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23.1
 *
 */
public class Einstellung implements Serializable{

	private static final long serialVersionUID = 7561373219780183268L;
	private String name;
	private double opacity;
	private String pM, pK, pG, pP;

	public Einstellung(){
		setName("Name");
		opacity = 1;
		pM = "3.jpg";
		pK = "1.jpg";
		pG = "2.jpg";
		pP = "4.png";
	}

	public Einstellung(String name, double opacity, String pM, String pK, String pG, String pP){
		super();
		setName(name);
		setOpacity(opacity);
		setpM(pM);
		setpK(pK);
		setpG(pG);
		setpP(pP);
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getOpacity(){
		return opacity;
	}

	public void setOpacity(double opacity){
		this.opacity = opacity;
	}

	public String getpM(){
		return pM;
	}

	public void setpM(String pM){
		this.pM = pM;
	}

	public String getpK(){
		return pK;
	}

	public void setpK(String pK){
		this.pK = pK;
	}

	public String getpG(){
		return pG;
	}

	public void setpG(String pG){
		this.pG = pG;
	}

	public String getpP(){
		return pP;
	}

	public void setpP(String pP){
		this.pP = pP;
	}

	@Override
	public Einstellung clone(){
		try{
			return (Einstellung) super.clone();
		}catch(Exception e){
			return new Einstellung(name, opacity, pM, pK, pG, pP);
		}

	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(opacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pG == null) ? 0 : pG.hashCode());
		result = prime * result + ((pK == null) ? 0 : pK.hashCode());
		result = prime * result + ((pM == null) ? 0 : pM.hashCode());
		result = prime * result + ((pP == null) ? 0 : pP.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Einstellung other = (Einstellung) obj;
		if(!name.equals(other.name)) return false;
		return true;
	}

	@Override
	public String toString(){
		return (name);
	}

}
