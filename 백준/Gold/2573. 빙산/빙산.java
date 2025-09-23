import java.io.*;
import java.util.*;

public class Main {

    public static class Place {
        int y, x, near;
        public Place(int y, int x, int near) {
            this.y = y;
            this.x = x;
            this.near = near;
        }
    }

    public static int[][] grid;
    public static int N, M;
    public static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            visited = new boolean[N][M];
            int cnt = 0; // 덩어리 개수

            int zeroCheck = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] != 0) {
                        zeroCheck++;
                    }
                }
            }

            if (zeroCheck == 0) {
                System.out.println(0);
                return;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt >= 2) {
                break;
            }

            melt();
            result++;

        }

        System.out.println(result);

    }


    public static void bfs(int y, int x) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        Queue<Place> queue = new ArrayDeque();
        queue.add(new Place(y, x, 0));

        while (!queue.isEmpty()) {
            Place now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (grid[ny][nx] != 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx, 0));
                    }
                }
            }
        }
    }

    public static void melt() {
        Queue<Place> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != 0) {
                    int near = check(i, j);
                    queue.add(new Place(i, j, near));
                }
            }
        }

        while(!queue.isEmpty()) {
            Place now = queue.poll();
            grid[now.y][now.x] -= now.near;
            
            if (grid[now.y][now.x] < 0) {
                grid[now.y][now.x] = 0;
            }
        }

    }

    public static int check(int y, int x) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        int result = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                if (grid[ny][nx] == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
