/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class ServerClientThread extends Thread{
	Socket so;
	Scanner scan;
	PrintWriter pw;
	ArrayList<String> dataToSend = new ArrayList<>();

	public ServerClientThread(Socket inSocket){
		so = inSocket;
		try{
			scan = new Scanner(so.getInputStream());
			pw = new PrintWriter(so.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run(){
		listen(scan);
		send(pw);
	}

	public void send(PrintWriter pw1){
		String s = dataToSend.remove(0);
		if(s != null && !s.trim().isEmpty())
			pw1.write(s);
		pw1.flush();
	}

	public void listen(Scanner s1){
		try{
			if(s1.hasNextLine()){
				result(s1.nextLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void result(String st){
		switch(st){
			case "Stop":
				try{
					join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			break;
			case "TryToConnect":
				dataToSend.add("TrueTryToConnect");
			break;
			default:
				System.out.println("Another Message: " + st);
			break;
		}
	}
}