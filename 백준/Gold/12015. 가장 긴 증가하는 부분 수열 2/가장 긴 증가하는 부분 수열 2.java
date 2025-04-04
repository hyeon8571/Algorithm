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

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (lis.get(lis.size()-1) < key) {
                lis.add(key);
            } else {
                int low = 0;
                int high = lis.size()-1;
                while (low < high) {
                    int mid = (low + high)/2;
                    if (lis.get(mid) >= key) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                lis.set(high, key);
            }
        }

        System.out.println(lis.size());
    }
}
