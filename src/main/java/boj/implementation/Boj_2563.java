package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[101][101];

        int cnt = 0;

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());

            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y+10; j++) {
                for (int k = x; k < x+10; k++) {
                    if (grid[j][k] != 1) {
                        grid[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}