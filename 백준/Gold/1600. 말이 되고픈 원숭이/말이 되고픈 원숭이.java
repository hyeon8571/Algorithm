import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int x, y, z;

        public Place(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx1 = new int[] {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] dy1 = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};

    static int[] dx2 = new int[] {0, 1, 0, -1};

    static int[] dy2 = new int[] {-1, 0, 1, 0};

    static int K, W, H;

    static int[][] grid;

    static int[][][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());

        H = Integer.parseInt(st.nextToken());

        grid = new int[H][W];


        visited = new int[K+1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

//        for (int i = 0; i <= K; i++) {
//            for (int j = 0; j < H; j++) {
//                for (int k = 0; k < W; k++) {
//                    System.out.print(visited[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            if (visited[i][H-1][W-1] < result) {
                if (visited[i][H-1][W-1] == 0) {
                    continue;
                }
                result = visited[i][H-1][W-1];
            }
        }

        if (result == 0 || result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result -1);
        }
    }

    public static void bfs(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(0, startY, startX));

        visited[0][startY][startX] = 1;

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            int nowX = now.x;

            int nowY = now.y;

            int nowZ = now.z;

            for (int i = 0; i < 8; i++) {
                int nx = nowX + dx1[i];
                int ny = nowY + dy1[i];
                int nz = nowZ + 1;

                if (0 <= nx && nx < W && 0 <= ny && ny < H && 0 <= nz && nz < K + 1) {
                    if (visited[nz][ny][nx] == 0 && grid[ny][nx] != 1) {
                        visited[nz][ny][nx] = visited[nowZ][nowY][nowX] + 1;
                        queue.add(new Place(nz, ny, nx));
                    } else if (visited[nz][ny][nx] != 0 && grid[ny][nx] != 1) {
                        if (visited[nz][ny][nx] > visited[nowZ][nowY][nowX] + 1) {
                            visited[nz][ny][nx] = visited[nowZ][nowY][nowX] + 1;
                            queue.add(new Place(nz, ny, nx));
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx2[i];
                int ny = nowY + dy2[i];
                int nz = nowZ;

                if (0 <= nx && nx < W && 0 <= ny && ny < H && 0 <= nz && nz < K + 1) {
                    if (visited[nz][ny][nx] == 0 && grid[ny][nx] != 1) {
                        visited[nz][ny][nx] = visited[nowZ][nowY][nowX] + 1;
                        queue.add(new Place(nz, ny, nx));
                    } else if (visited[nz][ny][nx] != 0 && grid[ny][nx] != 1) {
                        if (visited[nz][ny][nx] > visited[nowZ][nowY][nowX] + 1) {
                            visited[nz][ny][nx] = visited[nowZ][nowY][nowX] + 1;
                            queue.add(new Place(nz, ny, nx));
                        }
                    }
                }
            }
        }
    }

}
