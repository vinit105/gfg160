public class CamelCasePatternMatching {
    
}
//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] arr = sc.nextLine().split(" ");

            String pat = sc.nextLine();

            Solution ob = new Solution();
            List<String> ans = ob.camelCase(arr, pat);
            if (ans.isEmpty()) {
                System.out.println("[]");
            } else {
                // Sort results before printing
                Collections.sort(ans);
                System.out.println(String.join(" ", ans));
            }
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public List<String> camelCase(String[] arr, String pat) {
        // code here
        List<String> res = new ArrayList<>();
        for(String word: arr){
            int j =0;
            for(int i= 0; i < word.length(); ++i){
                if(Character.isUpperCase(word.charAt(i))){
                    if(j < pat.length() && word.charAt(i) == pat.charAt(j)){
                        j++;
                        
                    }else if(j < pat.length()){
                        break;
                    }
                }
            }
            if(j == pat.length()){
                res.add(word);
            }
            
        }
        return res;
    }
}
