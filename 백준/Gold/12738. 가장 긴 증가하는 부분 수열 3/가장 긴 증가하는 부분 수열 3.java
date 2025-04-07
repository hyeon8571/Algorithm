
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > lis.get(lis.size()-1)) {
                lis.add(arr[i]);
                continue;
            }

            int start = 0;
            int end = lis.size()-1;

            while (start < end) {
                int mid = (start + end) / 2;
                if (lis.get(mid) < arr[i]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            lis.set(end, arr[i]);
        }

        System.out.println(lis.size());
    }
}
