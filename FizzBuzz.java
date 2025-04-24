public class FizzBuzz {
    
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class StringArray {
    public static String[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.fizzBuzz(n);

            StringArray.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<String> fizzBuzz(int n) {
        // code here
        ArrayList<String> result = new ArrayList<>(n);
        for(int i =1; i<=n ; i++){
            StringBuilder c = new StringBuilder();
            if(i % 3 ==0) c.append("Fizz");
            if(i %5 ==0) c.append("Buzz");
            if(c.length() == 0) c.append(i);
            result.add(c.toString());
        }
        return result;
    }
}
