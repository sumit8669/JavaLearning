Qusetion-

Merge Sort LL
Send Feedback
 Given a singly linked list of integers, sort it using 'Merge Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 

Solution:-

/*
Time Complexity : O(n * log n)
Space Complexity : O(log n)
Where 'n' is size of the Singly Linked List
*/
public class Solution {
private static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
if (head == null) {
return head;
}
LinkedListNode<Integer> slow = head;
LinkedListNode<Integer> fast = head;
while (fast.next != null && fast.next.next != null) {
slow = slow.next;
fast = fast.next.next;
}
return slow;
}
private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1,
LinkedListNode<Integer> head2) {
if (head1 == null) {
return head2;
}
if (head2 == null) {
return head1;
}
LinkedListNode<Integer> newHead = null, newTail = null;
if (head1.data < head2.data) {
newHead = head1;
newTail = head1;
head1 = head1.next;
} else {
newHead = head2;
newTail = head2;
head2 = head2.next;
}
while (head1 != null && head2 != null) {
if (head1.data < head2.data) {
newTail.next = head1;
newTail = newTail.next;
head1 = head1.next;
} else {
newTail.next = head2;
newTail = newTail.next;
head2 = head2.next;
}
}
if (head1 != null) {
newTail.next = head1;
}
if (head2 != null) {
1/17/2021 Coding Ninjas
https://classroom.codingninjas.com/app/classroom/me/5164/content/67496/offering/740631/problem/17 2/2
newTail.next = head2;
}
return newHead;
}
public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
if (head == null || head.next == null) {
return head;
}
LinkedListNode<Integer> mid = findMid(head);
LinkedListNode<Integer> half1 = head;
LinkedListNode<Integer> half2 = mid.next;
mid.next = null;
half1 = mergeSort(half1);
half2 = mergeSort(half2);
LinkedListNode<Integer> finalHead = merge(half1, half2);
return finalHead;
}
}