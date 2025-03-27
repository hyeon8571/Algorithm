import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static int[][] dp;
    static int result = 0;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 위치에서 DFS 수행하여 최대 이동 거리 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }

    public static int dfs(int y, int x) {
        // 이미 방문한 곳이면 저장된 값 반환
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        dp[y][x] = 1; // 최소한 자기 자신 포함
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                if (grid[y][x] < grid[ny][nx]) {
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
                }
            }
        }

        return dp[y][x];
    }
}
