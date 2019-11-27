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
		Handy h1 = new Handy("Fabian Got", Tarif.PRIVAT, "+436802081888",
					LocalDate.now().minusDays(666),
					false, 3),
					h2 = new Handy("Timon von Athen", Tarif.FIRMA, "+436765738358",
								LocalDate.now().minusDays(333),
								true, 3),
					h3 = new Handy("Cserichh", Tarif.GRUPPE, "+43000000000",
								LocalDate.now().minusDays(1),
								true, 3),
					h4 = new Handy("Das zwölfjährige Mädchen aus Graz", Tarif.GRUPPE,
								"+436802081881",
								LocalDate.now().minusDays(200),
								true, 3);
		a.add(h1);
		a.add(h2);
		a.add(h3);
		a.add(h4);
// a.del(h2);
// a.delGesperrteHandys();
// a.ausgeben(null);
// System.out.println(a.abgelaufeneHandys());
		a.delGesperrteHandys();
		System.out.println(h1);
	}

}
