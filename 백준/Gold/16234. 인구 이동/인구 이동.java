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
    
    public static int[][] grid;
    public static boolean[][] visited;
    public static int L, R, N;
    public static boolean flag;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        grid = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = 0;
        
        while (true) {
            
            visited = new boolean[N][N];
            flag = false;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            
            // 하루동안 update가 한번도 일어나지 않는다면 
            if (!flag) {
                break;
            }
            
            result++;
        }
        
        
        System.out.println(result);
    }
    
    public static void bfs(int y, int x) {
        
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        
        Queue<Place> queue = new ArrayDeque<>();
        List<Place> update = new ArrayList<>();
        queue.add(new Place(y, x));
        update.add(new Place(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            
            Place now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    
                    if (!visited[ny][nx]) {
                        if (L <= Math.abs(grid[ny][nx] - grid[now.y][now.x]) && Math.abs(grid[ny][nx] - grid[now.y][now.x]) <= R) {
                            flag = true;
                            visited[ny][nx] = true;
                            queue.add(new Place(ny, nx));
                            update.add(new Place(ny, nx));
                        }
                    }
                }
            }
        }
        
        
        if (!flag) {
            return;
        }
        
        // 업데이트 시작
        int totalSize = update.size();
  //      System.out.println("size: " + totalSize);
        
        
        int totalVal = 0;
        
        for (int i = 0; i < totalSize; i++) {
            totalVal += grid[update.get(i).y][update.get(i).x];
        }
//        System.out.println("total: " + totalVal);
        
        int updateVal = totalVal / totalSize;
        
  //      System.out.println(updateVal);
        
        for (int i = 0; i < totalSize; i++) {
            grid[update.get(i).y][update.get(i).x] = updateVal;
        }
        
    }
}
