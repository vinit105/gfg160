//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

// Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Examples:

// Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
// Output: [[1,3], [4,7], [8,10]]
// Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
// Output: [[1,2], [3,10], [12,16]]
// Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].
// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
         ArrayList<int[]> result = new ArrayList<>();
        int i = 0; int n = intervals.length;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }
}
