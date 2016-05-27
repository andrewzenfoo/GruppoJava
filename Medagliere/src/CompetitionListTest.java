import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class CompetitionListTest {
	@Test
	public void testAggiuntaGara() throws Exception {
		
        Vector<Competition> competitionVector = new Vector<>();
		competitionVector.add(new Competition("Lancio del peso"));
		competitionVector.add(new Competition("100MT piani"));
		assertEquals(2, competitionVector.size());
	}

	
	@Test
	public void testRicercaGaraPresente() throws Exception {
		Vector<Competition> competitionVector = new Vector<>();
		Competition competition = new Competition("");
		competitionVector.add(new Competition("Lancio del peso"));
		competitionVector.add(new Competition("100MT piani"));
		assertTrue(competition.competitionInList("Lancio del peso",competitionVector));
	}

	@Test
	public void testRicercaGaraNonPresente() throws Exception {
		Vector<Competition> competitionVector = new Vector<>();
		Competition competition = new Competition("");
		competitionVector.add(new Competition("Lancio del peso"));
		competitionVector.add(new Competition("100MT piani"));
		assertFalse(competition.competitionInList("Lancio del martello",competitionVector));
	}
}
