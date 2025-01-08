import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int value = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.add(c);
                value *= 2;
                continue;
            }

            if (c == '[') {
                stack.add(c);
                value *= 3;
                continue;
            }

            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if (str.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
                continue;
            }

            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if (str.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
