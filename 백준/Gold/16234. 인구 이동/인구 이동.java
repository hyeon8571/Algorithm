
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] grid;
    static int L, R;

    static boolean[][] visited;

    public static class Place {
        int y, x;
        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while (true) {
            visited = new boolean[N][N];

            boolean flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (move(i, j)) {
                            flag = true;                            
                        }
                    }
                }
            }

            if (flag) {
                day++;
            } else {
                break;
            }
        }

        System.out.println(day);

    }

    public static boolean move(int startY, int startX) {
        // bfs로 방문할 수 있는 위치 체크

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        Queue<Place> queue = new ArrayDeque<>();
        List<Place> placeList = new ArrayList<>();

        queue.add(new Place(startY, startX));
        visited[startY][startX] = true;
        boolean flag = false;
        
        int totalVal = grid[startY][startX];
        int cnt = 1;
        placeList.add(new Place(startY, startX));

        while (!queue.isEmpty()) {
            Place now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    int diff = Math.abs(grid[now.y][now.x] - grid[ny][nx]);

                    if (L <= diff && diff <= R && !visited[ny][nx]) {
                        
                        placeList.add(new Place(ny, nx));
                        
                        totalVal += grid[ny][nx];
                        cnt++;
                        
                        flag = true;
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx));
                    }
                }
            }
        }
        
        if (flag) { // 업데이트
            int avgVal = totalVal / cnt;
            
            for (int i = 0; i < placeList.size(); i++) {
                grid[placeList.get(i).y][placeList.get(i).x] = avgVal;
            }
        }
        

        return flag;

    }
}
