/**
 * 
 */
package at.application.internet;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Fabian Maurutschek
 * @version 1.0 Projekt
 *
 */
public class Client extends ServerClientThread{
	/**
	 * @param inSocket
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public Client() throws UnknownHostException,
					IOException{
		super(new Socket("127.0.0.1", 25565));
	}
}
