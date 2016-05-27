import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class NationTest {
	@Test
	public void testAggiuntaNazione() throws Exception {
		Vector<Nation> nationVector = new Vector<>();
		
		nationVector.add(new Nation("Italia"));
		nationVector.add(new Nation("Spagna"));
		nationVector.add(new Nation("Giappone"));
		assertEquals(3, nationVector.size());
	}

	@Test
	public void testRicercaNazionePresente() throws Exception {
		Vector<Nation> nationVector = new Vector<>();
		Nation nation = new Nation("");
		nationVector.add(new Nation("Italia"));
		nationVector.add(new Nation("Spagna"));
		nationVector.add(new Nation("Giappone"));
		assertTrue(nation.nationInList("Spagna",nationVector));
	}

	
	@Test
	public void testRicercaNazioneNonPresente() throws Exception {
		Vector<Nation> nationVector = new Vector<>();
		Nation nation = new Nation("");
		nationVector.add(new Nation("Italia"));
		nationVector.add(new Nation("Spagna"));
		nationVector.add(new Nation("Giappone"));
		assertFalse(nation.nationInList("Olanda",nationVector));
	}

}

