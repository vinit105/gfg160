public class RottenOrange {
    
}
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length, m = mat[0].length, f = 0, t= 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i, j});
                
                }
                else if(mat[i][j] == 1){
                    f++;
                }
            }
        }
        if(f==0) return 0;
        int [][] d = {{1,0}, {-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size= q.size();
            boolean ch = false;
            for(int k =0; k< size; k++){
                int[] p = q.poll();
                int i =p[0], j = p[1];
                for(int [] dir: d){
                    int x = i+ dir[0], y  = j+dir[1];
                    if(x < 0 || y < 0|| x>= n || y>= m || mat[x][y] !=1 ){
                        continue;
                    }
                    mat[x][y]= 2;
                    q.add(new int [] {x,y});
                    f--;
                    ch = true;
                }
            }
            if(ch ) t++;
        }
        return f==0? t: -1;
    }
}