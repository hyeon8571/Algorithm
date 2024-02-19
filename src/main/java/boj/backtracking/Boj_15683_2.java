package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15683_2 {

    static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;

    static int[][] grid;

    static List<Place> list = new ArrayList<>();

    static int num;

    static int result;

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};

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


        checkCCTV(0);


        System.out.println(result);
    }

    public static void checkCCTV(int depth) {

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
            // -1로 cctv가 감시하는 구역을 채우고 다음 cctv로 넘어가고 마지막 cctv에 도달하면 회전하면서 확인하고 끝나면 그 전 cctv도 회전하면서 확인하는 작업을 반복, 돌아갈 때 회수

            // 켠다
            for (int j = 0; j < dir.length; j++) {
                onCCTV(list.get(depth), (dir[j] + i) % 4, -1);
            }
            checkCCTV(depth + 1);

            // 끈다
            for (int j = 0; j < dir.length; j++) {
                onCCTV(list.get(depth), (dir[j] + i) % 4, +1);
            }

        }

    }

    public static void onCCTV(Place now, int dir, int p) {

        int nx = now.x + dx[dir];

        int ny = now.y + dy[dir];

        while (0 <= nx && nx < M && 0 <= ny && ny < N) {

            if (grid[ny][nx] == 6) {
                break;
            }

            if (1 > grid[ny][nx]) {
                grid[ny][nx] += p;
            }

            nx += dx[dir];
            ny += dy[dir];
        }
    }

    public static int[] cctvMode(int mode) {
        if (mode == 1) {
            return new int[] {0};
        } else if (mode == 2) {
            return new int[] {0, 2};
        } else if (mode == 3) {
            return new int[] {0, 1};
        } else if (mode == 4) {
            return new int[] {0, 1, 3};
        }

        return new int[] {0, 1, 2, 3};


    }
}
