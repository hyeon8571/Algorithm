import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                int k = Integer.parseInt(st.nextToken());

                if (i == 1) {
                    dp[i][j] = k;
                    continue;
                }

                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + k;
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + k;
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[n][i] > result) {
                result = dp[n][i];
            }
        }

        System.out.println(result);
    }
}
