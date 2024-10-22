import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];

        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                result.add(arr1[p1]);
                p1++;
            } else {
                result.add(arr2[p2]);
                p2++;
            }
        }

        if (p1 < n) {
            while (p1 < n) {
                result.add(arr1[p1]);
                p1++;
            }
        } else if (p2 < m) {
            while (p2 < m) {
                result.add(arr2[p2]);
                p2++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
