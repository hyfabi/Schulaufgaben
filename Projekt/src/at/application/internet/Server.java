/**
 * 
 */
package at.application.internet;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import at.application.Main;
import at.application.view.Lobby;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Server{

	// TODO ServerClientThread -> Showable Client
	ArrayList<ServerClientThread> clients = new ArrayList<>();
	Lobby l;

	public static void main(String[] args){
		Server s = new Server(null);
		s.start();
	}

	public Server(Lobby l){
		this.l = l;
	}

	public void start(){
		try{
			ServerSocket server = new ServerSocket(25565);
			if(Main.DEBUG)
				System.out.println("Server Started ....");
			while(true){
				Socket serverClient = server.accept();
				if(Main.DEBUG)
					System.out.println("Client started!");
				ServerClientThread sct = new ServerClientThread(serverClient);
				clients.add(sct);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
