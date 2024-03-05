package boj.samsungA;

import java.util.Scanner;

public class Boj_9663 {

    static int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

    static int[] dy = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};

    static int N;

    static int[][] grid;

    static boolean[][] visited;

    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        grid = new int[N][N];

        visited = new boolean[N][N];

        backtracking(0);

        System.out.println(cnt);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (canQueen(depth, i)) {
                visited[depth][i] = true;
                backtracking(depth + 1);
                visited[depth][i] = false;
            }
        }


    }

    public static boolean canQueen(int startY, int startX) {

        for (int i = 0; i < 8; i++) {
            int ny = startY + dy[i];
            int nx = startX + dx[i];

            while (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (visited[ny][nx]) {
                    return false;
                }

                ny += dy[i];
                nx += dx[i];
            }
        }

        return true;
    }
}
