import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];

        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) { // 처음 집 색 선택
            dp[0][0] = 100000;
            dp[0][1] = 100000;
            dp[0][2] = 100000;

            dp[0][i] = cost[0][i];

            int temp = cost[n-1][i];
            cost[n-1][i] = 1000000;

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
            }

            for (int k = 0; k < 3; k++) {
                result = Math.min(result, dp[n-1][k]);
            }

            cost[n-1][i] = temp;

        }

        System.out.println(result);

    }
}
