public class LongestCommonSubsequence {
    
}
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int[] last = new int[m+1];
        int[] present = new int[m+1];
        for(int i =1; i<= n ; i++){
            for(int j = 1; j<= m ; j++){
                present[j] = s1.charAt(i-1) == s2.charAt(j-1) ?( last[j-1]+1) : Math.max(last[j], present[j-1]);
            }
            int[] temp  = last;
            last = present;
            present = temp;
        }
        return last[m];
    }
}