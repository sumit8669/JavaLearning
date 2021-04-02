Q4 Assignment :-

Return Permutations of a String
Send Feedback
Given a string, find and return all the possible permutations of the input string.
Note : The order of permutations are not important.
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
public static String[] permutationOfString(String input){
if(input.length() == 0){
String output[] = {""};
return output;
}
String[] smallerOutput = permutationOfString(input.substring(1));
String output[] = new String[input.length()*smallerOutput.length];
int k =0;
for(int i = 0; i < smallerOutput.length; i++){
String currentString = smallerOutput[i];
for(int j = 0; j <= currentString.length(); j++){
output[k] = currentString.substring(0, j) + input.charAt(0) +
currentString.substring(j);
k++;
}
}
return output;
}
}