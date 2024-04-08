

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static class Place {
        int y, x, distance;

        public Place(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    static int N, M;

    static int[][] grid;

    static boolean[][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int result;


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
                    homeservice(i, j);
                }
            }

            System.out.println("#" + t + " " + result);

        }

    }

    // distance = |ax - bx| + |ay - by|
    public static void homeservice(int y, int x) {
        visited = new boolean[N][N];

        // k 넓히기 (모든 맵을 다 포함할 때 까지)
        spread(y, x);
    }

    public static void spread(int startY, int startX) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX, 0));

        visited[startY][startX] = true;

        int distance = 0;

        int profit = 0;

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

        while (!queue.isEmpty()) {

            Place now = queue.pollFirst();

            // 다음 범위를 담음
            if (distance < now.distance) {
                int k = distance + 2;

                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (grid[i][j] == 1 && visited[i][j]) {
                            cnt++;
                        }
                    }
                }

                profit = ((M * cnt) - ((k) * (k) + (k - 1) * (k - 1)));

                if (profit >= 0 && cnt > result) {
                    result = cnt;
                }

                distance = now.distance;

            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if ((Math.abs(ny - startY) + Math.abs(nx - startX)) == now.distance + 1) {
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx, now.distance + 1));

                        }
                    }
                }
            }

        }

    }

}
