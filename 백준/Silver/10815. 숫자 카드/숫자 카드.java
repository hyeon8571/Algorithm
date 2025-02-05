import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            int result = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] == x) {
                    result = 1;
                    break;
                } else {
                    if (arr[mid] < x) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }
}
