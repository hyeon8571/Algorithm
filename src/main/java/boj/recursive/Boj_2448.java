package boj.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2448 {

    static StringBuilder sb = new StringBuilder();

    static String[][] grid;

    static int[] dx = new int[] {0, -1, 1};

    static int[] dy = new int[] {0, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int yLength = N;

        int xLength = 2*N - 1;

        grid = new String[yLength][xLength];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], " ");
        }

        recursive(N, 0, xLength  / 2);

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void recursive(int distance, int startY, int startX) {
        if (distance == 1) {
            grid[startY][startX] = "*";
            return;
        }

        for (int i = 0; i < 5; i++) {
            grid[startY + 2][startX - 2 + i] = "*";
        }

        int nextDistance = distance / 2;

        for (int i = 0; i < 3; i++) {
            recursive(nextDistance, startY + dy[i] * nextDistance, startX + dx[i] * nextDistance);
        }
    }
}
