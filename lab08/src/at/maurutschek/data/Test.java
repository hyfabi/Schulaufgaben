package at.maurutschek.data;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		Obstbaum b1 = new Obstbaum("lol", LocalDate.of(2015, 11, 12), 2f, 2.5f),
				b2 = new Obstbaum("lol", LocalDate.of(2018, 11, 12), 2f, 2.5f);
		Nadelbaum b3 = new Nadelbaum("lol1", LocalDate.of(2015, 11, 12), 2f, 1f, true),
				b4 = new Nadelbaum("lol", LocalDate.now(), 2f, 1f, false);
		Wald w = new Wald();
		w.pflanzeBaum(b1);
		w.pflanzeBaum(b2);
		w.pflanzeBaum(b3);
		w.pflanzeBaum(b4);
		w.baumFaellen("lol1");
		w.nadelbaumPflanzen("Fichte:24.11.2014:0.5:2.5:true");
		w.obstbaumPflanzen("Marillenbaum:24.11.2014:78:3.5");
		w.baeumeGruppiertAusgeben();
//		System.out.println(w.berechneWert());
		
		System.out.println(b1.altersUnterschied(b2));
	}
	
}
