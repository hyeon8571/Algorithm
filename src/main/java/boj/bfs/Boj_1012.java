package boj.bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_1012 {

    public static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int x;

    static int y;

    static int[][] grid;

    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());

            grid = new int[y][x];

            visited = new boolean[y][x];

            int bx = 0; // 배추 x

            int by = 0; // 배추 y

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                bx = Integer.parseInt(st.nextToken());
                by = Integer.parseInt(st.nextToken());

                grid[by][bx] = 1;
            }

            int cnt = 0;

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (grid[j][k] == 1 && !visited[j][k]) {
                        visited[j][k] = true;
                        BFS(j, k);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void BFS(int nowY, int nowX) {

        ArrayDeque<Place> queue = new ArrayDeque<>();

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        queue.add(new Place(nowX, nowY));

        while (!queue.isEmpty()) {

            Place now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < x && 0 <= ny && ny < y) {
                    if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.add(new Place(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}