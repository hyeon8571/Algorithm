package boj.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15656 {

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

        dupPermutation(0);

        System.out.print(sb);
    }

    public static void dupPermutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");

            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = num[i];
            dupPermutation(depth + 1);
        }

    }
}
