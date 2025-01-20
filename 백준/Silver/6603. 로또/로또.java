import java.util.*;
import java.io.*;

public class Main {

    static int[] num;
    static int[] choice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                return;
            }
            num = new int[n];
            choice = new int[6];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0, sb);
            System.out.println(sb);
        }

    }

    public static void combination(int depth, int idx, StringBuilder sb) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < num.length; i++) {
            choice[depth] = num[i];
            combination(depth+1, i+1, sb);
        }
    }
}
