/**
 * 
 */
package application.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 */
public class StoreableClothing implements Serializable{
	private static final long serialVersionUID = 6854960838845853359L;
	public String brand;
	public String color;
	public LocalDate date;
	public String size;
	public boolean male;
	public int price;

	public StoreableClothing(	String brand,
								String color,
								LocalDate date,
								Size size,
								boolean male,
								int price){
		super();
		this.brand = brand;
		this.color = color;
		this.date = date;
		this.size = size.toString();
		this.male = male;
		this.price = price;
	}
}