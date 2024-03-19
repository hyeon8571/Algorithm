import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

    static int N, M, K;

    static Character[][] grid;

    static int[][][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        grid = new Character[N][M];

        visited = new int[K+1][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        bfs(0, 0);


        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            if (visited[i][N-1][M-1] < result) {
                if (visited[i][N-1][M-1] == 0) {
                    continue;
                }
                result = visited[i][N-1][M-1];
            }
        }

        if (result == 0 || result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static void bfs(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(0, startY, startX));

        visited[0][startY][startX] = 1;

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z;


                if (0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && nz < K + 1) {
                    if (visited[nz][ny][nx] == 0 && grid[ny][nx] != '1') {
                        visited[nz][ny][nx] = visited[now.z][now.y][now.x] + 1;
                        queue.add(new Place(nz, ny, nx));
                    } else if (visited[nz][ny][nx] != 0 && grid[ny][nx] != '1') {
                        if (visited[nz][ny][nx] > visited[now.z][now.y][now.x] + 1) {
                            visited[nz][ny][nx] = visited[now.z][now.y][now.x] + 1;
                            queue.add(new Place(nz, ny, nx));
                        }
                    } else if (nz + 1 < K + 1 && visited[nz+1][ny][nx] == 0 && grid[ny][nx] == '1') {

                            visited[nz + 1][ny][nx] = visited[now.z][now.y][now.x] + 1;
                            queue.add(new Place(nz + 1, ny, nx));

                    } else if (nz + 1 < K + 1 && visited[nz+1][ny][nx] != 0 && grid[ny][nx] == '1') {if (nz + 1 < K + 1) {
                            if (visited[nz + 1][ny][nx] > visited[now.z][now.y][now.x] + 1) {
                                visited[nz+1][ny][nx] = visited[now.z][now.y][now.x] + 1;
                                queue.add(new Place(nz+1, ny, nx));
                            }
                        }

                    }

                }
            }
        }
    }
}
