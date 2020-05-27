package at.maurutschek.controller;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab20
 *
 */
public class GameControl{
	private ArrayList<Integer> numbers;

	public GameControl(int n){
		numbers = new ArrayList<>(n);
		Random rnd = new Random();
		for(int i = n; i > 0; i--)
			numbers.add(rnd.nextInt(n) + 1);

	}
}
