package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683_3 {

    public static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, num, result;

    static int[][] grid;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static List<Place> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        result = N * M;

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= grid[i][j] && grid[i][j] <= 5) {
                    num++;
                    list.add(new Place(j, i));
                }
            }
        }

        cctv(0);

        System.out.println(result);

    }

    public static void cctv(int depth) {

        int cnt = 0;

        if (depth == num) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            if (cnt < result) {
                result = cnt;
            }
            return;
        }

        int[] dir = cctvMode(grid[list.get(depth).y][list.get(depth).x]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < dir.length; j++) {
                cctvPower(list.get(depth), (dir[j] + i) % 4, -1);
            }
            cctv(depth + 1);

            for (int j = 0; j < dir.length; j++) {
                cctvPower(list.get(depth), (dir[j] + i) % 4, +1);
            }
        }

    }

    public static void cctvPower(Place now, int d, int p) {
        int ny = now.y + dy[d];
        int nx = now.x + dx[d];

        while(0 <= nx && nx < M && 0 <= ny && ny < N) {
            if (grid[ny][nx] == 6) {
                break;
            }

            if (1 > grid[ny][nx]) {
                grid[ny][nx] += p;
            }

            ny += dy[d];

            nx += dx[d];
        }
    }

    public static int[] cctvMode(int mode) {
        if (mode == 1) return new int[] {0};
        else if (mode == 2) return new int[] {0, 2};
        else if (mode == 3) return new int[] {0, 1};
        else if (mode == 4) return new int[] {0, 1, 3};
        return new int[] {0, 1, 2, 3};
    }
}
