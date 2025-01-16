import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] numArr;
    static boolean[] visited;
    static int[] choice;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numArr = new int[N];
        choice = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        makePermutation(0);
        System.out.println(sb);
    }

    public static void makePermutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            choice[depth] = numArr[i];
            visited[i] = true;
            makePermutation(depth + 1);
            visited[i] = false;
        }
    }


}
