public class SortZeroOneTwo {
    
}

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int countOne =0;
        int countTwo =0;
        int countZero =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                countZero++;
            }
            else if(arr[i]== 1){
                countOne ++;
            }
            else{
                countTwo++;
            }
        }
        for(int i=0; i<countZero; i++){
            arr[i] = 0;
        }
        for(int i= countZero; i<countOne+countZero; i++){
            arr[i] = 1;
        }
        for(int i= countOne+countZero ; i< arr.length; i++){
            arr[i] = 2;
        }
        // code here
    }
}