import java.io.*;
import java.util.*;

public class Main {

    public static class Place {
        int y;
        int x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static char[][] grid1;
    static boolean[][] visited1;
    static char[][] grid2;
    static boolean[][] visited2;

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid1 = new char[N][N];
        grid2 = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                grid1[i][j] = c;

                if (c == 'R') {
                    grid2[i][j] = 'G';
                } else {
                    grid2[i][j] = c;
                }
            }
        }

        int result1 = 0;
        int result2 = 0;

        // 적록색약이 아닌 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    visited1[i][j] = true;
                    bfs(i, j, grid1, visited1);
                    result1++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    visited2[i][j] = true;
                    bfs(i, j, grid2, visited2);
                    result2++;
                }
            }
        }

        System.out.println(result1);
        System.out.println(result2);

    }

    public static void bfs(int y, int x, char[][] grid, boolean[][] visited) {
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(y, x));
        char color = grid[y][x];

        while (!queue.isEmpty()) {
            Place p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (0 <= ny && ny <= N-1 && 0 <= nx && nx <= N-1) {
                    if (grid[ny][nx] == color && !visited[ny][nx]) {
                        queue.add(new Place(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
