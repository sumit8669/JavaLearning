Question :-

Pair Sum to 0
Send Feedback
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2

Solution :-

/*
Time Complexity: O(n)
Space Complexity: O(n)
where n is the size of input array
*/
import java.util.*;
public class Solution {
public static int PairSum(int[] input, int size) {
HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
int finalCount=0;
for(int i=0; i<size; i++)
{
int key = input[i];
if(h.containsKey(key))
{
int value = h.get(key);
h.put(key, value+1); //incrementing frequency value by 1 if key is
already present in hashmap
}
else
{
h.put(key, 1); //initializing frequency value to 1 if key is not
already present in hashmap
}
}
//traversing the array and checking if -key is present in hashmap
for(int i=0; i < size; i++)
{
int key = input[i];
if(h.containsKey(-key) && h.get(key)!=0)
{
int times;
if (key == (-key)) { //True in case of zero
int occurences = h.get(key);
times = (occurences * (occurences - 1)) / 2;
finalCount = finalCount+times;
h.put(key, 0);
continue;
}
times = h.get(key) * h.get(-key);
finalCount = finalCount+times;
h.put(key, 0);
h.put(-key, 0);
}
}
return finalCount;
}
}