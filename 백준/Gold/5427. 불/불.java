import java.util.*;
import java.io.*;

public class Main {

    public static class Place {
        int y;
        int x;
        int time;

        public Place(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int w;
    static int h;
    static int result;

    static char[][] grid;
    static int[][] visited;

    static ArrayDeque<Place> queue;

    static int[] dirX = new int[] {0, 1, 0, -1};
    static int[] dirY = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 가로
            h = Integer.parseInt(st.nextToken()); // 세로

            grid = new char[h][w];
            visited = new int[h][w];

            result = Integer.MAX_VALUE;

            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    grid[j][k] = str.charAt(k);
                }
            }

            queue = new ArrayDeque<>();

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (grid[j][k] == '*') {
                        queue.addFirst(new Place(j, k, 0));
                    }

                    if (grid[j][k] == '@') {
                        queue.addLast(new Place(j, k, 0));
                    }
                }
            }

            bfs();

            if (result == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }

        }
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Place p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dirY[i];
                int nx = p.x + dirX[i];

                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (grid[p.y][p.x] == '*') {
                        if (grid[ny][nx] == '.') {
                            grid[ny][nx] = '*';
                            queue.add(new Place(ny, nx, 0));
                        }
                    } else if (grid[p.y][p.x] == '@') {
                        if (grid[ny][nx] == '.') {
                            visited[ny][nx] = visited[p.y][p.x] + 1;
                            grid[ny][nx] = '@';
                            queue.add(new Place(ny, nx, visited[p.y][p.x] + 1));
                        }
                    }
                } else {
                    if (grid[p.y][p.x] == '@') {
                        result = Math.min(visited[p.y][p.x] + 1, result);
                    }
                }
            }
        }
    }
}
