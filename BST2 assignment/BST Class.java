Question :-

BST Class
Send Feedback
Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BST or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
wherer, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.


Solution :-

public class BinarySearchTree {
private BinaryTreeNode<Integer> root;
/*
* Time complexity: O(H) [for all operations]
* Space complexity: O(N)
* where N is the number of nodes in the input BST
* and H is the height of the input BST
*/
public void insert(int data) {
root = insert(data, root);
}
private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
if (root == null) {
BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
return newNode;
}
if (root.data >= data) {
root.left = insert(data, root.left);
}
else {
root.right = insert(data, root.right);
}
return root;
}
public void remove(int data) {
root = remove(data, root);
}
private BinaryTreeNode<Integer> remove(int data, BinaryTreeNode<Integer> root) {
if (root == null) {
return null;
}
if (data < root.data) {
root.left = remove(data, root.left);
return root;
}
else if (data > root.data) {
root.right = remove(data, root.right);
return root;
}
else {
if (root.left == null && root.right == null) {
return null;
}
else if (root.left == null) {
return root.right;
}
else if (root.right == null) {
return root.left;
}
else {
BinaryTreeNode<Integer> minNode = root.right;
while (minNode.left != null) {
minNode = minNode.left;
}
root.data = minNode.data;
root.right = remove(minNode.data, root.right);
return root;
}
}
}
public void printTree() {
printTree(root);
}
private void printTree(BinaryTreeNode<Integer> root) {
if (root == null) {
return;
}
System.out.print(root.data + ":");
if (root.left != null) {
System.out.print("L:" + root.left.data + ",");
}
if (root.right != null) {
System.out.print("R:" + root.right.data);
}
System.out.println();
printTree(root.left);
printTree(root.right);
}
public boolean search(int data) {
return search(data, root);
}
private boolean search(int data, BinaryTreeNode<Integer> root) {
if (root == null) {
return false;
}
if (root.data == data) {
return true;
}
else if (data > root.data) {
return search(data, root.right);
}
else {
return search(data, root.left);
}
}
}