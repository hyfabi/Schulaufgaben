
package at.maurutschek.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import at.maurutschek.data.Messwert;
import at.maurutschek.data.Wetterdaten;
import at.maurutschek.data.Zamg;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab12
 *
 */
class TesteWetter{
	private Zamg z;
	private Wetterdaten w;
	private Messwert m;

	@Test
	public void testeUngueltigesDatum(){
		z = new Zamg();
		assertNotNull(z);
	}

}
