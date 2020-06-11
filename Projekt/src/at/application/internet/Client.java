/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import at.application.Main;
import at.application.view.Lobby;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Client extends ConnectionSide{

	Lobby l;
	boolean check;
	InetAddress as;

	public static void main(String[] args){
		try{
			@SuppressWarnings("unused")
			Client c = new Client();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public Client(InetAddress as, boolean check, Lobby l, double clientId) throws IOException{
		super(new Socket(as, Main.PORT), clientId);
		this.check = check;
		this.l = l;
		this.as = as;
		if(check)
			sendData("Hello?");
	}

	public Client() throws UnknownHostException,
					IOException{
		super(new Socket("127.0.0.1", 25565), Math.random());
		sendData("Hello?");
	}

	/**
	 * @param s
	 * @throws Exception
	 */
	@Override
	protected void convertIncommingData(TransportData s) throws Exception{
		if(Main.SHOW_MESSAGES)
			System.out.println("Arrived: " + s);
		if(s.data.startsWith("Yes?")){
			if(check){
				l.add(as, s.fromId);
				throw new Exception("Server Found");
			}
		}else
			System.out.println("Unknown: " + s);

	}
}
