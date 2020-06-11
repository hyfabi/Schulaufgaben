/**
 * 
 */
package at.application.view;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Optional;

import at.application.Main;
import at.application.internet.Client;
import at.application.internet.FindConnection;
import at.application.internet.Server;
import at.application.model.ShowableClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Lobby extends BorderPane{

	final double CLIENT_ID = Math.random();

	ObservableList<ShowableClient> clients = FXCollections
				.observableArrayList(new ArrayList<ShowableClient>());
	ListView<ShowableClient> clientsV = new ListView<>(clients);
	Server s;
	Client c;
	int i1;

	boolean join;

	public Lobby(boolean join){
		this.join = join;
		setCenter(clientsV);
		clientsV.getSelectionModel().selectedItemProperty().addListener((	x,
																			y,
																			z) -> {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setHeaderText("Wollen Sie dem Server wirklich beitreten?");
			Optional<ButtonType> o = a.showAndWait();
			if(o.isPresent())
				if(o.get().getText().equals("OK")){
					try{
						c = new Client(z.getIpaddress(), false, this, CLIENT_ID);
					}catch(IOException e){
						e.printStackTrace();
					}
					sessionStart();
				}
		});
		search();
	}

	private void sessionStart(){

	}

	private void search(){
		if(join){
			Thread t = new Thread(() -> {
				try{
					searchServers();
					System.out.println("Fertig gesucht");
					Thread.currentThread().join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}catch(Exception e){
					if(e instanceof ConnectException)
						System.out.println("Iwelche Probleme");
				}
				if(Main.DEBUG)
					System.out.println("Thread Ended");
			});
			t.start();
		}else
			s = new Server();

	}

	private void searchServers() throws IOException{
		for(InetAddress a : FindConnection.get()){
			if(Main.DEBUG_NETWORK)
				System.out.println("Started");
			c = new Client(a, true, this, CLIENT_ID);
		}
	}

	public void add(InetAddress ip,
					double id){
		try{
			ShowableClient s1 = new ShowableClient("Server: " + id, ip, id);
			if(!clientsV.getItems().contains(s1))
				clientsV.getItems().add(s1);
			Thread.sleep(100);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable{
		System.gc();
		super.finalize();
	}
}
