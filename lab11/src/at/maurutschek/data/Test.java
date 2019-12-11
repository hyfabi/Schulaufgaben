/**
 * 
 */
package at.maurutschek.data;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab11
 *
 */
public class Test{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(
					Getraenk.getGetraenk(new Getraenk("d", "d", 3, 3, 5, Form.DOSE).toString()));
		Getraenkelager gl = new Getraenkelager();
		gl.writeToLog("lol1\n");
	}

}
