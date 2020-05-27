/**
 * 
 */
package at.application.internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
class ServerClientThread extends Thread{
	Socket serverClient;
	int clientNo;
	int squre;

	ServerClientThread(Socket inSocket, int counter){
		serverClient = inSocket;
		clientNo = counter;
	}

	@Override
	public void run(){
		try{
			DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
			String clientMessage = "", serverMessage = "";
			while(!clientMessage.equals("bye " + Main.SECUTITY_ID)){
				clientMessage = inStream.readUTF();
				System.out.println("From Client-" + clientNo + ": Number is :" + clientMessage);
				squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
				serverMessage = "From Server to Client-" + clientNo + " Square of " + clientMessage
							+ " is " + squre;
				outStream.writeUTF(serverMessage);
				outStream.flush();
			}
			inStream.close();
			outStream.close();
			serverClient.close();
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			System.out.println("Client -" + clientNo + " exit!! ");
		}
	}
}