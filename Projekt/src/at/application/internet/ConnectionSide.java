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
public abstract class ConnectionSide{
	Socket socket;
	Thread t;
	private ObjectInputStream ois;
	ObjectOutputStream oos;
	final double ID;

	public ConnectionSide(Socket socket, double id){
		try{
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
		this.socket = socket;
		this.ID = id;
		initReading();
	}

	@Override
	protected void finalize(){
		try{
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void initReading(){
		t = new Thread(() -> {
			try{
				TransportData s = (TransportData) ois.readObject();
				if(s != null)
					convertIncommingData(s);
				else
					System.out.println("no");
			}catch(Exception e){
				e.printStackTrace();
			}
		});
		t.start();
	}

	protected void sendData(String data){
		if(Main.SHOW_MESSAGES)
			System.out.println("Send: " + data);
		try{
			oos.writeObject(new TransportData(this.ID, data));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	protected abstract void convertIncommingData(TransportData s) throws Exception;

}
