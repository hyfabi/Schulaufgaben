package application.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mitarbeiter{
	StringProperty name = new SimpleStringProperty();
	ObjectProperty<LocalDate> gebDat = new SimpleObjectProperty<LocalDate>();
	ObjectProperty<Rang> rang = new SimpleObjectProperty<>();
	StringProperty geschlecht = new SimpleStringProperty();

	public Mitarbeiter(String name, LocalDate gebDat){
		setName(name);
		setGebDat(gebDat);
	}

	public StringProperty geschlechtProperty(){
		return geschlecht;
	}

	public ObjectProperty<Rang> rangProperty(){
		return rang;
	}

	@Override
	public String toString(){
		return getName() + " geboren am " + gebDat.get() + ". Rang: " + rang.get();
	}

	public String getName(){
		return name.get();
	}

	public void setName(String name){
		this.name.set(name);
	}

	public StringProperty nameProperty(){
		return name;
	}

	public LocalDate getGebDat(){
		return gebDat.get();
	}

	public void setGebDat(LocalDate gebDat){
		this.gebDat.set(gebDat);
	}

	public ObjectProperty<LocalDate> gebDatProperty(){
		return gebDat;
	}
}
