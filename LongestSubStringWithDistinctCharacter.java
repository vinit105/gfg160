public class LongestSubStringWithDistinctCharacter {
    
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int arr[] = new int[128];
        int max =0, start=0;
        for(int end=0; end<s.length(); end++){
            start = Math.max(start,arr[s.charAt(end)]);
            arr[s.charAt(end)] = end +1;
            max = Math.max(max,end-start+1);
        }
        return max;
    }
}