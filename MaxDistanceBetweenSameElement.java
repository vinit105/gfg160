//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends

class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer,Integer> firstMap = new HashMap<>();
        int max =0;
        for(int i = 0; i< arr.length; i++){
            int curr = arr[i];
            if(!firstMap.containsKey(curr)){
                firstMap.put(curr,i);
            }else{
                int dis = i - firstMap.get(curr);
                max  = Math.max(max,dis);
            }
        }
        return max;
        
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends
