Q3 Assignment :-

Level order traversal
Send Feedback
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.
Example:
alt txt

For the above-depicted tree, when printed in a level order fashion, the output would look like:

10
20 30 
40 50 60
Where each new line denotes the level in the tree.
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8 
3 10 
1 6 14 
4 7 13 

Solution :-

/*
Time complexity: O(N)
Space complexity: O(N)
where N is the number of nodes in the input tree
*/
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
public static void printLevelWise(BinaryTreeNode<Integer> root) {
Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
pendingNodes.add(root);
pendingNodes.add(null);
while(!pendingNodes.isEmpty()) {
BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
if (frontNode == null) {
System.out.println();
if (!pendingNodes.isEmpty()) {
pendingNodes.add(null);
}
} else {
System.out.print(frontNode.data + " ");
if (frontNode.left != null) {
pendingNodes.add(frontNode.left);
}
if (frontNode.right != null) {
pendingNodes.add(frontNode.right);
}
}
}
}
}