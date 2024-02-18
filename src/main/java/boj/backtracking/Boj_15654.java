package boj.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15654 {

    static int N, M;

    static int[] arr, num;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        arr = new int[N];

        num = new int[N];

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        makePermutation(0);

    }

    public static void makePermutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                    System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            num[depth] = arr[i];
            makePermutation(depth + 1);
            visited[i] = false;
        }
    }
}
