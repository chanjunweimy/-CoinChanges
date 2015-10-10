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

	
	private void initializeMemory() {
		_memory = new int[DEFAULT_MAX_QUERY_VALUE + 2][_coinTypes.size()];
		resetMemory();
	}
	
	/**
	 * resetMemory is to resetMemory to all null values.
	 * _memory[0][j] is for negative query values for each coinTypeIndex
	 * _memory[1..DEFAULT_MAX_QUERY_VALUE+1][j] is for non-negative query values (i get by queryValue + 1) for each coinTypeIndex
	 */
	private void resetMemory() {
		for (int i = 0; i <= DEFAULT_MAX_QUERY_VALUE + 1; i++) {
			for (int j = 0; j < _coinTypes.size(); j++) {
				_memory[i][j] = -1;
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
		//check base cases
		if (queryValue < 0) {
			//if queryValue < 0, this combination does not work, return 0
			return 0;
		} else if (queryValue == 0) {
			//if queryValue == 0, this combination works, return 1
			return 1;
		} else if (queryValue > DEFAULT_MAX_QUERY_VALUE) {
			//let queryValue bounded by DEFAULT_MAX_QUERY_VALUE
			return -1;
		} else {
			//do nothing
		}
				
		int numOfWays = runRecursiveCases(queryValue, coinTypeIndex);
		return numOfWays;
	}


	/**
	 * The recursive case of calculateNumOfWaysToSplitRecursively()
	 * @param queryValue
	 * @param coinTypeIndex
	 * @return
	 */
	private int runRecursiveCases(int queryValue, int coinTypeIndex) {
		int numOfWays = 0; 
		for (int i = coinTypeIndex; i < _coinTypes.size(); i++) {
			int coinType = _coinTypes.get(i).intValue();
			int newQueryValue = queryValue - coinType;

			int firstIndex = calculateFirstIndexOfMemory(newQueryValue);
			
			if (_memory[firstIndex][i] < 0) {
				//run recursive case if it is not saved in memory before
				int curNumOfWays = calculateNumOfWaysToSplitRecursively(newQueryValue, i);
				_memory[firstIndex][i] = curNumOfWays;
				
			} else {
				//if it is inside the memory. do nothing
			}

			numOfWays += _memory[firstIndex][i];
		}
		return numOfWays;
	}


	/**
	 * calculate the first index of the _memory
	 * if the queryValue is less than 0, then set to 0, as all negative values will led to the same result: 0
	 * else firstIndex = queryValue + 1 
	 * @param queryValue
	 * @return
	 */
	private int calculateFirstIndexOfMemory(int queryValue) {
		int firstIndex;
		if (queryValue < 0) {
			firstIndex = 0;
		} else {
			firstIndex = queryValue + 1;
		}
		return firstIndex;
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
