/**
 * 
 */
package at.application.internet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

import at.application.Main;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class FindConnection{
	private static ArrayList<InetAddress> getInterfaceConnections(){
		ArrayList<InetAddress> i = new ArrayList<>();
		try{
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements()){
				NetworkInterface n = e.nextElement();
				if(n.isUp() && !n.isVirtual()){
					Enumeration<InetAddress> e1 = n.getInetAddresses();
					while(e1.hasMoreElements()){
						InetAddress ia = e1.nextElement();
						if(Main.DEBUG_NETWORK)
							System.err.println(ia.getHostName() + " " + ia.getHostAddress());
						i.addAll(getInetAddressConnections4(ia));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	public static ArrayList<InetAddress> get(){
		return getInterfaceConnections();
	}

	private static ArrayList<InetAddress> getInetAddressConnections4(InetAddress ip){
		ArrayList<InetAddress> xx = new ArrayList<>();
		if(ip.getHostAddress().contains(":")
					|| (ip.getHostAddress().startsWith("127.") && Main.LOCAL))
			return xx;
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
							if(Main.DEBUG_NETWORK)
								System.out.println(output);
							if(address.isReachable(10000)){
								xx.add(address);
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
		return xx;
	}

// public boolean tryToConnect(String address){
// Socket s;
// try{
// s = new Socket(address, Main.PORT);
// PrintWriter p = new PrintWriter(s.getOutputStream());
//
// p.println("Connect Test " + Main.SECUTITY_ID);
// p.flush();
//
// new Thread(new Runnable(){
//
// @Override
// public void run(){
// try{
// DataInputStream inStream = new DataInputStream(s.getInputStream());
// DataOutputStream outStream = new DataOutputStream(
// s.getOutputStream());
// String clientMessage = "", serverMessage = "";
// while(!clientMessage.equals("bye " + Main.SECUTITY_ID)){
// clientMessage = inStream.readUTF();
// if(clientMessage == "TryToConnect")
// serverMessage = "TrueTryToConnect";
// System.out.println(clientMessage);
// outStream.writeUTF(serverMessage);
// outStream.flush();
// }
// }catch(Exception e){
// e.printStackTrace();
// }finally{
// System.out.println("Server exit!! ");
// }
// }
// }).start();
// }catch(ConnectException e){
// }catch(Exception e){
// e.printStackTrace();
// }
// }

}
