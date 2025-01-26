public class AllocateMinimumPages {
    
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
         int n = arr.length;
        if (n < k) {
            return -1;
        }

        int maxBook = 0, totalPages = 0;
        for (int pages : arr) {
            maxBook = Math.max(maxBook, pages);
            totalPages += pages;
        }

        int low = maxBook, high = totalPages;
        int result = high; // Initialize result to the largest possible value

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                // Try for a smaller maximum
                result = mid;
                high = mid - 1;
            } else {
                // Increase the maximum limit
                low = mid + 1;
            }
        }

        return result;
    }
    private static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int students = 1; // Start with one student
        int currentPages = 0;

        for (int pages : arr) {
            if (pages > maxPages) {
                return false;
            }

            if (currentPages + pages > maxPages) {
                // Allocate to a new student
                students++;
                currentPages = pages;
                if (students > k) {
                    return false;
                }
            } else {
                currentPages += pages;
            }
        }

        return true;
    }
}
