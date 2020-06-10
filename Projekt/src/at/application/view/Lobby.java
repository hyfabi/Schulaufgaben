/**
 * 
 */
package at.application.view;

import java.net.InetAddress;
import java.util.ArrayList;

import at.application.Main;
import at.application.internet.Client;
import at.application.internet.FindConnection;
import at.application.internet.Server;
import at.application.model.ShowableClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
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
	Server s;
	Client c;
	int i1 = 0;

	boolean join;

	public Lobby(boolean join){
		this.join = join;
		Button btn = new Button("test");
		setCenter(clientsV);
		setLeft(btn);
		btn.setOnAction(x -> btn());

	}

	private void btn(){
		if(join)
			searchServers();
		else{

			s = new Server();
		}
	}

	private void searchServers(){
		for(InetAddress a : FindConnection.get()){
			if(Main.DEBUG_NETWORK)
				System.out.println("Started");
			try{
				c = new Client(a, true, this);
			}catch(Exception e){
				if(e.getMessage() == "Server Found")
					add(a);
				else
					e.printStackTrace();
			}
		}
	}

	public void add(InetAddress ip){
		try{
			clientsV.getItems().add(new ShowableClient("Server", ip));
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
