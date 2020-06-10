/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import at.application.Main;
import at.application.view.Lobby;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Client{

	final double CLIENT_ID = Math.random();

	Lobby l;
	Socket socket;
	Thread t;
	String inMessage = "", outMessage = "";
	ObjectInputStream ois;
	ObjectOutputStream oos;
	boolean check;
	InetAddress as;

	public static void main(String[] args){
		@SuppressWarnings("unused")
		Client c = new Client();
	}

	public Client(InetAddress s, boolean check, Lobby l){
		this.check = check;
		this.l = l;
		this.as = s;
		try{
			socket = new Socket(s, Main.PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Client(){
		try{
			socket = new Socket("127.0.0.1", 25565);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void init() throws Exception{
		t = new Thread(() -> {
			try{
				String s = (String) ois.readObject();
				if(s != null && !s.trim().isEmpty())
					convertD(s);
				else
					System.out.println("no");
			}catch(Exception e){
				if(e instanceof NullPointerException){
				}
				if(e.getMessage() == "Server Found" && check){
					l.add(as);
					try{
						t.join();
					}catch(InterruptedException e1){
						e1.printStackTrace();
					}
				}
			}
		});

		t.start();
		testC();
	}

	/**
	 * @param s
	 * @throws Exception
	 */
	private void convertD(String s) throws Exception{
		if(Main.SHOW_MESSAGES)
			System.out.println("Message: " + s);
		switch(s){
			case "Yes?":
				if(check)
					throw new Exception("Server Found");
			break;
		}
	}

	public void testC() throws Exception{
		String s = "Hello?";
		oos.writeObject(s);
	}

	@Override
	protected void finalize(){
		try{
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
