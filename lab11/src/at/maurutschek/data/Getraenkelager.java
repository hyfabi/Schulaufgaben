/**
 * 
 */
package at.maurutschek.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab11
 *
 */
public class Getraenkelager{
	ArrayList<Getraenk> lager;

	public Getraenkelager(){
		lager = new ArrayList<>();
	}

	public void lagern(	String bezeichnung,
						Form form,
						int menge,
						String besitzer){
		Random rnd = new Random();
		Getraenk g = new Getraenk(besitzer, bezeichnung, rnd.nextInt(50) + 1, rnd.nextInt(100) + 1,
					menge, form);
		if(!lager.contains(g))
			lager.add(g);
		else
			throw new RuntimeException();
	}

	public void writeToLog(String s){
		File f = new File(System.getProperty("user.dir") + "\\error.log");// User
		try{
			if(!f.exists())
				f.createNewFile();
			FileWriter fw = new FileWriter(f, true);
			fw.write(s);
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Getraenk entnehmen(Getraenk g){
		if(lager.remove(g))
			return g;
		return null;
	}

	public void ubersicht(int halle){
		for(Getraenk g : lager)
			if(g.getHalle() == halle)
				System.out.println(g);
	}

	public void speichern(File f) throws IOException{
		if(!f.exists() && f.canWrite())
			throw new IOException();
		try(PrintStream fr = new PrintStream(f)){
			for(Getraenk g : lager)
				fr.println(g);
			fr.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public void lesen(File f){
		try(BufferedReader fr = new BufferedReader(new FileReader(f))){
			String s = null;
			while((s = fr.readLine()) != null)
				lager.add(Getraenk.getGetraenk(s));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void auflisten(){
		for(Getraenk g : lager)
			System.out.println(g);
	}

	public ArrayList<String> getBesitzer(){
		ArrayList<String> besitzer = new ArrayList<>();
		for(Getraenk g : lager){
			if(!besitzer.contains(g.getBesitzer()))
				besitzer.add(g.getBesitzer());
		}
		return besitzer;
	}

	public void auflistenGruppiert(){
		for(String b : getBesitzer()){
			System.out.println(b + ":");
			for(Getraenk g : lager)
				if(g.getBesitzer().equals(b))
					System.out.println("\t" + g);
		}
	}
}
