package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683 {

    static class Place {
        int x;
        int y;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;

    static int[][] grid;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int result = Integer.MAX_VALUE;

    static List<Place> cctvLocs = new ArrayList<>();

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

                if (1 <= grid[i][j] && grid[i][j] <= 5) {
                    cctvLocs.add(new Place(i, j));
                }
            }
        }

        checkArea(0);

        System.out.println(result);

    }

    public static void checkArea(int depth) {
        if (depth == cctvLocs.size()) {
            int cnt = 0;
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

        int[] area = cctvMode(grid[cctvLocs.get(depth).y][cctvLocs.get(depth).x]);
        for (int i = 0; i < 4; i++) {
           for (int j = 0; j < area.length; j++) {
               int startY = cctvLocs.get(depth).y;
               int startX = cctvLocs.get(depth).x;
               int dir = (i + area[j]) % 4;
               cctvPower(startY, startX, dir, -1);
           }
           checkArea(depth + 1);

            for (int j = 0; j < area.length; j++) {
                int startY = cctvLocs.get(depth).y;
                int startX = cctvLocs.get(depth).x;
                int dir = (i + area[j]) % 4;
                cctvPower(startY, startX, dir, 1);
            }

        }
    }

    public static void cctvPower(int startY, int startX, int dir, int p) {

        int ny = startY + dy[dir];

        int nx = startX + dx[dir];

        while (0 <= nx && nx < M && 0 <= ny && ny < N && grid[ny][nx] != 6) {

            if (grid[ny][nx] < 1) {
                grid[ny][nx] += p;
            }

            ny += dy[dir];

            nx += dx[dir];
        }
    }

    public static int[] cctvMode(int mode) {
        if (mode == 1) return new int[] {0};
        else if (mode == 2) return new int[] {0, 2};
        else if (mode == 3) return new int[] {0, 1};
        else if (mode == 4) return new int[] {0, 1, 3};
        else return new int[] {0, 1, 2, 3};
    }

}
