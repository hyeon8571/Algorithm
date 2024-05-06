import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Place {
        int y, x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;

    static int K;

    static int[][] grid;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int result;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            K = Integer.parseInt(st.nextToken());

            grid = new int[N][N];

            result = 0;

            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == max) {
                        visited = new boolean[N][N];
                        visited[i][j] = true;
                        dfs(i, j, false, 1);
                    }
                }
            }

            System.out.println("#" + t + " " + result);

        }
    }

    public static void dfs(int startY, int startX, boolean flag, int cnt) {

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N  && !visited[ny][nx]) {
                if (grid[ny][nx] < grid[startY][startX]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx, flag, cnt + 1);
                    visited[ny][nx] = false;
                } else {
                    if (grid[ny][nx] - K < grid[startY][startX] && !flag) {

                        int tmp = grid[ny][nx];
                        grid[ny][nx] = grid[startY][startX] - 1;
                        visited[ny][nx] = true;
                        dfs(ny, nx, true, cnt + 1);
                        grid[ny][nx] = tmp;
                        visited[ny][nx] = false;

                    } else {
                        if (cnt > result) {
                            result = cnt;

                        }
                    }
                }
            }


        }

    }

}
