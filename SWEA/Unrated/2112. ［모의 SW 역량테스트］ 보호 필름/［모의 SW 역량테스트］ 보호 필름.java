
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int D, W, K;

    static int[][] grid;

    static int[] fill;

    static int[] arr;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());

            W = Integer.parseInt(st.nextToken());

            K = Integer.parseInt(st.nextToken());

            grid = new int[D][W];

            fill = new int[D];

            result = Integer.MAX_VALUE;

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (K == 1) {
                System.out.println("#" + t + " " + "0");
                continue;
            }

            backtracking(0, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    public static boolean test() {

        int cnt = 0;

        int prev = 0;

        for (int i = 0; i < W; i++) {

            int max = 0;

            for (int j = 0; j < D; j++) {

                if (fill[j] == 1) {
                    if (j == 0) {
                        cnt = 1;
                        prev = 0;
                    } else {
                        if (0 == prev) {
                            cnt++;
                        } else {
                            prev = 0;
                            cnt = 1;
                        }

                    }

                } else if (fill[j] == 2) {

                    if (j == 0) {
                        cnt = 1;
                        prev = 1;
                    } else {
                        if (1 == prev) {
                            cnt++;
                        } else {
                            prev = 1;
                            cnt = 1;
                        }

                    }

                } else {
                    if (j == 0) {
                        cnt = 1;
                        prev = grid[j][i];
                    } else {
                        if (grid[j][i] == prev) {
                            cnt++;
                        } else {
                            prev = grid[j][i];
                            cnt = 1;
                        }

                    }
                }

                if (cnt > max) {
                    max = cnt;
                }
            }


            if (max < K) {
                return false;
            }

        }

        return true;

    }

    static void backtracking(int depth, int startIdx) {

            if (depth >= result) {
                return;
            }


            if (test()) {
                if (depth < result) {
                    result = depth;
                    return;
                }
            }
            
        for (int i = startIdx; i < D; i++) {
            fill[i] = 1;
            backtracking(depth + 1, i + 1);
            fill[i] = 2;
            backtracking(depth + 1, i + 1);
            fill[i] = 0;
        }
    }
}
