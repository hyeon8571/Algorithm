import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = Integer.parseInt(st.nextToken());
                max = dp[1];
                continue;
            }

            int k = Integer.parseInt(st.nextToken());

            if (k > 0) {
                if (dp[i-1] > 0) {
                    dp[i] = dp[i-1] + k;
                } else {
                    dp[i] = k;
                }
            } else {
                if (dp[i-1] + k > 0) {
                    dp[i] = dp[i-1] + k;
                } else {
                    dp[i] = k;
                }

            }

            if (dp[i] > max) {
                max = dp[i];
            }

        }

        System.out.println(max);

    }
}
