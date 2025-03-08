public class LongestPallindromeString {
    
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n = s.length(), start = 0 , max = 0;
        for(int i = 0; i< n; i++){
            for(int l : new int[]{i,i+1}){
                int j = i;
                while(j >= 0 && l < n && s.charAt(j)== s.charAt(l)){
                    j--;
                    l++;
                }
                if(l -j -1 > max){
                    start = j+ 1;
                    max = l-j-1;
                }
            }
        }
        return s.substring(start,start + max);
        
    }
}