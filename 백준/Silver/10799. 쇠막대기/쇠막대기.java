import java.util.*;
import java.io.*;

public class Main {

    static class Iron {
        int idx;
        char m;

        public Iron(int idx, char m) {
            this.idx = idx;
            this.m = m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Iron> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.add(new Iron(i, c));
            } else {

                if (c == ')') { // 새로 들어올 문자
                    if (stack.peek().m == '(') {
                        if (stack.peek().idx + 1 == i) {
                            stack.pop();
                            result += stack.size();
                        } else {
                            stack.pop();
                            result += 1;
                        }
                    }
                } else {
                    stack.add(new Iron(i, c));
                }

            }
        }
        System.out.println(result);
    }
}
