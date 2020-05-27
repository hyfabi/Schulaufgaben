package application.model;

import java.time.LocalDate;

import application.view.Groesse;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class Kleidungsstueck {

	StringProperty marke = new SimpleStringProperty();
	ObjectProperty<Color> farbe = new SimpleObjectProperty<Color>();
	ObjectProperty<LocalDate> datum = new SimpleObjectProperty<LocalDate>();
	ObjectProperty<Groesse> groesse = new SimpleObjectProperty<Groesse>();
	BooleanProperty geschlecht = new SimpleBooleanProperty();
	IntegerProperty preis = new SimpleIntegerProperty();
	
	
	@Override
	public String toString() {
		return "Kleidungsstueck [marke=" + marke + ", farbe=" + farbe + ", datum=" + datum + ", groesse=" + groesse
				+ ", geschlecht=" + geschlecht + ", preis=" + preis + "]";
	}



	public Kleidungsstueck(String marke, Color farbe, LocalDate datum,
			Groesse groesse, boolean geschlecht, int preis) {
		super();
	     setMarke(marke);
	
		setFarbe(farbe);
		setDatum(datum);
		setGroesse(groesse);
		setGeschlecht(geschlecht);
		setPreis(preis);
	}
	
	public Kleidungsstueck() {
		
	}

	public String getMarke() {
		return marke.get();
	}

	public StringProperty getMarkeProperty() {
		return marke;
	}

    //nullPointer?
	public void setMarke(String marke) {
		
		
		if(marke != null ) {
		this.marke.set(marke);
		}
	
	}

	public Color getFarbe() {
		return farbe.get();
	}
	
	public ObjectProperty<Color> getFarbeProperty() {
		return farbe;
	}


	public void setFarbe(Color farbe) {
		
		if(farbe != null)
		this.farbe.set(farbe);
	}

	public LocalDate getDatum() {
		return datum.get();
	}

	public ObjectProperty<LocalDate> getDatumProperty() {
		return datum;
	}


	public void setDatum(LocalDate datum) {
		
		if(datum != null)
		this.datum.set(datum);
	}

	public Groesse getGroesse() {
		return groesse.get();
	}
	
	public ObjectProperty<Groesse> getGroesseProperty() {
		return groesse;
	}


	public void setGroesse(Groesse groesse) {
		
		if(groesse != null)
		this.groesse.set(groesse);
	}

	public boolean getGeschlecht() {
		return geschlecht.get();
	}

	public BooleanProperty getGeschlechtProperty() {
		return geschlecht;
	}


	public void setGeschlecht(boolean geschlecht) {
		
		
		this.geschlecht.set(geschlecht);
	}

	public int getPreis() {
		return preis.get();
	}

	public IntegerProperty getPreisProperty() {
		return preis;
	}


	public void setPreis(int preis) {
		
		
		this.preis.set(preis);
	}
	
	
	
}
