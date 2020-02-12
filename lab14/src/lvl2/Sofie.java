/**
 * 
 */
package lvl2;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Lvl1
 *
 */
public class Sofie{

	public static void main(String args[]){
		System.out.println(start(true, true, true, true, true));
		int y = 0;
	}

	public static boolean start(boolean a,
								boolean b,
								boolean c,
								boolean d,
								boolean e){
		if(a && b && c)
			return true;
		if(a && c && d)
			return true;
		if(a && d && e)
			return true;
		if(a && b && d)
			return true;
		if(a && b && e)
			return true;
		if(a && c && e)
			return true;
		if(a && c && d)
			return true;
		if(b && c && d)
			return true;
		if(b && c && e)
			return true;
		if(b && d && e)
			return true;
		if(c && d && b)
			return true;
		return false;
	}
}
