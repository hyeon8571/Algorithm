import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int be = Integer.parseInt(st.nextToken());
            int af = Integer.parseInt(st.nextToken());
            sb.append(dp[af] - dp[be-1]).append("\n");
        }

        System.out.println(sb);

    }
}
