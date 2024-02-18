package boj.backtracking;

import java.util.Scanner;

public class Boj_9663 {

    static int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[] {-1, -1, 0, 1, 1, 1, -1, -1};

    static int N, result;

    static boolean[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        grid = new boolean[N][N];

        backtracking(0, 0);

        System.out.println(result);

    }

    public static void backtracking(int depth, int cnt) {

        if (cnt == N) {
            result++;
            return;
        }

        if (depth >= N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isAble(depth, i)) {
                grid[depth][i] = true;
                backtracking(depth + 1, cnt + 1);
                grid[depth][i] = false; // 체스를 거두고 다른 자리에 넣고 시험하기 위해 진행
            }
        }

    }


    // 체스를 둔 점을 true로 바꿨음, 8방향을 다 바꾸지 않고 다음 놓을 체스의 위치를 기준으로 8방향을 판의 끝까지 탐색하여 true가 있는지 확인
    public static boolean isAble(int startY, int startX) {

        for (int i = 0; i < 8; i++) {
            int nx = startX + dx[i];

            int ny = startY + dy[i];

            while (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (grid[ny][nx]) {
                    return false;
                }

                nx += dx[i];
                ny += dy[i];

            }
        }

        return true;
    }

}
