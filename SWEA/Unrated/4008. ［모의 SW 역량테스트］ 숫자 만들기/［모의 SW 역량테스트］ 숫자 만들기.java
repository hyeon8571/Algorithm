

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;

    static int[] num;

    static int[] operator;

    static int[] arr;

    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());

            num = new int[N];

            operator = new int[4];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;

            min = Integer.MAX_VALUE;

            arr = new int[N-1];

            // 중복 순열
            makePermutation(0);

            System.out.println("#" + t + " " + (max - min));
        }
    }

    // 중복순열
    public static void makePermutation(int depth) {
        if (depth == N-1) {

            int plus = 0;
            int minus = 0;
            int multiple = 0;
            int mod = 0;


            for (int i = 0; i < N-1; i++) {
                if (arr[i] == 0) {
                    plus++;
                } else if (arr[i] == 1) {
                    minus++;
                } else if (arr[i] == 2) {
                    multiple++;
                } else {
                    mod++;
                }
            }

            if (plus == operator[0] && minus == operator[1] && multiple == operator[2] && mod == operator[3]) {
                calculate(arr);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            makePermutation(depth + 1);
        }

    }

    public static void calculate(int[] arr) {

        int result = num[0];

        for (int i = 0; i < N-1; i++) {
            if (arr[i] == 0) {
                result += num[i+1];
            } else if (arr[i] == 1) {
                result -= num[i+1];
            } else if (arr[i] == 2) {
                result *= num[i+1];
            } else {
                result /= num[i+1];
            }
        }

        if (result > max) {
            max = result;
        }

        if (result < min) {
            min = result;
        }
    }

}
