package application.model;

import java.time.LocalDate;

public class Person{
	String name;
	LocalDate gebDat;

	public Person(String name, LocalDate gebDat){
		super();
		this.name = name;
		this.gebDat = gebDat;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public LocalDate getGebDat(){
		return gebDat;
	}

	public void setGebDat(LocalDate gebDat){
		this.gebDat = gebDat;
	}

}
