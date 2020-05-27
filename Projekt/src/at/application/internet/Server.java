/**
 * 
 */
package at.application.internet;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Server{

	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(25565);
			int counter = 0;
			System.out.println("Server Started ....");
			while(true){
				counter++;
				Socket serverClient = server.accept();
				System.out.println(" >> " + "Client No:" + counter + " started!");
				ServerClientThread sct = new ServerClientThread(serverClient, counter);
				sct.start();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
