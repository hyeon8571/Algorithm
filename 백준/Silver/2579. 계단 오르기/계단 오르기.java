import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp;
    static int[] stairs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];
        dp = new Integer[N+1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N < 2) {
            System.out.println(stairs[1]);
            return;
        } else if (N < 3) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        } else if (N == 3) {
            System.out.println(Math.max(stairs[1], stairs[2]) + stairs[3]);
            return;
        }

        // top down
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[2], stairs[1]) + stairs[3];

        System.out.println(find(N));

    }

    public static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n-2) + stairs[n], find(n-3) + stairs[n-1] + stairs[n]);
        }

        return dp[n];
    }
}
