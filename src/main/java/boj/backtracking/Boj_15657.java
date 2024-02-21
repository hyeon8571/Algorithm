package boj.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15657 {

    static int N, M;

    static int[] num, arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        num = new int[N];

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        dupCombination(0, 0);

        System.out.print(sb);
    }

    public static void dupCombination(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = num[i];
            dupCombination(depth + 1, i);
        }
    }
}
