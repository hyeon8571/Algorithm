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
    
    
    static int N;
    static int[][] grid;
    static int[][] distance;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = 1;
        
        while (true) {
            N = Integer.parseInt(br.readLine());
            
            if (N == 0) {
                break;
            }
            
            grid = new int[N][N];
            distance = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());                    
                }
            }
            
            bfs();
            System.out.println("Problem " + num + ": " + distance[N-1][N-1]);
            num++;      
        }
        
        
    }
    
    public static void bfs() {
        int[] dy = new int[] {-1, 0, 1, 0};
        int[] dx = new int[] {0, 1, 0, -1};
        
        Queue<Place> queue = new ArrayDeque<>();
        
        int val = grid[0][0];
        distance[0][0] = val;
        
        queue.add(new Place(0, 0));
        
        while (!queue.isEmpty()) {
            Place now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    
                    if (ny == N-1 && nx == N-1 && grid[ny][nx] == 0) {
						return;
					}
                    
                    if (distance[ny][nx] == 0) {
                        distance[ny][nx] = grid[ny][nx] + distance[now.y][now.x];
                        queue.add(new Place(ny, nx));
                    } else if (grid[ny][nx] + distance[now.y][now.x] < distance[ny][nx]) {
                        distance[ny][nx] = grid[ny][nx] + distance[now.y][now.x];
                        queue.add(new Place(ny, nx));
                    }
                }
            }
        }
    }
}
