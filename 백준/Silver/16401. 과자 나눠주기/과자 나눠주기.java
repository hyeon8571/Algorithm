import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1];

        int index = 0;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = index; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= M) {
                result = Math.max(result, mid);

                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        System.out.println(result);
    }
}
