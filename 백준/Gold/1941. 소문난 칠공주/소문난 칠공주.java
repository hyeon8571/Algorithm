import java.util.*;
import java.io.*;

public class Main {

    public static class Place {
        int y, x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Character[][] grid;
    static Place[] choice;
    static Place[] arr;
    static boolean[][] visited;
    static boolean[][] can;
    static int result = 0;

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new Character[5][5];
        choice = new Place[7];
        arr = new Place[25];

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = str.charAt(j);
                arr[idx] = new Place(i, j);
                idx++;
            }
        }

        combination(0, 0);

        System.out.println(result);
    }

    public static void combination(int depth, int idx) {
        if (depth == 7) {
            int sCnt = 0;
            for (int i = 0; i < 7; i++) {
                if (grid[choice[i].y][choice[i].x] == 'S') {
                    sCnt++;
                }
            }

            if (sCnt >= 4) {
                visited = new boolean[5][5];
                can = new boolean[5][5];
                for (int i = 0; i < 7; i++) {
                    can[choice[i].y][choice[i].x] = true;
                }

                if (bfs()) {
                    result++;
                }
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            choice[depth] = arr[i];
            combination(depth+1, i+1);
        }
    }

    public static boolean bfs() {
        ArrayDeque<Place> queue = new ArrayDeque<>();
        queue.add(new Place(choice[0].y, choice[0].x));
        visited[choice[0].y][choice[0].x] = true;

        while (!queue.isEmpty()) {
            Place p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                    if (!visited[ny][nx] && can[ny][nx]) {
                        queue.add(new Place(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < 7; i++) {
            if (!visited[choice[i].y][choice[i].x]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
