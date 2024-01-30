package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] result = new int[n];

        //int[] height = new int[n];

        List<Integer> height = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            height.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() < height.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(height.get(i));
                result[i] = 0;
            } else if (stack.peek() > height.get(i)) {
                int loc = height.indexOf(stack.peek());
                result[i] = loc + 1;
                stack.push(height.get(i));
            }

        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.print(sb);
    }
}
