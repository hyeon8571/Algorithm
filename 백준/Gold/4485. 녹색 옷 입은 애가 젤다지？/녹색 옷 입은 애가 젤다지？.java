

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Place {
		int y, x;
		
		public Place(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N;
	
	static int[][] grid;
	
	static int[][] visited;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) {
				return;
			}
			
			grid = new int[N][N];
			
			visited = new int[N][N];
			
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] == 0) {
						count++;
					}
				} 
			}
			
			bfs(0, 0);
			System.out.println("Problem " + cnt++ + ": " + visited[N-1][N-1]);
			
		}
		
	}
	
	public static void bfs(int startY, int startX) {
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX));
		visited[startY][startX] = grid[startY][startX];
		
		while (!queue.isEmpty()) {
			Place now = queue.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (ny == N-1 && nx == N-1 && grid[ny][nx] == 0) {
						return;
					}
					if (visited[ny][nx] == 0) {
						visited[ny][nx] = visited[now.y][now.x] + grid[ny][nx];
						queue.add(new Place(ny, nx));
					} else {
						if (visited[ny][nx] > visited[now.y][now.x] + grid[ny][nx]) {
							visited[ny][nx] = visited[now.y][now.x] + grid[ny][nx];
							queue.add(new Place(ny, nx));
						}
					}
				}
			}
		}
	}
}
