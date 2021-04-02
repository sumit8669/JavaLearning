Question 3 - 

Pairs with difference K
Send Feedback
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.
Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K. 
Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6

Solution:-

import java.util.HashMap;
public class Solution {
/*
* Time complexity: O(N)
* Space complexity: O(N)
*
* where N is the size of the input array
*/
public static int getPairsWithDifferenceK(int arr[], int k) {
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
int pairCount = 0;
for(int i : arr){
int p1 = i + k;
boolean flag = false;
if(i == p1) {
flag = true;
}
if(map.containsKey(p1)){
pairCount += map.get(p1);
}
int p2 = i - k;
if(map.containsKey(p2) && !flag){
pairCount += map.get(p2);
}
if(map.containsKey(i)){
map.put(i, map.get(i) + 1);
}else{
map.put(i, 1);
}
}
return pairCount;
}
}