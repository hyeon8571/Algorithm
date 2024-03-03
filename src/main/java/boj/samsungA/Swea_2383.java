package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_2383 {

    static class Place {
        int x;
        int y;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;

    static int[][] grid;

    static List<Place> humanList;

    static List<Place> stairList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            grid = new int[N][N];

            humanList = new ArrayList<>();

            stairList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());

                    if (grid[i][j] == 1) {
                        humanList.add(new Place(i, j));
                    }

                    if (2 <= grid[i][j]) {
                        stairList.add(new Place(i, j));
                    }
                }
            }


        }
    }

    public static void goLunch(int depth) {
        if (depth == stairList.size()) {
            return;
        }


    }
}

