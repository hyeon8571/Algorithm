package boj.array;

import java.util.Scanner;

public class Boj_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int findNum = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (arr[i] == findNum) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
