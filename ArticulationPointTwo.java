public class ArticulationPointTwo {
    
}
//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        
        List<Integer>[] graph = new ArrayList[V];
        for(int i  =0; i< V;i++) graph[i] = new ArrayList<>();
        for(int [] edge: edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP= new boolean[V];
        int[] time = {0};
        
        for(int i = 0; i< V; i++){
            if(!visited[i]){
                dfs(i, -1, graph, visited, disc, low , isAP, time);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< V; i++){
            if(isAP[i]){
                result.add(i);
            }
        }
        if(result.isEmpty()) result.add(-1);
        return result;
    }
    static void dfs(int u, int parent, List<Integer>[] graph, boolean[] visited,int[] disc,int[] low,boolean[] isAP, int[] time ){
        visited[u]= true;
        disc[u] = low[u] = ++time[0];
        int children = 0;
        for(int v: graph[u]){
            if(!visited[v]){
                children++;
                dfs(v, u, graph, visited, disc, low, isAP, time);
                low[u] = Math.min(low[u], low[v]);
                
                if(parent != -1 && low[v] >= disc[u]){
                    isAP[u] = true;
                }
            }
            else if(v != parent){
                low[u] = Math.min(low[u],disc[v]);
            }
        }
        if(parent == -1 && children> 1){
            isAP[u] = true;
        }
    }
}