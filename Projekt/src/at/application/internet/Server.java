/**
 * 
 */
package at.application.internet;

import java.net.ServerSocket;
import java.net.Socket;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Server{

	final double SERVER_ID = Math.random();

	ServerSocket server;

	public static void main(String[] args){
		@SuppressWarnings("unused")
		Server s = new Server();
	}

	@SuppressWarnings("unused")
	public Server(){
		try{
			server = new ServerSocket(Main.PORT);
			int counter = 0;
			if(Main.DEBUG_NETWORK)
				System.out.println("Server Started ....");
			while(true){
				counter++;
				Socket serverClient = server.accept();
				System.out.println(" >> " + "Client No:" + counter + " started!");
				new ServerClientThread(serverClient, SERVER_ID);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	protected void finalize() throws Throwable{
		server.close();
	}

}
