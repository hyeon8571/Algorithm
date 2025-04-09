
import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int n, m;
    static int[][] grid;
    static int[] items;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 거리 범위 내면 이동 가능
        int r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        grid = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            grid[from][to] = distance;
            grid[to][from] = distance;
        }

        for (int i = 1; i <= n; i++) {
            cnt = items[i];
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int start, int distance) {

        if (cnt > result) {
            result = cnt;
        }

        for (int i = 1; i <= n; i++) {
            if (grid[start][i] != 0) {
                if (distance + grid[start][i] <= m) {
                    if (!visited[i]) {
                        cnt += items[i];
                        visited[i] = true;
                    }
                    dfs(i, distance + grid[start][i]);
                    //visited[i] = false;
                }
                //visited[i] = false;
            }
        }
    }
}
