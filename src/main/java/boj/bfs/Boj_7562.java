package boj.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_7562 {

    public static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;


    static int goalY;

    static int goalX;

    static boolean[][] visited;

    static int[][] distance;

    static ArrayDeque<Place> queue;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            queue = new ArrayDeque<>();

            N = Integer.parseInt(br.readLine());

            visited = new boolean[N][N];

            distance = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int nowY = Integer.parseInt(st.nextToken());

            int nowX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            goalY = Integer.parseInt(st.nextToken());

            goalX = Integer.parseInt(st.nextToken());

            queue.add(new Place(nowX, nowY));

            visited[nowY][nowX] = true;

            if (nowX == goalX && nowY == goalY) {
                System.out.println(0);
            } else {
                System.out.println(BFS(nowY, nowX));
            }

        }
    }

    public static int BFS(int y, int x) {

        int[][] move = new int[][] {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

        while(!queue.isEmpty()) {

            Place now = queue.pollFirst();

            for (int i = 0; i < 8; i++) {

                int nx = now.x + move[i][1];
                int ny = now.y + move[i][0];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (nx == goalX && ny == goalY) {
                        return distance[now.y][now.x] + 1;
                    } else {
                        if (!visited[ny][nx]) {
                            queue.add(new Place(nx, ny));
                            visited[ny][nx] = true;
                            distance[ny][nx] = distance[now.y][now.x] + 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}
