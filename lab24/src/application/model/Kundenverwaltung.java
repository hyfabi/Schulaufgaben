package application.model;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kundenverwaltung{
	ObservableList<Kunde> kunden = FXCollections.observableArrayList();

	public Kundenverwaltung(){
		mockup();
	}

	public void mockup(){
		Kunde k1 = new Kunde("Max Muster", LocalDate.of(1988, 3, 4), Art.privatkunde);
		k1.addBestellung(new Bestellung("Aktenordner", 3, LocalDate.of(2017, 11, 12)));
		k1.addBestellung(new Bestellung("A4 Block kariert 20 Blatt", 8,
					LocalDate.of(2018, 3, 12)));
		k1.addBestellung(new Bestellung("Marker", 2, LocalDate.of(2016, 12, 3)));
		k1.addBestellung(new Bestellung("Aktenordner", 4, LocalDate.of(2018, 3, 17)));
		k1.addBestellung(new Bestellung("Bleistift", 4, LocalDate.of(2017, 11, 12)));
		k1.addBestellung(new Bestellung("Hefter", 3, LocalDate.of(2017, 11, 12)));
		Kunde k2 = new Kunde("Best Business", LocalDate.of(2017, 1, 1), Art.firma);
		k2.addBestellung(new Bestellung("Aktenordner", 3, LocalDate.of(2017, 11, 12)));

		Kunde k3 = new Kunde("Susi Berger", LocalDate.of(1976, 12, 11), Art.privatkunde);
		Kunde k4 = new Kunde("Tom Turbo", LocalDate.of(1981, 11, 9), Art.privatkunde);
		kunden.add(k1);
		kunden.add(k2);
		kunden.add(k3);
		kunden.add(k4);

	}

	public ObservableList<Kunde> getKunden(){
		return kunden;
	}

	public void setKunden(ObservableList<Kunde> kunden){
		this.kunden = kunden;
	}

	public ObservableList<Kunde> getKunden(Art a){
		ObservableList<Kunde> kList = FXCollections.observableArrayList();
		for(Kunde ku : kunden){
			if(ku.getArt().equals(a))
				kList.add(ku);
		}
		return kList;
	}

}
