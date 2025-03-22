import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        int[][] dp = new int[N][M];
        int[][] tmp = new int[2][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < N; i++) {

            // 왼쪽, 위쪽 고려
            tmp[0][0] = dp[i-1][0] + grid[i][0];
            for (int j = 1; j < M; j++) {
                tmp[0][j] = Math.max(dp[i-1][j], tmp[0][j-1]) + grid[i][j];
            }

            // 오른쪽, 위쪽 고려
            tmp[1][M-1] = dp[i-1][M-1] + grid[i][M-1];
            for (int j = M-2; j >= 0; j--) {
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + grid[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }

        }

        System.out.println(dp[N-1][M-1]);

    }
}
