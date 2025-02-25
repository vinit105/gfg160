public class HistogramRectangularArea {
    
}
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        Stack<Integer> stack = new Stack<>();
        int n = arr.length, res=0;
        for(int i =0 ; i <=  n; i++){
            while(!stack.isEmpty() && (i == n  || arr[stack.peek()] >= arr[i])){
                int x = arr[stack.pop()];
                int y = stack.isEmpty()? i : i-stack.peek() -1;
                res = Math.max(res, x * y);
            }
            stack.push(i);
        }
        return res;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends