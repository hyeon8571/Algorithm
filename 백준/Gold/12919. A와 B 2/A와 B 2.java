import java.io.*;
import java.util.*;

public class Main {

    static String T, S;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.next();
        T = sc.next();

        dfs(T);

        System.out.println(result);
    }

    public static void dfs(String T) {

        if (S.length() == T.length()) {

            if (S.equals(T)) {
                result = 1;
            }

            return;
        }

        if (T.endsWith("A")) {
            dfs(T.substring(0, T.length() - 1));
        }
        // 2. T 문자열의 맨앞이 B일 경우 문자열을 뒤집고 맨 뒤의 B를 제거
        if (T.startsWith("B")) {
            dfs(new StringBuilder(T.substring(1)).reverse().toString());
        }
    }
}
