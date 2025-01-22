import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        int[] dp = new int[N+1];

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

        // Bottom up
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[N]);
    }
}
