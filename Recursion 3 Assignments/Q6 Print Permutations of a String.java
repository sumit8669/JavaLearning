Q6 Assignment :-

Print Permutations of a String
Send Feedback
Given a string, find and print all the possible permutations of the input string.
Note : The order of permutations are not important. Just print them in different lines.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba


Solution :-

public class solution {
public static void permutationsHelper(String input,String output){
if(input.length()==0){
System.out.println(output);
return;
}
for(int i=0;i<input.length();i++){
permutationsHelper((input.substring(0, i) +
input.substring(i+1)),output+input.charAt(i));
}
}
public static void permutations(String input) {
permutationsHelper(input, "");
}
}