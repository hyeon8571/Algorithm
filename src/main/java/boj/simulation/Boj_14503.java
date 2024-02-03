package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 맵 세로

        int M = Integer.parseInt(st.nextToken()); // 전체 맵 가로

        st = new StringTokenizer(br.readLine());

        int nowY = Integer.parseInt(st.nextToken()); // 로봇 위치 세로

        int nowX = Integer.parseInt(st.nextToken()); // 로봇 위치 가로

        int dir = Integer.parseInt(st.nextToken()); // 현재 방향

        boolean[][] visited = new boolean[N][M];

        int[][] grid = new int[N][M];

        boolean power = true;

        int cnt = 0;

        // 맵 셋팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        while (power) {

            if (!visited[nowY][nowX]) {
                visited[nowY][nowX] = true;
                cnt++;
            }

            for (int i = 0; i < 4; i++) {

                if (dir - 1 < 0) {
                    dir = 3;
                } else {
                    dir -= 1;
                }

                int nextX = nowX + dx[dir];
                int nextY = nowY + dy[dir];

                if (grid[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    nowX = nextX;
                    nowY = nextY;

                    break;
                }
                // 후진
                if (i == 3) {
                    int prevX = nowX - dx[dir];
                    int prevY = nowY - dy[dir];
                    if (grid[prevY][prevX] != 1) {
                        nowX = prevX;
                        nowY = prevY;
                        break;
                    } else {
                        power = false;
                        break;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}
