package ssafy_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#"+i+" ");
            for (int k = 0; k < N; k++) {
                for (int j = N-1; j >= 0; j--) {
                    System.out.print(arr[j][k]);
                }
                System.out.print(" ");

                for (int j = N-1; j >= 0; j--) {
                    System.out.print(arr[N-k-1][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(arr[j][N-k-1]);
                }
                System.out.println();
            }
        }
    }
}
