package test;

import static org.junit.Assert.*;

import java.util.Vector;

import main.CoinChangeMain;

import org.junit.Test;

public class CoinChangeMainTest {
	/**
	 * All of these test cases tested the calculateNumOfWaysToSplitRecursively() from CoinChangeMain.
	 */

	@Test
	public void testCalculateNumOfWaysToSplitRecursively1() {
		int numOfCoinTypes = 3;
		
		//to increase efficient by preventing the vector by resizing
		Vector <Integer> coinTypes = new Vector <Integer>(numOfCoinTypes * 2);
		coinTypes.add(1);
		coinTypes.add(2);
		coinTypes.add(3);
		
		CoinChangeMain coinChanger = new CoinChangeMain(coinTypes);
		
		int[] queries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] answers = {1, 2, 3, 4, 5, 7, 8, 10, 12, 14};
		compareAnswers(queries, answers, coinChanger);
		
	}
	
	@Test
	public void testCalculateNumOfWaysToSplitRecursively12() {
		int numOfCoinTypes = 3;
		
		//to increase efficient by preventing the vector by resizing
		Vector <Integer> coinTypes = new Vector <Integer>(numOfCoinTypes * 2);
		coinTypes.add(2);
		coinTypes.add(3);
		coinTypes.add(4);
		
		CoinChangeMain coinChanger = new CoinChangeMain(coinTypes);
		
		int[] queries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] answers = {0, 1, 1, 2, 1, 3, 2, 4, 3, 5};
		compareAnswers(queries, answers, coinChanger);
		
	}
	
	public void compareAnswers(int[] queries, int[] answers, CoinChangeMain coinChanger) {
		if (queries.length != answers.length) {
			fail("queries length is not the same with answers length");
			return;
		}
		
		int coinTypeIndex = 0;
		for (int i = 0; i < queries.length; i++) {
			int numOfWays = coinChanger.calculateNumOfWaysToSplitRecursively(queries[i], coinTypeIndex);
			assertEquals(answers[i], numOfWays);
		}
	}

}
