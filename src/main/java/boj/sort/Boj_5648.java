package boj.sort;

import java.util.*;

public class Boj_5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Long[] arr = new Long[N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            StringBuffer sb = new StringBuffer(str);
            String reverse = sb.reverse().toString();

            arr[i] = Long.parseLong(reverse);
        }

        Arrays.sort(arr);

        for (long num : arr) {
            System.out.println(num);
        }

    }
}
