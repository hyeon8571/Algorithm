

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution{

    static class Place {
        int y, x, level;

        public Place (int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static int N, M;

    static int[][] grid;

    static boolean[][] visited;

    static int result;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];

            result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    homeservice(i, j);
                }
            }

            System.out.println("#" + t + " " + result);

        }
    }

    public static void homeservice(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        visited[startY][startX] = true;

        queue.add(new Place(startY, startX, 1));

        int profit =  0;

        if (grid[startY][startX] == 1) {
            profit = M - 1;
        } else {
            profit = -1;
        }

        if (profit >= 0) {
            if (result < 1) {
                result = 1;
            }
        }

        int distance = 1;

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            if (now.level > distance) {
                distance = now.level;

                int cnt = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visited[i][j] && grid[i][j] == 1) {
                            cnt++;
                        }
                    }
                }

                profit = M*cnt - (distance * distance + (distance - 1) * (distance - 1));

                if (profit >= 0) {
                    if (cnt > result) {
                        result = cnt;
                    }
                }

            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];

                int ny = now.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx, now.level + 1));
                    }
                }
            }
        }

    }
}
