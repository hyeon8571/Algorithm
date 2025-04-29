

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        int sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        int money = Integer.parseInt(br.readLine());

        if (sum <= money) {
            System.out.println(max);
            return;
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr[N-1];

        while (start <= end) {
            int mid = (start+end) / 2; // 상한값
            sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if (sum > money) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(end);
    }
}
