package boj.recursive;

import java.util.Scanner;

public class Boj_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sb.append((int)Math.pow(2, n) - 1).append("\n");

        hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {

        if (n ==1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        // n-1개 원판은 A에서 B로
        hanoi(n-1, start, to, mid);

        // 한개의 원판을 A에서 C로
        sb.append(start + " " + to + "\n");

        // n-1개의 원판을 B에서 C로
        hanoi(n-1, mid, start, to);
    }
}
