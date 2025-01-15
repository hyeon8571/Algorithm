import java.io.*;
import java.util.*;

public class Main {

    static String[][] grid;

    static int[] dx = new int[] {0, 1, -1};
    static int[] dy = new int[] {0, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int x = 2*N-1;

        grid = new String[N][x];


        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], " ");
        }

        star(N, 0, x/2);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void star(int distance, int startY, int startX) {
        if (distance == 1) {
            grid[startY][startX] = "*";
            return;
        }

        for (int i = 0; i < 5; i++) {
            grid[startY+2][startX-2+i] = "*";
        }

        for (int i = 0; i < 3; i++) {
            star(distance/2, startY + dy[i]*distance/2, startX + dx[i]*distance/2);
        }
    }
}
