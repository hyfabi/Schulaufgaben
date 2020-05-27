/**
 * 
 */

/**
 * @author Fabian Maurutschek
 * @version 1.0 Pos Logik
 *
 */
public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(hornor(100.1f, 2));
	}

	public static int addieren(	int num1,
								int num2,
								int basis){
		String num1s = num1 + "", num2s = num2 + "";
		for(int i = num1s.length() - 1; i <= 0; i--){

		}
		return 0;
	}

	public static float hornor(	float num1,
								float basis){
		String num1s = num1 + "";
		String n1[] = num1s.split(".");
		int n = n1[n1.length - 1].length();
		float sum = 0;
		int x = 0;
		for(int i = num1s.length() - 1; i >= 0; i--){
			if(num1s.charAt(i) == '.'){
				continue;
			}
			sum += (Float.parseFloat(num1s.charAt(i) + "")) * Math.pow(basis, x);
			x++;
		}
		return sum;
	}

}
