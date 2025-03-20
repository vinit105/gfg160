public class StockBuyAndSellTwo {
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int i = Integer.MAX_VALUE,  sum = 0,i2= Integer.MAX_VALUE, sum2 =0;
        for(int a: prices){
            i = Math.min(i,a);
            sum = Math.max(sum, a - i);
            i2 = Math.min(i2,a - sum);
            sum2= Math.max(sum2, a-i2);
        }
        return sum2;
    }
}
