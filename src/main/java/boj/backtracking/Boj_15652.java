package boj.backtracking;

import java.util.Scanner;

public class Boj_15652 {

    static int N, M;

    static int[] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        arr = new int[N];

        duCombination(0, 1);

    }

    public static void duCombination(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= arr.length; i++) {
            arr[depth] = i;
            duCombination(depth + 1, i);
        }
    }
}
