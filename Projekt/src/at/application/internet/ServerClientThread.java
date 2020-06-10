/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class ServerClientThread extends Thread{
	Socket socket;
	Thread t;
	String inMessage = "", outMessage = "";
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public ServerClientThread(Socket s){
		try{
			socket = s;
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			init();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private void init(){

		t = new Thread(() -> {
			try{
				String s = (String) ois.readObject();
				if(s != null && !s.trim().isEmpty())
					convertD(s);
			}catch(Exception e){
				if(e instanceof NullPointerException){
				}
			}
		});
		t.start();
	}

	/**
	 * @param s
	 * @throws IOException
	 */
	private void convertD(String s) throws Exception{
		if(Main.SHOW_MESSAGES)
			System.out.println("Messeage-To-Server: " + s);
		switch(s){
			case "Hello?":
				oos.writeObject("Yes?");
			break;
		}
	}
}