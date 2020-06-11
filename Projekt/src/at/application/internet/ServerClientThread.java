/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.net.Socket;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class ServerClientThread extends ConnectionSide{

	public ServerClientThread(Socket s, double i){
		super(s, i);
		try{
			socket = s;
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @param s
	 * @throws IOException
	 */
	@Override
	public void convertIncommingData(TransportData s){
		if(Main.SHOW_MESSAGES)
			System.out.println("Arrived: " + s);
		switch(s.data){
			case "Hello?":
				sendData("Yes?");
			break;
		}
	}
}