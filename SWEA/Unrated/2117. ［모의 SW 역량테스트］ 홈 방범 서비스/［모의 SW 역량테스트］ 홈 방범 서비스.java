

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static class Place {
        int y, x, k;

        public Place(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int N, M;

    static int[][] grid;

    static boolean[][] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(st.nextToken());

            result = 0;

            grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    bfs(i, j);
                }
            }

            System.out.println("#" + t + " " + result);

        }
    }

    public static void bfs(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX, 1));

        visited[startY][startX] = true;

        int k = 1;

        int home = 0;

        if (grid[startY][startX] == 1) {
            home++;
        }

        int profit = M * home - 1;

        if (profit >= 0 && home > result) {
            result = home;
        }

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            if (now.k > k) {
                k = now.k;
                profit = M*home - (k*k + (k-1)*(k-1));

                if (profit >= 0 && home > result) {
                    result = home;
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx, now.k + 1));

                        if (grid[ny][nx] == 1) {
                            home++;
                        }
                    }
                }
            }
        }
    }
}
