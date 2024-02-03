package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Place {
    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_2178 {

    static int row;

    static int col;

    static int[][] arr;

    static boolean[][] visited;

    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];

        distance = new int[row][col];

        distance[0][0] = 1;

        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    BFS(i, j);
                }
            }
        }
        System.out.println(distance[row-1][col-1]);
    }

    public static void BFS(int y, int x) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        Place now = new Place(x, y);

        queue.add(now);

        int[] dx = new int[] {0, 1, 0, -1}; // 좌우로 이동
        int[] dy = new int[] {-1, 0, 1, 0}; // 상하로 이동

        while(!queue.isEmpty()) {

            now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < col && ny >= 0 && ny < row) {
                    if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.add(new Place(nx, ny));
                        visited[ny][nx] = true;
                        distance[ny][nx] = distance[now.y][now.x] + 1;
                    }
                }
            }

        }
    }
}