Q2 Assignment :-

Loot Houses
Send Feedback
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
Input format :
The first line of input contains an integer value of 'n'. It is the total number of houses.

The second line of input contains 'n' integer values separated by a single space denoting the amount of money each house has.
Output format :
Print the the maximum money that can be looted.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.

Solution :-

/*
Time Complexity : O(n)
Space Complexity : O(n)
Where 'n' is the total number of houses
*/
public class Solution {
public static int maxMoneyLooted(int[] houses) {
		if(houses.length == 0) {return 0;}
		int maxAmountIndeed = Integer.MIN_VALUE;
		int[] maxLootedAmount = new int[houses.length];
		int k = maxLootedAmount.length-1;
		for(; k > maxLootedAmount.length-3; k--) {
			maxLootedAmount[k] = houses[k];
		}
		for(int i=k; i>=0; i--) {
			int j = i+2;
			int maxAmount = Integer.MIN_VALUE;
			for(; j<maxLootedAmount.length; j++) {
				int amount = houses[i] + maxLootedAmount[j];
				if(amount > maxAmount) {
					maxAmount = amount;
				}
			}
			maxLootedAmount[i] = maxAmount;
			if(maxLootedAmount[i] > maxAmountIndeed) {
				maxAmountIndeed = maxLootedAmount[i];
			}
		}
		return maxAmountIndeed;
	}
}
