package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dice.Dice;
import dice.FairDice;
import dice.WeightedDice;
import game.ComputerPlayer;
import game.GameController;
import game.GameControllerImpl;
import game.Player;

class GameTest {
	@Test
	void TestDiceSidesNegative() {
		try{
			Dice a = new FairDice(-1);
			fail("exception not thrown");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	void TestDiceSidesZero() {
		try{
			Dice a = new FairDice(0);
			fail("exception not thrown");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	void TestDiceSidesPositive() {
		try{
			Dice a = new FairDice(6);
		} catch (Exception e) {
			fail("exception not thrown");
		}
	}
	
	@Test
	void TestDiceSideGet() throws Exception {
		Dice a = new FairDice(6);
		assertEquals(6,a.getSides());
	}
	
	@Test
	void TestWeightedDie() throws Exception{
		Dice a = new WeightedDice(6,6);
		int count = 0;
		for (int i = 0; i < 10000; i++) {
			if (a.rollDie() == 6) {
				count++;
			}
		}
		assertEquals(7000,count,600);
	}
}
