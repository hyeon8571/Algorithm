package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(')');
                    }
                } else if(str.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.add(']');
                    }
                } else if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.add(str.charAt(i));
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }

        }

        System.out.print(sb);
    }
}