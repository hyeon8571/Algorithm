import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int idx = 0;

        for (int i = 1; i <= N; i++) {
           stack.push(i);
           sb.append("+\n");

           while (!stack.isEmpty() && stack.peek() == arr[idx]) {
               stack.pop();
               sb.append("-\n");
               idx++;
           }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }

    }
}
