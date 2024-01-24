package boj.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();

            Stack<Character> left = new Stack<>();

            Stack<Character> right = new Stack<>();
            for (int j = 0; j < str.length; j++) {
                if (str[j] == '<') {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                } else if (str[j] == '>') {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                } else if (str[j] == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.add(str[j]);
                }
            }
            for (int j = 0; j < left.size(); j++) {
                sb.append(left.get(j));
            }
            for (int j = right.size() - 1; j >= 0; j--) {
                sb.append(right.get(j));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
