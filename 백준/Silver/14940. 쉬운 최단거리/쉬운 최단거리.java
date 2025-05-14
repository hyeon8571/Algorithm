
import java.io.*;
import java.util.*;

public class Main {

    public static class Place {
        int y, x, distance;

        public Place(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    static int[][] grid;
    static int[][] result;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        int startY = 0;
        int startX = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    System.out.print(-1);
                    System.out.print(" ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    public static void bfs(int startY, int startX) {
        Queue<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX, 0));
        visited[startY][startX] = true;

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            Place now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if (!visited[ny][nx]) {
                        if (grid[ny][nx] == 0) {
                            result[ny][nx] = 0;
                            continue;
                        }
                        result[ny][nx] = now.distance+1;
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx, now.distance+1));
                    }
                }
            }
        }
    }
}
