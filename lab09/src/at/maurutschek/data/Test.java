package at.maurutschek.data;

import java.time.LocalDate;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab09
 *
 */
public class Test{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Anbieter a = new Anbieter();
		Handy h1 = new Handy("f", Tarif.FIRMA, "+436802081888", LocalDate.now().minusDays(655),
					false, 3);
		System.out.println(h1);
	}

}
