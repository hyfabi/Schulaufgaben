/**
 * 
 */
package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab10
 *
 */
public class Fach{
	private byte note;
	private String name;

	public Fach(byte note, String name) throws Exception{
		setName(name);
		setNote(note);
	}

	public void setNote(byte note) throws Exception{
		if(note > 0 && note <= 5)
			this.note = note;
		else
			throw new Exception("Fehler in der Notenvergabe!");
	}

	public String getName(){
		return name;
	}

	public void setName(String name) throws Exception{
		if(name != null && name.trim().isEmpty())
			this.name = name;
		else
			throw new Exception("Fehler bei der Namensgebung im Fach");
	}

	public byte getNote(){
		return note;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Fach other = (Fach) obj;
		if(!name.equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return "Fach [note=" + note + ", name=" + name + "]";
	}

}
