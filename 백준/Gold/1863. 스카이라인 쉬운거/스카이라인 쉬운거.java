import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }
            
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            
            stack.push(y);
        
            
        }
        
        while (!stack.isEmpty()) {
            
            if (stack.peek() > 0) {
                cnt++;
            }
            
            stack.pop();
        }
        
        System.out.println(cnt);

        
    }
}
