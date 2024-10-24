import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long sum = Long.MAX_VALUE;

        long answer1 = 0;
        long answer2 = 0;
        long answer3 = 0;

        for (int i = 0; i < N-2; i++) {
            int p1 = i;
            int p2 = i + 1;
            int p3 = N - 1;

            while (p2 < p3) {
                long temp = arr[p1] + arr[p2] + arr[p3];

                if (Math.abs(temp) < Math.abs(sum)) {
                    sum = temp;
                    answer1 = arr[p1];
                    answer2 = arr[p2];
                    answer3 = arr[p3];
                }

                if (temp < 0) {
                    p2++;
                } else if (temp == 0) {
                    break;
                } else {
                    p3--;
                }
            }
        }

        System.out.println(answer1 + " " + answer2 + " " + answer3);
    }
}
