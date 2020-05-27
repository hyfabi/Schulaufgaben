/**
 * 
 */
package application.model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 *          TODO: get/SET
 *
 */
public class Clothing{
	private StringProperty brand;
	private ObjectProperty<Color> color;
	private ObjectProperty<LocalDate> date;
	private ObjectProperty<Size> size;
	private BooleanProperty male;
	private IntegerProperty price;

	public StoreableClothing getStoreable(){
		return new StoreableClothing(brand.get(), color.get().toString(), date.get(),
					size.get(), male.get(), price.get());
	}

	public Clothing(String brand, Color color, LocalDate date, Size size, boolean male, int price){
		if(brand == null || color == null || date == null || size == null || price < 0)
			throw new RuntimeException();
		setBrand(new SimpleStringProperty(brand));
		setColor(new SimpleObjectProperty<>(color));
		setDate(new SimpleObjectProperty<>(date));
		setSize(new SimpleObjectProperty<>(size));
		setMale(new SimpleBooleanProperty(male));
		setPrice(new SimpleIntegerProperty(price));
	}

	public Clothing(StoreableClothing s){
		if(s.brand == null || s.color == null || s.date == null || s.size == null || s.price < 0)
			throw new RuntimeException();
		setBrand(new SimpleStringProperty(s.brand));
		setColor(new SimpleObjectProperty<>(Color.valueOf(s.color)));
		setDate(new SimpleObjectProperty<>(s.date));
		setSize(new SimpleObjectProperty<>(Size.valueOf(s.size)));
		setMale(new SimpleBooleanProperty(s.male));
		setPrice(new SimpleIntegerProperty(s.price));
	}

	public StringProperty getBrand(){
		return brand;
	}

	public void setBrand(StringProperty brand){
		this.brand = brand;
	}

	public ObjectProperty<Color> getColor(){
		return color;
	}

	public void setColor(ObjectProperty<Color> color){
		this.color = color;
	}

	public ObjectProperty<LocalDate> getDate(){
		return date;
	}

	public void setDate(ObjectProperty<LocalDate> date){
		this.date = date;
	}

	public ObjectProperty<Size> getSize(){
		return size;
	}

	public void setSize(ObjectProperty<Size> size){
		this.size = size;
	}

	public BooleanProperty getMale(){
		return male;
	}

	public void setMale(BooleanProperty male){
		this.male = male;
	}

	public IntegerProperty getPrice(){
		return price;
	}

	public void setPrice(IntegerProperty price){
		this.price = price;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		return false;

	}

	@Override
	public String toString(){
		return String.format("Brand: %s, Color: %s, Date: %s, Size: %s, Male: %s, Price: %s",
					brand.get(), color.get(), date.get().toString(), size.get(),
					male.get(),
					price.get());
	}

}
