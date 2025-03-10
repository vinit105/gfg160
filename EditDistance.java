public class EditDistance {
    
}
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int n = s1.length(), m = s2.length();
        int[] last = new int[m+1], curr = new int[m+1];
        for(int i =0; i<= m; i++) last[i] = i;
        for(int i =1; i<= n; i++){
            curr[0] = i;
            for(int j = 1; j<= m; j++){
                curr[j] = s1.charAt(i-1)== s2.charAt(j-1) ? last[j-1]:1+ Math.min(last[j-1],Math.min(last[j], curr[j-1]));
                
            }
            int [] temp = last;
            last = curr;
            curr = temp;
        }
        return last[m];
    }
}