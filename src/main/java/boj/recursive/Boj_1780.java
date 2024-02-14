package boj.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {

    static int[][] grid;

    static int minus;
    static int zero;
    static int one;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(N, 0, 0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void recursive(int n, int startY, int startX) {

        boolean flag = false;

        int checkNum = grid[startY][startX];
        for (int i = startY; i < startY + n; i++) {
            for (int j = startX; j < startX + n; j++) {
                if (grid[i][j] != checkNum) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            if (checkNum == -1) {
                minus++;
            } else if(checkNum == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }

        int distance = n / 3;
        recursive(distance, startY, startX);
        recursive(distance, startY, startX + distance);
        recursive(distance, startY, startX + distance * 2);
        recursive(distance, startY + distance, startX);
        recursive(distance, startY + distance, startX + distance);
        recursive(distance, startY + distance, startX + distance * 2);
        recursive(distance, startY + distance * 2, startX);
        recursive(distance, startY + distance * 2, startX + distance);
        recursive(distance, startY + distance * 2, startX + distance * 2);
    }

}
