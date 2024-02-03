package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (str.charAt(i-1) == '(') {
                        stack.pop();
                        sum += stack.size();
                    } else {
                        stack.pop();
                        sum += 1;
                    }
                }
            }
        }

        System.out.print(sum);
    }
}
