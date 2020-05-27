/**
 * 
 */
package at.application.internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Client{
	public static void main(String[] args){
		Client c = new Client();
	}

	public Client(){
		getInterfaceConnections();
	}

	public void createConnection(	String address,
									int port){
		try{
			Socket s = new Socket(address, port);
			s.setKeepAlive(true);

			Scanner scan = new Scanner(System.in);
			while(true){
				if(scan.hasNextLine()){
					PrintWriter p = new PrintWriter(s.getOutputStream());

					p.println(scan.nextLine());
					p.flush();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private boolean checkIfServer(){
		return false;
	}

	private void getInterfaceConnections(){
		try{
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements()){
				NetworkInterface n = e.nextElement();
				if(n.isUp() && !n.isVirtual()){
					Enumeration<InetAddress> e1 = n.getInetAddresses();
					while(e1.hasMoreElements()){
						InetAddress ia = e1.nextElement();
						if(Main.DEBUG)
							System.err.println(ia.getHostName() + " " + ia.getHostAddress());
						getInetAddressConnections4(ia);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void getInetAddressConnections4(InetAddress ip){
		if(ip.getHostAddress().contains(":")
					|| (ip.getHostAddress().startsWith("127.") && Main.LOCAL))
			return;
		try{
			final byte[] ia = ip.getAddress();
			for(int i = 1; i <= 254; i++){
				final int j = i;
				new Thread(new Runnable(){
					@Override
					public void run(){
						try{
							ia[3] = (byte) j;
							InetAddress address = Inet4Address.getByAddress(ia);
							String output = address.toString().substring(1);
							if(address.isReachable(10000)){
								if(Main.DEBUG)
									System.out.println(output + " is on the network");
								tryToConnect(output);
							}
						}catch(SocketException s){
						}catch(Exception e){

							e.printStackTrace();
						}
					}
				}).start();

			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void tryToConnect(String address){
		Socket s;
		try{
			s = new Socket(address, Main.PORT);
			PrintWriter p = new PrintWriter(s.getOutputStream());

			p.println("Connect Test " + Main.SECUTITY_ID);
			p.flush();

			new Thread(new Runnable(){

				@Override
				public void run(){
					try{
						DataInputStream inStream = new DataInputStream(s.getInputStream());
						DataOutputStream outStream = new DataOutputStream(
									s.getOutputStream());
						String clientMessage = "", serverMessage = "";
						while(!clientMessage.equals("bye " + Main.SECUTITY_ID)){
							clientMessage = inStream.readUTF();
							outStream.writeUTF(serverMessage);
							outStream.flush();
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						System.out.println("Server exit!! ");
					}
				}
			}).start();
		}catch(ConnectException e){
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
