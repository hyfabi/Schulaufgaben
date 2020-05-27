package application.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import application.view.Groesse;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Geschaeft {

    ObservableList<Kleidungsstueck> obs = FXCollections.observableArrayList();




   public Geschaeft() {
	  super();
	  
	  //Deafult
	obs.add(new Kleidungsstueck("Nike",Color.ALICEBLUE,LocalDate.of(2004, 11, 2),Groesse.L,true,20));
	obs.add(new Kleidungsstueck("Adidas",Color.ALICEBLUE,LocalDate.of(2004, 11, 2),Groesse.L,true,20));
   }
   
   public void add(Kleidungsstueck kl) {
	   
	   if(kl != null) {
		   
		   obs.add(kl);
	   }
	   
	   return;
   }
	
   
   public void delete(Kleidungsstueck kl) {
	   
	   if(kl != null) {
		   if(obs.contains(kl)) {
			   obs.remove(kl);
		   }
	   }
	return;   
   }
   
   public void speichern() {
	   
	   
	   
   }
   
   public ObservableList<Kleidungsstueck> getMitarbeiter() {
		return obs;
	}
   
}
