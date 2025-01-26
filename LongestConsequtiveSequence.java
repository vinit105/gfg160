public class LongestConsequtiveSequence {
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        // code here
        HashSet<Integer> numSet = new HashSet<>();
        for(int i: nums) numSet.add(i);
        int longest =0;
        for(int i: numSet)
          if(!numSet.contains(i-1)){
              int count =1;
              while(numSet.contains(++i))  count++;
              longest = Math.max(longest,count);
          }
          return longest;
        
    }
}