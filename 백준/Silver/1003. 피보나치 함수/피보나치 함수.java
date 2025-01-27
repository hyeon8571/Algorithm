import java.io.*;
import java.util.*;

public class Main {

    public static int[] check0;
    public static int[] check1;
    public static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            dp = new Integer[40+1];
            check0 = new int[41];
            check1 = new int[41];

            dp[0] = 0;
            dp[1] = 1;

            check0[0] = 1;
            check0[1] = 0;

            check1[0] = 0;
            check1[1] = 1;

            if (N == 0) {
                System.out.println(1 + " " + 0);
                continue;
            }

            if (N == 1) {
                System.out.println(0 + " " + 1);
                continue;
            }

            fibo(N);

            System.out.println(dp[N-1] + " " + dp[N]);
        }
    }

    public static int fibo(int n) {
        if (n == 0) {
            return dp[0];
        }

        if (n == 1) {
            return dp[1];
        }

        if (dp[n-1] != null && dp[n-2] != null) {
            dp[n] = dp[n-1] + dp[n-2];
            return dp[n];
        } else if (dp[n-1] == null) {
            dp[n-1] = fibo(n-1);
        } else if (dp[n-2] == null) {
            dp[n-2] = fibo(n-2);
        }

        dp[n] = dp[n-1] + dp[n-2];

        return dp[n];
    }
}
