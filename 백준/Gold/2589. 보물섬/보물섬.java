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
    
    public static int N, M, result;
    public static Character[][] grid;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new Character[N][M];
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(result);
    }
    
    public static void bfs(int y, int x) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        int[][] visited = new int[N][M];
        visited[y][x] = 1;
        
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(y, x));
        
        while (!queue.isEmpty()) {
            Place now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (grid[ny][nx] == 'L') {
                        if (visited[ny][nx] == 0) {
                            visited[ny][nx] = visited[now.y][now.x] + 1;
                            result = Math.max(result, visited[ny][nx]-1);
                            queue.add(new Place(ny, nx));
                        }
                    }
                }
            }
        }
    } 
}
