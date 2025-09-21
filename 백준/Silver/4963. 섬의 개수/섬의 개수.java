import java.io.*;
import java.util.*;

public class Main {
    
    public static class Place {
        int y, x;
        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static int[][] grid;
    public static int h, w;
    public static boolean[][] visited;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());            
            w = Integer.parseInt(st.nextToken()); // 가로
            h = Integer.parseInt(st.nextToken()); // 세로
            
            if (w == 0 && h == 0) {
                break;
            }
            
            // 연결된 섬은 하나로 본다.
            grid = new int[h][w];
            visited = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());            
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result = 0;
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            
            System.out.println(result);
            
        }
    }
    
    public static void bfs(int y, int x) {
        int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
        
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(y, x));
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            Place now = queue.poll();
            
            for (int i = 0; i < 8; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (0 <= ny && ny < h && 0 <= nx && nx < w) {
                   if (!visited[ny][nx] && grid[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new Place(ny, nx));
                    }
                }
            }
            
        }
    }
}
