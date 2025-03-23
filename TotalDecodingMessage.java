public class TotalDecodingMessage {
    
}
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        // code here
        if(digits.charAt(0)=='0') return 0;
        int prev2 = 1; 
        int prev1 = 1;
        for(int i = 1 ; i< digits.length(); i++){
            int curr = (digits.charAt(i) != '0') ? prev1: 0;
            if(digits.charAt(i-1) != '0' && Integer.parseInt(digits.substring(i-1,i+1)) <= 26){
                curr += prev2;
            }
            prev2 = prev1;
            prev1  = curr;
        }
        return prev1;
    }
}