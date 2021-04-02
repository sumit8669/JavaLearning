Q3 Assignment :-

Pair sum in a BST
Send Feedback
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).
Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of S.
Output format:
You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7



solution :-

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input BST
and H is the height of the input BST
*/
import java.util.Stack;
public class Solution {
public static int countNodes(BinaryTreeNode<Integer> root) {
if (root == null) {
return 0;
}
return countNodes(root.left) + countNodes(root.right) + 1;
}
public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
if (root == null) {
return;
}
int totalCount = countNodes(root);
int count = 0;
Stack<BinaryTreeNode<Integer>> inorder = new Stack<BinaryTreeNode<Integer>>();
Stack<BinaryTreeNode<Integer>> revInorder = new Stack<BinaryTreeNode<Integer>>();
BinaryTreeNode<Integer> temp = root;
while (temp != null) {
inorder.push(temp);
temp = temp.left;
}
temp = root;
while (temp != null) {
revInorder.push(temp);
temp = temp.right;
}
while (count < totalCount - 1) {
BinaryTreeNode<Integer> top1 = inorder.peek();
BinaryTreeNode<Integer> top2 = revInorder.peek();
if (top1.data + top2.data == s) {
System.out.println(top1.data + " " + top2.data);
BinaryTreeNode<Integer> top = top1;
inorder.pop();
count++;
if (top.right != null) {
top = top.right;
while (top != null) {
inorder.push(top);
top = top.left;
}
}
top = top2;
revInorder.pop();
count++;
if (top.left != null) {
top = top.left;
while (top != null) {
revInorder.push(top);
top = top.right;
}
}
} else if (top1.data + top2.data > s) {
BinaryTreeNode<Integer> top = top2;
revInorder.pop();
count++;
if (top.left != null) {
top = top.left;
while (top != null) {
revInorder.push(top);
top = top.right;
}
}
} else {
BinaryTreeNode<Integer> top = top1;
inorder.pop();
count++;
if (top.right != null) {
top = top.right;
while (top != null) {
inorder.push(top);
top = top.left;
}
}
}
}
}
}