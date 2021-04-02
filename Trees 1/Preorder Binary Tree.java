question:-

Preorder Binary Tree
Send Feedback
For a given Binary Tree of integers, print the pre-order traversal.
Input Format:
The first and the only line of input will contain the nodes data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints the pre-order traversal of the given binary tree.
Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
 Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Ouptut 1:
5 6 2 3 9 10 
 Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Ouptut 2:
1 2 4 5 3 6 7 

solution:-

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input tree
and H is the height of the input tree
*/
public class Solution {
public static void preOrder(BinaryTreeNode<Integer> root) {
if (root == null) {
return;
}
System.out.print(root.data + " ");
preOrder(root.left);
preOrder(root.right);
}
}