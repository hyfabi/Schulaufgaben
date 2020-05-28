/**
 * 
 */
package at.application.internet;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
class ServerClientThread{
	Socket serverClient;
	int clientNo;
	int squre;

	ServerClientThread(Socket inSocket, int counter){
		serverClient = inSocket;
		clientNo = counter;
		start();
	}

	public void start(){
		try{
			Scanner scan = new Scanner(serverClient.getInputStream());
			while(true){
				if(scan.hasNextLine()){
					PrintWriter p = new PrintWriter(serverClient.getOutputStream());
					System.out.println(scan.next());
					p.println("True");
					p.flush();
				}
			}
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			System.out.println("Client -" + clientNo + " exit!! ");
		}
	}
}