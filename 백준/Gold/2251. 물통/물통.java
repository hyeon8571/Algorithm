import java.io.*;
import java.util.*;

public class Main {

    static int[] now, arr;
    static boolean[][][] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[3];
        now = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[arr[0] + 1][arr[1]+1][arr[2]+1];

        dfs(0, 0, arr[2]);

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(" ");
        }

    }

    public static void dfs(int a, int b, int c) {

        if (visited[a][b][c]) {
            return;
        }

        if (a == 0) {
            list.add(c);
        }

        visited[a][b][c] = true;

        // a 물통을 비울 때
        if (a != 0) {
            if (a + b <= arr[1]) { // b한테 물을 줄 때
                dfs(0, a+b, c);
            } else {
                dfs(a-(arr[1]-b), arr[1], c);
            }

            if (a + c <= arr[2]) { // c한테 물을 줄 때
                dfs(0, b, a+c);
            } else {
                dfs(a-(arr[2]-c), b, arr[2]);
            }
        }

        // b 물통을 비울 때
        if (b != 0) {
            if (b + a <= arr[0]) { // a한테 물을 줄 때
                dfs(b+a, 0, c);
            } else {
                dfs(arr[0], b-(arr[0]-a), c);
            }

            if (b + c <= arr[2]) { // c한테 물을 줄 때
                dfs(a, 0, b+c);
            } else {
                dfs(a, b-(arr[2]-c), arr[2]);
            }
        }

        // c 물통을 비울 때
        if (c != 0) {
            if (c + a <= arr[0]) {
                dfs(c+a, b, 0);
            } else {
                dfs(arr[0], b, c-(arr[0]-a));
            }

            if (c+b <= arr[1]) {
                dfs(a, c+b, 0);
            } else {
                dfs(a, arr[1], c-(arr[1]-b));
            }
        }

    }
}
