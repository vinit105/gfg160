public class AccountMerger {
    
}
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        while (T-- > 0) {
            int n = sc.nextInt(); // Number of accounts
            ArrayList<ArrayList<String>> accounts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // Number of emails + name
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    temp.add(sc.next()); // Read name/emails
                }
                accounts.add(temp);
            }

            // Calling the accountsMerge function
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> res = obj.accountsMerge(accounts);

            // Sorting individual accounts' emails
            for (int i = 0; i < res.size(); i++) {
                Collections.sort(res.get(i));
            }

            // Sorting the entire list exactly like C++'s sort(res.begin(), res.end());
            Collections.sort(res, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> a, ArrayList<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        int cmp = a.get(i).compareTo(b.get(i));
                        if (cmp < 0) return -1;
                        if (cmp > 0) return 1;
                    }
                    if (al < bl) return -1;
                    if (al > bl) return 1;
                    return -1; // Exact match with C++ behavior
                }
            });

            // Printing the output in the required format
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1) {
                        System.out.print(res.get(i).get(j) + ", ");
                    } else {
                        System.out.print(res.get(i).get(j));
                    }
                }
                if (i != res.size() - 1) {
                    System.out.println("], ");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(
        ArrayList<ArrayList<String>> accounts) {
        // code here
        Map<String, String> email = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for(ArrayList<String> acc: accounts)
          for(int i =1; i< acc.size(); i++)  {
                parent.putIfAbsent(acc.get(i), acc.get(i));
                email.put(acc.get(i), acc.get(0));
                parent.put(find(acc.get(i), parent), find(acc.get(1), parent));
            }
        Map<String, TreeSet<String>> u = new HashMap<>();
        for(String e : parent.keySet()){
            u.computeIfAbsent(find(e, parent), k -> new TreeSet<>()).add(e);
            
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(String r : u.keySet()){
            ArrayList<String> m = new ArrayList<>();
            m.add(email.get(r));
            m.addAll(u.get(r));
            res.add(m);
        }
        return res;
    }
    static String find(String s, Map<String, String> p){
        if(!s.equals(p.get(s)))p.put(s,find(p.get(s), p));
        return p.get(s);
    }
}
