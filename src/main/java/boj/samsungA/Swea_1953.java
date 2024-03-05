package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Swea_1953 {

    static class Place {
        int x, y, time;

        public Place(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N, M, R, C, L;

    static int[][] grid;

    static boolean[][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());


            grid = new int[N][M];

            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R, C);

            int cnt = 0;


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + tc + " " + cnt);

        }
    }

    static void bfs(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        int dir = grid[startY][startX];
        queue.add(new Place(startY, startX, 1));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {

            Place now = queue.pollFirst();

            int cur = now.time;

            if (cur >= L) {
                break;
            }

            int nowX = now.x;

            int nowY = now.y;

            for (int i = 0; i < 4; i++) {

                int nx = nowX + dx[i];

                int ny = nowY + dy[i];

                dir = grid[nowY][nowX];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {

                    if (i == 0 && (dir == 1 || dir == 2 || dir == 4 || dir == 7) && (grid[ny][nx] == 1 || grid[ny][nx] == 2 || grid[ny][nx] == 5 || grid[ny][nx] == 6)) {
                        if (!visited[ny][nx] && grid[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx, cur + 1));
                        }
                    } else if (i == 1 && (dir == 1 || dir == 3 || dir == 4 || dir == 5) && (grid[ny][nx] == 1 || grid[ny][nx] == 3 || grid[ny][nx] == 6 || grid[ny][nx] == 7)) {
                        if (!visited[ny][nx] && grid[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx, cur + 1));
                        }
                    } else if (i == 2 && (dir == 1 || dir == 2 || dir == 5 || dir == 6) && (grid[ny][nx] == 1 || grid[ny][nx] == 2 || grid[ny][nx] == 4 || grid[ny][nx] == 7)) {
                        if (!visited[ny][nx] && grid[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx, cur + 1));
                        }
                    } else if (i == 3 && (dir == 1 || dir == 3 || dir == 6 || dir == 7) && (grid[ny][nx] == 1 || grid[ny][nx] == 3 || grid[ny][nx] == 4 || grid[ny][nx] == 5)) {
                        if (!visited[ny][nx] && grid[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx, cur + 1));
                        }
                    }

                }

            }

        }

    }

}
