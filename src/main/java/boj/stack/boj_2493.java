package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = 0;

        for (int i = 0; i < n; i++) {
            height = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                result.add(0);
                stack.push(height);
            } else if (height < stack.peek()){
                result.add(stack.size());
                stack.push(height);
            } else {
                int idx = stack.size() - 1;
                while (height < stack.get(idx)) {
                    idx--;
                    if (idx < 1) {
                        result.add(0);
                        stack.push(height);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
