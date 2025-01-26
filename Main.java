public class TripletSumArray {
    
}
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length, res =0;
        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n -1;
            while(left < right){
                int sum = arr[i] + arr[left]+ arr[right];
                if(sum < target){
                    left ++;
                }
                else if (sum > target){
                    right --;
                }
                else {
                     if(arr[left] == arr[right]){
                        int count = right - left + 1;
                        res = res + count * (count-1)/2;
                        break;
                    }
                    else {
                        int countOne =1, countTwo = 1;
                        while(left +1< right && arr[left]==arr[left +1]){
                            left ++;
                            countOne ++;
                        }
                        while(right -1 > left && arr[right]== arr[right -1]){
                            right --;
                            countTwo++;
                        }
                        res = res + countOne * countTwo;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}