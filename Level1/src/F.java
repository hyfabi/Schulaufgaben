import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Fabian Maurutschek
 * @version 1.0 Level1
 *
 */
class F{

	@Test
	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect(){
		Greetclient client = new Greetclient();
		try{
			client.startConnection("127.0.0.1", 6666);
		}catch(IOException e){
			e.printStackTrace();
		}
		String response;
		try{
			response = client.sendMessage("hello server");
			assertEquals("hello client", response);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
