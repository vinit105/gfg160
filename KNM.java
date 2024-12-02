
//KNM Algo .... Search Pattern...
/*
 * 
 * Input: txt = "abcab", pat = "ab"
Output: [0, 3]
Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 

Input: txt = "abesdu", pat = "edu"
Output: []
Explanation: There's no substring "edu" present in txt.
 */

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lps[] = new int[pat.length()];
        longest(pat, lps);
        int j=0;
        int count = 0;
        int i=0;
        while(i<txt.length()){
            if(pat.charAt(j)== txt.charAt(i)){
                j++;
                i++;
            }
            if(j==pat.length()){
                count ++;
                result.add(i-j);
                j = lps[j-1];
            } 
            else if(i < txt.length() && pat.charAt(j) != txt.charAt(i)){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i = i+1;
                }
                
            }
        }
        return result; 
    }
    void longest(String pat, int [] lps){
        int n = pat.length();
        int len =0;
        int i =1;
        while (i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len !=0){
                    len = lps[len-1];
                    
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
}