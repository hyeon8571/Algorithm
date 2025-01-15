import java.util.*;
import java.io.*;

public class Main {

    static int[] result = new int[3];
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        grid = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(grid);

        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    public static void paper(int[][] grid) {

        if (grid.length == 1) {
            if (grid[0][0] == -1) {
                result[0]++;
            } else if (grid[0][0] == 0) {
                result[1]++;
            } else {
                result[2]++;
            }

            return;
        }

        if (check(grid)) {
            if (grid[0][0] == -1) {
                result[0]++;
            } else if (grid[0][0] == 0) {
                result[1]++;
            } else {
                result[2]++;
            }
        } else {
            int t = grid.length / 3;
            int[][] grid2 = new int[t][t];

            for (int k = 0; k < 3; k++) {
                for (int h = 0; h < 3; h++) {
                    for (int i = 0; i < t; i++) {
                        for (int j = 0; j < t; j++) {
                            grid2[i][j] = grid[i+t*k][j+t*h];
                        }
                    }
                    paper(grid2);
                }
            }

        }
    }

    public static boolean check(int[][] grid) {
        int size = grid.length;
        int pre = grid[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pre != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
