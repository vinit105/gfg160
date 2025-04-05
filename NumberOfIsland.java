public class NumberOfIsland {
    
}
//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length , m = grid[0].length, ans =0;
        for(int i =0; i< n;i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == 'L'){
                    ans++;
                    dfs(grid, i,j,n,m);
                }
            }
        }
        return ans;
    }
    void dfs(char[][] g, int i, int j , int n, int m){
        if(i< 0|| j<0 || i>=n || j>=m || g[i][j] == 'W') return;
        g[i][j] =  'W';
        for(int a = -1; a <=1; a++){
            for(int b = -1; b<=1; b++){
                dfs(g, i+a, j+b, n, m);
            }
        }
    }
}