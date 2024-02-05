package boj.bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_7569 {

    public static class Place {
        int x;
        int y;
        int z;

        public Place(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[][][] grid;

    static boolean[][][] visited;

    static int[][][] distance;

    static ArrayDeque<Place> queue = new ArrayDeque<>();

    static int x;

    static int y;

    static int z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken()); // 5

        y = Integer.parseInt(st.nextToken()); // 3

        z = Integer.parseInt(st.nextToken()); // 1

        grid = new int[z][y][x];

        visited = new boolean[z][y][x];

        distance = new int[z][y][x];

        int zeroCnt = 0;

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());

                    if (grid[i][j][k] == 1) {
                        queue.add(new Place(k, j, i));
                        visited[i][j][k] = true;
                    } else if (grid[i][j][k] == 0) {
                        zeroCnt++;
                    }
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.print(0);
            return;
        }

        BFS();

        int day = 0;

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (grid[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    day = Math.max(day, distance[i][j][k]);
                }
            }
        }

        System.out.print(day);

    }

    public static void BFS() {
        int[] dz = new int[] {1, -1, 0, 0, 0, 0};
        int[] dx = new int[] {0, 0, 1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {

            Place now = queue.pollFirst();

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (0 <= nx && nx < x && 0 <= ny && ny < y && 0 <= nz && nz < z) {
                    if (grid[nz][ny][nx] == 0 && !visited[nz][ny][nx]) {
                        grid[nz][ny][nx] = 1;
                        visited[nz][ny][nx] = true;
                        queue.add(new Place(nx, ny, nz));
                        distance[nz][ny][nx] = distance[now.z][now.y][now.x] + 1;
                    }
                }
            }

        }
    }
}