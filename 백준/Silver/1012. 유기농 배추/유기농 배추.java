import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int x, y;

        public Place(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            grid = new int[N][M];
            visited = new boolean[N][M];

            int K =  Integer.parseInt(st.nextToken());

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

    public static void bfs(int startY, int startX) {
        Queue<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX));

        while (!queue.isEmpty()) {
            Place p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (0 <= ny && ny <= N - 1 && 0 <= nx && nx <= M - 1) {
                    if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx));
                    }
                }
            }
        }

    }
}
