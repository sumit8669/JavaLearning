Q2 Assignment :-

Largest BST
Send Feedback
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2

Solution :-

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input BST
and H is the height of the input BST
*/
class bstSubtreeReturn {
int max;
int min;
int height;
boolean isBST;
}
public class Solution {
public static bstSubtreeReturn largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
if (root == null) {
bstSubtreeReturn ans = new bstSubtreeReturn();
ans.max = Integer.MIN_VALUE;
ans.min = Integer.MAX_VALUE;
ans.isBST = true;
ans.height = 0;
return ans;
}
bstSubtreeReturn left = largestBSTSubtreeHelper(root.left);
bstSubtreeReturn right = largestBSTSubtreeHelper(root.right);
if (!(right.isBST && right.min > root.data)) {
right.isBST = false;
}
if (!(left.isBST && left.max < root.data)) {
left.isBST = false;
}
bstSubtreeReturn ans = new bstSubtreeReturn();
if (!left.isBST || !right.isBST || root.data < left.max || root.data > right.min)
{
if (left.height > right.height) {
left.isBST = false;
return left;
} else {
right.isBST = false;
return right;
}
}
ans.isBST = true;
ans.min = Math.min(left.min, Math.min(right.min, root.data));
ans.max = Math.max(left.max, Math.max(right.max, root.data));
ans.height = Math.max(left.height, right.height) + 1;
return ans;
}
public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
return largestBSTSubtreeHelper(root).height;
}
}