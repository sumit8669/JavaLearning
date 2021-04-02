Question :-

Code: N Queens
Send Feedback
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 

Solution :-

public class Solution {
/* Your class should be named Solution.
* Don't write main() function.
* Don't read input, it is passed as function argument.
* Print output as specified in the question
*/
public static void placeNQueens(int n){
int board[][] = new int[n][n];
placeQueen(board, 0, n);
}
private static void placeQueen(int[][] board, int row, int n) {
if(row == n){
for(int i = 0; i < n; i++){
for(int j = 0; j < n; j++){
System.out.print(board[i][j] +" ");
}
}
System.out.println();
}
for(int j = 0; j < n; j++){
if(isBoardSafe(board,row, j)){
board[row][j] = 1;
placeQueen(board, row + 1, n);
board[row][j] = 0;
}
}
}
private static boolean isBoardSafe(int board[][], int row, int col ) {
int n = board.length;
for(int i = row - 1, j = col - 1 ; i >= 0 && j >= 0; i--,j--){
if(board[i][j] == 1){
return false;
}
}
for(int i = row + 1, j = col + 1 ; i < n && j < n ; i++,j++){
if(board[i][j] == 1){
return false;
}
}
for(int i = row - 1, j = col + 1 ; i >= 0 && j < n; i--,j++){
if(board[i][j] == 1){
return false;
}
}
for(int i = row + 1, j = col - 1 ; i < n && j >= 0; i++,j--){
if(board[i][j] == 1){
return false;
}
}
for(int i = row -1; i >= 0; i--){
if(board[i][col] == 1){
return false;
}
}
for(int i = row +1; i < n; i++){
if(board[i][col] == 1){
return false;
}
}
return true;
}
}