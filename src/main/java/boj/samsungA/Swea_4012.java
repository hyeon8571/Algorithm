package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_4012 {

    static int N;

    static int[][] grid;

    static int[] arr, arrFirst, arrSecond, secondFoods;

    static int firstFood, secondFood;

    static List<Integer> firstList, secondList;

    static int cnt;

    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());

            grid = new int[N][N];

            arr = new int[N/2];

            arrFirst = new int[N/2];

            arrSecond = new int[N/2];

            secondFoods = new int[N*N];

            result = Integer.MAX_VALUE;

            cnt = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            makeCombination(0, 0);

            System.out.println("#" + t + " " + result);
        }
    }


    public static void makeCombination(int depth, int startIdx) {
        if (depth == N/2) {

            firstList = new ArrayList<>();

            secondList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                secondList.add(i);
            }


            for (int i = 0; i < N/2; i++) {
                firstList.add(arr[i]);

                secondList.remove(secondList.indexOf(arr[i]));
            }

            firstFood = 0;
            secondFood = 0;

            makeCombination2(0, 0);

            makeCombination3(0, 0);

            int cha = Math.abs(firstFood - secondFood);

            if (result > cha) {
                result = cha;
            }

            return;
        }

        for (int i = startIdx; i < N; i++) {
            arr[depth] = i;
            makeCombination(depth + 1, i + 1);
        }
    }

    // 첫 음식의 값을 구함
    public static void makeCombination2(int depth, int startIdx) {
        if (depth == 2) {
            firstFood += grid[arrFirst[0]][arrFirst[1]] + grid[arrFirst[1]][arrFirst[0]];

            return;
        }

        for (int i = startIdx; i < N/2; i++) {
            arrFirst[depth] = firstList.get(i);
            makeCombination2(depth + 1, i + 1);
        }
    }

    // 두번째 음식의 값을 구함
    public static void makeCombination3(int depth, int startIdx) {
        if (depth == 2) {
            secondFood += grid[arrSecond[0]][arrSecond[1]] + grid[arrSecond[1]][arrSecond[0]];
            return;
        }

        for (int i = startIdx; i < N/2; i++) {
            arrSecond[depth] = secondList.get(i);
            makeCombination3(depth + 1, i + 1);
        }
    }
}
