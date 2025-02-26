public class MaximumMinimumWindowSize {
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        int [] result = new int[n],len =new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i<= n ; i++){
            while(!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])){
                int j= stack.pop();
                len[j] = stack.isEmpty() ? i : i-stack.peek()-1;
            }
            if(i< n ){
                stack.push(i);
            }
            
        }
        for(int i =0; i< n;i++) result[len[i]-1] = Math.max(result[len[i] -1], arr[i]);
        for(int i =n-2; i>=0; i--)result[i] = Math.max(result[i], result[i+1]);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: result) ans.add(i);
        return ans;
    }
}