Q2 Assignments :-

Kth largest element
Send Feedback
Given an array A of random integers and an integer k, find and return the kth largest element in the array.
Note: Try to do this question in less than O(N * logN) time.
Input Format :
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following contains an integer, that denotes the value of k.
Output Format :
The first and only line of output contains the kth largest element
Constraints :
1 <= N, Ai, k <= 10^5
Time Limit: 1 sec
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10

Solution :-

import java.util.PriorityQueue;
/*
Time complexity: O(N * log(K))
Space complexity: O(K)
where N is the size of the input array
and K is the number of largest element that is to be found
*/
public class Solution {
public static int kthLargest(int n, int[] input, int k) {
// Making a min PQ
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//The size of PQ will be k
for (int i = 0; i < k; i++) {
minHeap.add(input[i]);
}
for (int i = k; i < n; i++) {
if (input[i] > minHeap.peek()) {
minHeap.poll();
minHeap.add(input[i]);
}
}
return minHeap.peek();
}
}