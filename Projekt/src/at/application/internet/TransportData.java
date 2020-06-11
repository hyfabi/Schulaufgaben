/**
 * 
 */
package at.application.internet;

import java.io.Serializable;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public final class TransportData implements Serializable{
	private static final long serialVersionUID = -2558475835756734422L;
	double fromId;
	String data;

	public TransportData(double fromId, String data){
		this.fromId = fromId;
		this.data = data;
	}

	@Override
	public String toString(){
		return String.format("[Id=%s, Message=%s]", fromId, data);
	}

}
