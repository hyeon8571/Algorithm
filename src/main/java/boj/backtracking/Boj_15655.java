package boj.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15655 {

    static  int N, M;

    static int[] arr, num;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        arr = new int[N];

        num = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        makeCombination(0, 0);
    }

    public static void makeCombination(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            num[depth] = arr[i];
            makeCombination(depth + 1, i + 1);
        }
    }
}
