/**
 * 
 */
package application.controller;

import application.model.Clothing;
import application.view.RootPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab26
 *
 */
public class ListController implements ChangeListener<Clothing>{
	RootPane rp;

	public ListController(RootPane rp){
		super();
		this.rp = rp;
	}

	@Override
	public void changed(ObservableValue<? extends Clothing> observable,
						Clothing oldM,
						Clothing newM){
		if(oldM != null){
			rp.tf1.textProperty().unbindBidirectional(oldM.getBrand());
			rp.dp.valueProperty().unbindBidirectional(oldM.getDate());
			rp.cp.valueProperty().unbindBidirectional(oldM.getColor());
			rp.cb.valueProperty().unbindBidirectional(oldM.getSize());
			rp.tf2.textProperty().unbindBidirectional(oldM.getPrice());
			rp.cb.valueProperty().unbindBidirectional(oldM.getSize());
			rp.chb.selectedProperty().unbindBidirectional(oldM.getMale());
		}
		if(newM != null){
			rp.tf1.textProperty().bindBidirectional(newM.getBrand());
			rp.dp.valueProperty().bindBidirectional(newM.getDate());
			rp.cp.valueProperty().bindBidirectional(newM.getColor());
			rp.cb.valueProperty().bindBidirectional(newM.getSize());
			rp.tf2.textProperty().bindBidirectional(newM.getPrice(),
						new NumberStringConverter());
			rp.cb.valueProperty().bindBidirectional(newM.getSize());
			rp.chb.selectedProperty().bindBidirectional(newM.getMale());
		}
	}

}
