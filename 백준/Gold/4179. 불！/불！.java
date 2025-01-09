import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R;
    static int C;

    static ArrayDeque<Place> queue = new ArrayDeque<>();

    static Character[][] grid;

    static int[][] distance;

    static boolean[][] visited;

    static boolean survive = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행

        C = Integer.parseInt(st.nextToken()); // 렬

        grid = new Character[R][C];

        distance = new int[R][C];

        visited = new boolean[R][C];

        // 맵 셋팅
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        // 불과 지훈이의 좌표를 큐에 삽입
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'J') {
                    queue.addFirst(new Place(j, i));
                    distance[i][j] = 1;
                } else if (grid[i][j] == 'F') {
                    queue.addLast(new Place(j, i));
                }
            }
        }

        int maxDistance = BFS();

        if (survive) {
            System.out.println(maxDistance);
        } else {
            System.out.println("IMPOSSIBLE ");
        }
    }

    public static int BFS() {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (grid[now.y][now.x] == 'J') {
                        if (grid[ny][nx] == '.') {
                            grid[ny][nx] = 'J';
                            queue.add(new Place(nx, ny));
                            distance[ny][nx] = distance[now.y][now.x] + 1;
                        }
                    } else {
                        if (grid[ny][nx] == '.' || grid[ny][nx] == 'J') {
                            grid[ny][nx] = 'F';
                            queue.add(new Place(nx, ny));
                        }
                    }
                } else {
                    if (grid[now.y][now.x] == 'J') {
                        return distance[now.y][now.x];
                    }
                }
            }
        }
        survive = false;
        return 0;
    }

}
