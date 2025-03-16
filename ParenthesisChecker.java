public class ParenthesisChecker {
    
}
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if("{[(".indexOf(c) >= 0){
                stack.push(c);
            }
            else if(stack.isEmpty() || Math.abs(stack.peek() -c )>2){
                return false;
            }
            else {
                stack.pop();
            }
        }
        return stack.isEmpty();
        
   
        
    }
}
