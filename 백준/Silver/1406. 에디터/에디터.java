import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            if (cmd.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (cmd.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                String sr = st.nextToken();
                left.push(sr.charAt(0));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
        
    }
}
