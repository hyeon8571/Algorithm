import java.util.*;
import java.io.*;

public class Main {

    static int M;
    static int N;

    static int[][] grid;
    static boolean[][] visited;

    static int[] dirX = new int[] {0, 1, 0, -1};
    static int[] dirY = new int[] {-1, 0, 1, 0};

    static class Place {
        int y;
        int x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken());

            grid = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[y][x] = 1;
            }

            int result = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (grid[j][k] == 1 && !visited[j][k]) {
                        visited[j][k] = true;
                        bfs(j, k);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int y, int x) {
        Queue<Place> queue = new ArrayDeque<>();

        queue.add(new Place(y, x));

        while (!queue.isEmpty()) {
            Place p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dirY[i];
                int nx = p.x + dirX[i];

                if (0 <= ny && ny <= N-1 && 0 <= nx && nx <= M-1) {
                    if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx));
                    }
                }
            }
        }
    }
}