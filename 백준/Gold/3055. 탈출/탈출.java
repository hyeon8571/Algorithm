

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Place {
        int y, x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int R, C;

    static Character[][] grid;

    static Place start, end;

    static int[][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int cnt;

    static boolean flag;

    static List<Place> waterStart;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());

        C = Integer.parseInt(st.nextToken());

        grid = new Character[R][C];

        visited = new int[R][C];


        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = str.charAt(j);
                if (grid[i][j] == 'S') {
                    start = new Place(i, j);
                } else if (grid[i][j] == 'D') {
                    end = new Place(i, j);
                }
            }
        }

        move(start.y, start.x);

        if (visited[end.y][end.x] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(visited[end.y][end.x] - 1);
        }

    }

    public static void move(int startY, int startX) {

        int max = 1;
        ArrayDeque<Place> queue = new ArrayDeque<>();
        water();
        queue.add(new Place(startY, startX));
        visited[startY][startX] = 1;

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            if (visited[now.y][now.x] > max) {
                max = visited[now.y][now.x];
                water();
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if ((grid[ny][nx] == '.' || grid[ny][nx] == 'D') && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[now.y][now.x] + 1;
                        queue.add(new Place(ny, nx));
                    }
                }

            }

        }

    }

    public static void water() {
        waterStart = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '*') {
                    waterStart.add(new Place(i, j));
                }
            }
        }

        for (int i = 0; i < waterStart.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int nx = waterStart.get(i).x + dx[j];
                int ny = waterStart.get(i).y + dy[j];

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (grid[ny][nx] != 'X' && grid[ny][nx] != 'D') {
                        grid[ny][nx] = '*';
                    }
                }
            }
        }


    }
}
