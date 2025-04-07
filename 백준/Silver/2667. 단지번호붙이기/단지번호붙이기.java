

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Place {
        int y, x;
        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] grid;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    result.add(bfs(i, j, 1));
                }
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for (int a : result) {
            System.out.println(a);
        }

    }

    public static int bfs(int startY, int startX, int count) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        visited[startY][startX] = true;
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(startY, startX));

        while (!queue.isEmpty()) {

            Place now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                   if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                       visited[ny][nx] = true;
                       queue.add(new Place(ny, nx));
                       count++;
                   }
                }
            }
        }
        return count;
    }
}
