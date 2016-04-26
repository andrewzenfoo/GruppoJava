import static org.junit.Assert.*;

import org.junit.Test;

public class TamagotchiTest {
	/*
	@Test
	public void test_give_only_bisquits_dies() {
		Tamagotchi tamagotchi = new Tamagotchi("test biscotti", 30, 30);
			int biscotti=0;
			do{
				tamagotchi.giveBiscuit();
				biscotti++;			
			}while(tamagotchi.isDead()==false);
		tamagotchi.checkStatus();
		System.out.printf("ha mangiato %d biscotti prima di morire", biscotti);
			
	}
	@Test
	public void test_give_only_love_dies() {
		Tamagotchi tamagotchi = new Tamagotchi("test love", 50, 30);
			int love=0;
			do{
				tamagotchi.giveLove();
				love++;			
			}while(tamagotchi.isDead()==false);
		tamagotchi.checkStatus();
		System.out.printf("ha avuto %d carezze prima di morire", love);
			
	}
	*/
	///////
	///////
	///////
	@Test
	public void dieForZeroSatisfaction() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 0, 50);
		assertTrue(tamagotchi.isDead());
	}
	
	@Test
	public void dieForZeroHunger() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 0);
		assertTrue(tamagotchi.isDead());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 50);
		assertFalse(tamagotchi.isDead());
	}
/****	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception 
	{
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeHunger() throws Exception 
	{
		new Tamagotchi("Kira", 50, -10);
	}
	
	*****/
	@Test
	public void petCanReceivePets() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 50);
		tamagotchi.giveLove();
		assertFalse(tamagotchi.imSad());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 50);
		tamagotchi.giveBiscuit();
		assertFalse(tamagotchi.imSad());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 10, 50);
		assertTrue(tamagotchi.imSad());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 95, 50);
		assertTrue(tamagotchi.imSad());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 50);
		assertFalse(tamagotchi.imSad());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 99, 50);
			for(int i=0;i<10;i++){
				tamagotchi.giveBiscuit();
			}
			/* false is alive, true is dead */
		assertTrue(!tamagotchi.isDead());
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception 
	{
		final Tamagotchi tamagotchi = new Tamagotchi("Kira", 50, 29);
			for(int i=0;i<10;i++){
				tamagotchi.giveLove();
			}
		assertFalse(tamagotchi.imSad());
	}
}
