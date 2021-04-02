MERGE TWO SINGLY LIST

Level MEDIUM
Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).
Try solving without reverse, with O(1) auxiliary space (in-place) and only one traversal of both lists. You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list 1 elements of length n (separated by space and terminated by -1)
Line 2 : Linked list 2 elements of length m (separated by space and terminated by -1)
Output format :
Merged list elements (separated by space)
Constraints :
1 <= n, m <= 10^4
Sample Input :
 2 5 8 12 -1
 3 6 9 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of 1st linked list is 4 and that of 2nd linked list is 3.
Sample Output :
 12 9 8 6 5 3 2 
 
 
 SOLUTION:-
 
 import java.util.Scanner;

class ListNode<T>{
	T data;
	ListNode<Integer> next;
	ListNode(T data){
		this.data = data;
	} 
}
public class MergeTwoLinkedList {
	public static ListNode<Integer> printReverse(ListNode<Integer> root) {
		ListNode<Integer> temp = root;
		ListNode<Integer> past = null;
		ListNode<Integer> future = temp.next;
		while(temp.next != null) {
			future = temp.next;
			temp.next = past;
			past = temp;
			temp = future;
		}
		root = temp;
		root.next = past;
		return root;

	}
	public static ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
		ListNode<Integer> temp1 = printReverse(head1);//To reverse the order as given order is ascending
		ListNode<Integer> temp2 = printReverse(head2);//To reverse the order as given order is ascending
		ListNode<Integer>  past = new ListNode<Integer>(0);
		/*here we have created a new node "past" with data = 0 in it
		 * and after merging we will return past.next*/
		ListNode<Integer> currentNode = past;
		/*temporary variable to store past reference and simultaneously link the nodes*/
		while(temp1 != null && temp2 != null){
			if(temp1.data >= temp2.data) {
				currentNode.next = temp1;//it will link the past node with the present node
				currentNode = temp1;//update the current node to present node
				temp1 = temp1.next;//moving to next node for comparison
			}
			else {
				currentNode.next = temp2;//it will link the past node with the present node
				currentNode = temp2;//update the current node to present node
				temp2 = temp2.next;//moving to next node for comparison
			}
		}
		/*either temp1 or temp2 is null, and still we have some nodes left
		 *  in either temp1 or temp2. hence this connect the past Node to the remaining nodes*/
		if(temp1 == null) {
			currentNode.next = temp2;
		}
		else {
			currentNode.next = temp1;
		}
		return past.next;/*as past is the 1st noe and  has some data in it which is not the part of neither 
		temp1 nor temp2 so we will print other nodes leaving the 1st node*/
	}

	public static ListNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Elements");
		int data = s.nextInt();
		ListNode<Integer> head = null, tail = null;

		while(data != -1) {
			ListNode<Integer> currentNode = new ListNode<Integer>(data);
			if(head == null) {
				head = currentNode;
				tail = currentNode;
			}
			else {

				tail.next = currentNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(ListNode<Integer> head) {
		ListNode<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		ListNode<Integer> head1 = takeInput();
		ListNode<Integer> head2 = takeInput();
		ListNode<Integer> result = merge(head1, head2);
		print(result);

	}

}