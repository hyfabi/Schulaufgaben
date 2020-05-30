/**
 * 
 */
package at.application.view;

import java.net.InetAddress;
import java.util.ArrayList;

import at.application.internet.Client;
import at.application.internet.Server;
import at.application.model.ShowableClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Lobby extends BorderPane{

	ObservableList<ShowableClient> clients = FXCollections
				.observableArrayList(new ArrayList<ShowableClient>());
	ListView<ShowableClient> clientsV = new ListView<>(clients);
	Stage stage = new Stage();

	public void add(String ip){
		try{
			clients.add(new ShowableClient("Test", InetAddress.getByName(ip)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	Server s;
	Client c;

	boolean join;

	public Lobby(boolean join){
		this.join = join;

		stage.setTitle("Ich mag Kekse");

		stage.setScene(new Scene(this, 800, 600));
		setCenter(clientsV);
		stage.show();

		if(join) try{
			c = new Client();
		}catch(Exception e){
			e.printStackTrace();
		}
		else
			s = new Server(this);
	}

}
