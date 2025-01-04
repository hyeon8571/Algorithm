import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.parseInt(br.readLine());

        int cnt = 0;

        int[] arr = new int[n];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            int cha = result - arr[i];

            if (set.contains(cha)) {
                cnt ++;
            }
        }

        System.out.println(cnt/2);
    }
}
