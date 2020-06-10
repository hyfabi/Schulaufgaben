/**
 * 
 */
package at.application.model;

import java.net.InetAddress;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class ShowableClient{
	private String name;
	private InetAddress ipaddress;

	public ShowableClient(String name, InetAddress ipaddress){
		setIpaddress(ipaddress);
		setName(name);
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public InetAddress getIpaddress(){
		return ipaddress;
	}

	public void setIpaddress(InetAddress ipaddress){
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString(){
		return String.format("Name=%s, Ip-Address=%s]", name, ipaddress);
	}

}
