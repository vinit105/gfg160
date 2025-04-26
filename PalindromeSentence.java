public class PalindromeSentence {
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            if (ob.sentencePalindrome(s))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean sentencePalindrome(String s) {
        // code here
        int i =0, j = s.length() -1;
        while(i < j ){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}