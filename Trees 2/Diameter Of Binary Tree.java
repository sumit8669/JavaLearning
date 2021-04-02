question :-

Diameter Of Binary Tree
Send Feedback
For a given Binary of type integer, find and return the ‘Diameter’.
Diameter of a Tree
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.
Example:
alt txt

The maximum distance can be seen between the leaf nodes 8 and 9. 
The distance is 9 as there are a total of nine nodes along the longest path from 8 to 9(inclusive of both). Hence the diameter according to the definition will be 9.
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints an integer, representing the diameter of the tree.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
Sample Output 1:
9
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
5

solution:-

/*
Time complexity: O(N)
Space complexity: O(H)
where N is the number of nodes in the input tree
and H is the height of the input tree
*/
class Pair {
int diameter;
int height;
public Pair(int diameter, int height) {
this.diameter = diameter;
this.height = height;
}
}
public class Solution {
private static Pair diameterHelper(BinaryTreeNode<Integer> root) {
if(root == null) {
Pair pair = new Pair(0, 0);
return pair;
}
Pair leftPair = diameterHelper(root.left);
Pair rightPair = diameterHelper(root.right);
int leftDiameter = leftPair.diameter;
int rightDiameter = rightPair.diameter;
/*
'dist' denotes the longest distance between
deepest node of the left subtree and
deepest node of the right subtree
*/
int dist = leftPair.height + rightPair.height + 1;
int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
int height = Math.max(leftPair.height,rightPair.height) + 1;
return (new Pair(diameter, height));
}
public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
Pair pair = diameterHelper(root);
return pair.diameter;
}
}