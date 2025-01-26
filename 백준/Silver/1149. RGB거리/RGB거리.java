import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[][] cost = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    cost[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            cost[i][1] = Math.min(cost[i-1][2], cost[i-1][3]) + arr[i][1];
            cost[i][2] = Math.min(cost[i-1][1], cost[i-1][3]) + arr[i][2];
            cost[i][3] = Math.min(cost[i-1][1], cost[i-1][2]) + arr[i][3];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (cost[N][i] < result) {
                result = cost[N][i];
            }
        }

        System.out.println(result);

    }
}
