package ssafy_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];

            int[] B = new int[M];

            int sum = 0;

            int max = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                B[k] = Integer.parseInt(st.nextToken());
            }

            if (N < M) {
                for (int l = 0; l <= M - N; l++) {
                    sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += A[k] * B[k + l];
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            } else {
                for (int l = 0; l <= N - M; l++) {
                    sum = 0;
                    for (int k = 0; k < M; k++) {
                        sum += B[k] * A[k+l];
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            System.out.printf("#%d %d\n", i, max);
        }
    }
}
