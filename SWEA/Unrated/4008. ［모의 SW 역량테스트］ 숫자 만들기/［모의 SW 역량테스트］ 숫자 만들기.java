import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] num;

    static boolean[] visited;

    static int[] arr;

    static int[] operator;

    static int N;

    static int resultMin, resultMax;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());

            operator = new int[4];

            num = new int[N];

            visited = new boolean[N-1];

            arr = new int[N-1];

            resultMin = Integer.MAX_VALUE;

            resultMax = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;

            while (st.hasMoreTokens()) {

                int n = Integer.parseInt(st.nextToken());

                for (int i = 0; i < n; i++) {
                    operator[cnt]++;
                }
                cnt++;
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            makePermutation(0);

            System.out.println("#" + t + " " + (resultMax - resultMin));

        }
    }

    public static void makePermutation(int depth) {

        if (depth == N-1) {

            int plusCnt = 0;

            int minusCnt = 0;

            int multipleCnt = 0;

            int subCnt = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    plusCnt++;
                } else if (arr[i] == 1) {
                    minusCnt++;
                } else if (arr[i] == 2) {
                    multipleCnt++;
                } else {
                    subCnt++;
                }
            }

            if (plusCnt == operator[0] && minusCnt == operator[1] && multipleCnt == operator[2] && subCnt == operator[3]) {
                calculate(arr);
            }

            return;
        }

        for (int i = 0; i < operator.length; i++) {

            arr[depth] = i;
            makePermutation(depth + 1);
        }

    }

    public static void calculate(int[] oper) {
        int result = num[0];
        for (int i = 0; i < oper.length; i++) {
            if (oper[i] == 0) {
                result += num[i+1];
            } else if (oper[i] == 1) {
                result -= num[i+1];
            } else if (oper[i] == 2) {
                result *= num[i+1];
            } else {
                result /= num[i+1];
            }
        }

        if (result < resultMin) {
            resultMin = result;
        }

        if (result > resultMax) {
            resultMax = result;
        }

    }

}
