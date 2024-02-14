package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {

    static int N;

    static int[][] grid;

    static int blue;

    static int white;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }


    public static void recursive(int distance, int startY, int startX) {

        int checkNum = grid[startY][startX];

        boolean flag = false; // false 쪼갤필요 x

        for (int i = startY; i < startY + distance; i++) {
            for (int j = startX; j < startX + distance; j++) {
                if (grid[i][j] != checkNum) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            if (checkNum == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int nextDistance = distance / 2;
        recursive(nextDistance, startY, startX);
        recursive(nextDistance, startY, startX + nextDistance);
        recursive(nextDistance, startY + nextDistance, startX);
        recursive(nextDistance, startY + nextDistance, startX + nextDistance);
    }
}
