package boj.backtracking;

import java.util.Scanner;

public class Boj_9663_2 {

    static int N, cnt;

    static int[][] grid;

    static int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

    static int[] dy = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        grid = new int[N][N];

        visited = new boolean[N][N];

        queen(0);

        System.out.println(cnt);

    }

    public static void queen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isAble(depth, i)) {
                visited[depth][i] = true;
                queen(depth + 1);
                visited[depth][i] = false;
            }
        }
    }

    public static boolean isAble(int startY, int startX) {
        for (int i = 0; i < 8; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            while (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (visited[ny][nx]) {
                    return false;
                }

                nx = nx + dx[i];
                ny = ny + dy[i];

            }
        }

        return true;
    }
}
