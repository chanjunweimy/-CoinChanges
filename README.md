# -CoinChanges

### Index
* [Question](README.md#question) : What is the problem that I am trying to solve?
* [Solution](README.md#solution) : What is the solution about?

### Question: 

Given the types of coins that the user have, calculate there are how many ways to split the money using the coins.

Input: 
* First line: Number of types of coins that the user have (denote as n)
* Second line: n numbers, each separated by a space and each numbers are guaranteed to be unique. These numbers are the types of coins that the user have
* Third line: Number of queries that the user would like to key in (denote as q)
* For the next q lines, each line would contain of a number which is the queryNumber (the money)

Output:
* Output the number of ways that can be split according to the queryNumber

Sample Input:
* 3
* 1 2 3
* 2
* 1
* 9

Sample Output:
* 1
* 12


Explanation: 
* For the input,
* the typesOfCoins are {1, 2, 3}

* There are 3 queries,
* For first query: 1
* there is only 1 way to split, which is 1

* for 2nd query: 9,
* there are 12 ways to split:
* 1: 1 1 1 1 1 1 1 1 1
* 2: 1 1 1 1 1 1 1 2
* 3: 1 1 1 1 1 2 2
* 4: 1 1 1 2 2 2
* 5: 1 2 2 2 2
* 6: 1 1 1 1 1 1 3
* 7: 1 1 1 3 3
* 8: 3 3 3 
* 9: 1 1 1 1 2 3
* 10: 1 1 2 2 3
* 11: 2 2 2 3
* 12: 1 2 3 3

### Solution
* The solution is given inside the [src folder](https://github.com/chanjunweimy/-CoinChanges/tree/master/src)
* The [main folder](https://github.com/chanjunweimy/-CoinChanges/tree/master/src/main) contains of the algorithm that I used to solve the problem while
* the [test folder](https://github.com/chanjunweimy/-CoinChanges/tree/master/src/test) contains of some test cases that I used to check the correctness of my algorithm
