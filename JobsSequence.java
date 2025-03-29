public class JobsSequence {
    
}
//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int cnt = 0; 
        int total = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<int[]> jobs = new ArrayList<>();
        
        for(int i =0; i<n; i++)jobs.add(new int[]{deadline[i], profit[i]});
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        
        for(int[] job: jobs){
            if(job[0] > q.size()) q.add(job[1]);
            else if(q.peek() < job[1]) {
                q.poll();
                q.add(job[1]);
            }
        }
        cnt = q.size();
        while(!q.isEmpty()) total += q.poll();
        
        return new  ArrayList<>(Arrays.asList(cnt, total));
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends