package boj.array;

import java.util.Scanner;

public class Boj_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max = 0;

        // 각 숫자를 배열에 저장하고 최고값 출력 (단 6과 9는 같은 배열 사용)

        String str = String.valueOf(N);

        int[] arr = new int[10];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            int n = ch - '0';

            if (n == 9) {
                arr[6]++;
            } else {
                arr[n]++;
            }
        }

        for (int i = 0; i < 9; i++) {

            if (i == 6) {
                arr[i] = (int)Math.ceil((double)arr[i] / 2);
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
