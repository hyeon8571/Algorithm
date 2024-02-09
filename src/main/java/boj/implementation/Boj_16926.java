package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16926 {

    static int N;

    static int M;

    static int[][] grid;

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        int rotateNum = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(rotateNum-- > 0) {
            grid = rotate(grid);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] grid) {
        int[][] rotatedGrid = new int[N][M];

        // 만약 가로 세로 중 최단길이가 4이면 돌려야 할 테두리 개수는 2개이다
        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            int startX = i;
            int startY = i;

            int endY = N - i - 1;
            int endX = M - i - 1;

            int d = 0;

            while (d < 4) {
                int nx = startX + dx[d];
                int ny = startY + dy[d];

                if (ny < i || ny > endY || nx < i || nx > endX) {
                    d++;
                    continue;
                }
                rotatedGrid[ny][nx] = grid[startY][startX];

                startX = nx;
                startY = ny;

            }
        }

        return rotatedGrid;
    }
}
