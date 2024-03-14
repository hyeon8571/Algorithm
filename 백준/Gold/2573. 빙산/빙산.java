
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static class Place {
        int x, y;

        public Place (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;

    static int[][] grid;

    static int[][] meltCnt;

    static boolean[][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
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

        int time = 0;
        while (true) {

            int cnt = 0;

            int check = 0;

            visited = new boolean[N][M];

            time++;

            ice();
            

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] != 0) {
                        check++;
                    }
                }
            }

            if (check == 0) {
                System.out.println(0);
                return;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && grid[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                    if (cnt >= 2) {
                        System.out.println(time);
                        return;
                    }
                }
            }





        }

    }

    public static void bfs(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX));

        visited[startY][startX] = true;

        while(!queue.isEmpty()) {

            Place now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];

                int ny = now.y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (!visited[ny][nx] && grid[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx));
                    }
                }
            }
        }
    }

    public static void ice() {
        meltCnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != 0) {
                    countWater(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] - meltCnt[i][j] < 0) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] -= meltCnt[i][j];
                }
            }
        }

    }

    public static void countWater(int y, int x) {


        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (grid[ny][nx] == 0) {
                cnt++;
            }

        }

        meltCnt[y][x] = cnt;

    }

}
