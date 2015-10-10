package main;

import java.util.Scanner;
import java.util.Vector;

public class CoinChangeMain {
	//assumption
	private final static int MAX_NUM_OF_COIN_TYPES = 20;
	private final static int DEFAULT_MAX_QUERY_VALUE = 50000;
	
	Vector <Integer> _coinTypes;
	
	//_memory is used to memorize some steps that will be repeated in order to increase efficiency
	int[][] _memory;
	
	
	public CoinChangeMain(Vector <Integer> coinTypes) {
		setCoinTypes(coinTypes);
		
		initializeMemory();
	}

	/**
	 * 
	 */
	private void initializeMemory() {
		_memory = new int[DEFAULT_MAX_QUERY_VALUE][_coinTypes.size()];
		resetMemory();
	}
	
	private void resetMemory() {
		for (int i = 0; i < DEFAULT_MAX_QUERY_VALUE; i++) {
			for (int j = 0; j < _coinTypes.size(); j++) {
				_memory[i][j] = 0;
			}
		}
	}

	
	private void setCoinTypes(Vector <Integer> coinTypes) {
		_coinTypes = coinTypes;
	}
	
	/**
	 * 
	 * @param queryValue
	 * @param coinTypeIndex
	 * @return
	 */
	public int calculateNumOfWaysToSplitRecursively(int queryValue, int coinTypeIndex) {	
		
		if (queryValue < 0) {
			return 0;
		} else if (queryValue == 0) {
			return 1;
		} else if (queryValue > DEFAULT_MAX_QUERY_VALUE) {
			//let queryValue bounded by DEFAULT_MAX_QUERY_VALUE
			return -1;
		} else {
			//do nothing
		}
		
		int numOfWays = 0; 
		for (int i = coinTypeIndex; i < _coinTypes.size(); i++) {
			int coinType = _coinTypes.get(i).intValue();
			int newQueryValue = queryValue - coinType;
			numOfWays += calculateNumOfWaysToSplitRecursively(newQueryValue, i);
		}
		return numOfWays;
	}
	
	public static void main(String[] args) {
		CoinChangeMain coinChanger = null;
		int numOfCoinTypes;
		Vector <Integer> coinTypes = new Vector <Integer>(MAX_NUM_OF_COIN_TYPES * 2);
		Scanner cin = new Scanner(System.in);
		
		numOfCoinTypes = cin.nextInt();
		for (int i = 0; i < numOfCoinTypes; i++) {
			int newType = cin.nextInt();
			coinTypes.add(newType);
		}
		coinChanger = new CoinChangeMain(coinTypes);
		
		int numOfQueries = cin.nextInt();
		for (int i = 0; i < numOfQueries; i++) {
			int newQuery = cin.nextInt();
			int coinTypeIndex = 0;
			int numOfWays = coinChanger.calculateNumOfWaysToSplitRecursively(newQuery, coinTypeIndex);
			System.out.println(numOfWays);
		}
		
		cin.close();
	}
}
