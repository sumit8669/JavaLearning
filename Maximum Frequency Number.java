Question :-
Maximum Frequency Number
Send Feedback
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains most frequent element in the given array.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
3
1 4 5
Sample Output 2 :
1


Solution :-

/*
Time Complexity: O(n)
Space Complexity: O(n)
where n is the size of input array
*/
import java.util.HashMap;
public class Solution {
public static int maxFrequencyNumber(int[] arr){
/* Your class should be named Solution
* Don't write main().
* Don't read input, it is passed as function argument.
* Return output and don't print it.
* Taking input and printing output is handled automatically.
*/
HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
for(int i : arr) {
// if(hm.containsKey(i)) {
// hm.put(i, hm.get(i) + 1); }
// else {
// hm.put(i, 1);
// }
hm.put(i, hm.getOrDefault(i, 0) + 1);
}
int max = 0, ans = Integer.MIN_VALUE;
for(int i : arr) {
if(hm.get(i) > max) {
max = hm.get(i);
ans = i;
}
}
return ans;
}
}