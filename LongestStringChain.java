public class LongestStringChain {
    
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words,Comparator.comparingInt(String:: length));
        Map<String,Integer> map = new HashMap<>();
        int res = 1;
        for(String w: words){
            map.put(w,1);
            for(int i =0; i<w.length(); i++){
                String pre = w.substring(0,i) + w.substring(i+1);
                map.put(w, Math.max(map.get(w), map.getOrDefault(pre,0)+1));
            }
            res = Math.max(res,map.get(w));
        }
        return res;
    }
}