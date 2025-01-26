public class TrappingRainWater {
    
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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int l = 0, r = arr.length-1,res=0,leftMax=0, rightMax=0;
        while(l<r){
            if(arr[l]<arr[r]){
                if(leftMax> arr[l]){
                    leftMax =leftMax;
                }else{
                    leftMax = arr[l];
                }
                res = res + leftMax - arr[l];
                l++;
            }
            else{
                if(rightMax > arr[r]){
                    rightMax= rightMax;
                }
                else{
                    rightMax = arr[r];
                }
                res = res + rightMax - arr[r];
                r--;
            }
        }
        return res;
    }
}
