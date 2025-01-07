import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (!stack.isEmpty()) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                } else {
                    stack.add(c);
                }

            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);
    }
}
