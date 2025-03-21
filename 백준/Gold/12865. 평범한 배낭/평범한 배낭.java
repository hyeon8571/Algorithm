import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N+1];
        int[] v = new int[K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) { // 무게

                int next = j - w[i];

                if (next >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][next] + v[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}