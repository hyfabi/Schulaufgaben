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
	private double id;

	public ShowableClient(String name, InetAddress ipaddress, double id){
		setIpaddress(ipaddress);
		setName(name);
		this.id = id;
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

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		ShowableClient other = (ShowableClient) obj;
		if(Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id)) return false;
		return true;
	}

}
