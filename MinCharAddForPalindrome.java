public class MinCharAddForPalindrome {
    
}

// Examples:

// Input: s = "abc"
// Output: 2
// Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
// Input: s = "aacecaaaa"
// Output: 2
// Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
class Solution {
    public static int minChar(String s) {
        // Write your code here
        int n = s.length();
        String revString = new StringBuilder(s).reverse().toString();
        
        String c = s + "@" + revString;
         int []lps = new int[c.length()];
         for(int i=1; i< c.length() ; i++){
             int j = lps[i-1];
             while (j>0 && c.charAt(i) != c.charAt(j)){
                 j = lps[j-1];
             }
             if(c.charAt(i) == c.charAt(j)){
                 j++;
             }
             lps[i] = j;
         }
         return n-lps[c.length() -1];
    }
}