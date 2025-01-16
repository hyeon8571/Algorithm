import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] num;
    static int[] choice;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[N];
        choice = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        duplePermutation(0);

        System.out.println(sb);
    }

    public static void duplePermutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (prev == num[i]) {
                continue;
            }

            choice[depth] = num[i];
            prev = num[i];
            duplePermutation(depth+1);
        }
    }
}
