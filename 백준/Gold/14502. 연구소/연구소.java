

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
	
	static int N, M;
	
	static int[][] grid, tmp;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		
		result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0);
		
		System.out.println(result);
		
	}
	
	public static void backtracking(int depth) {
		if (depth == 3) {
			
			tmp = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = grid[i][j];		
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 2) {
						bfs(i, j);
					}
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] == 0) {
						count++;
					}
				}
			}
			
			if (result < count) {
				result = count;
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = 1;
					backtracking(depth + 1);
					grid[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void bfs(int startY, int startX) {
		
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX));
		
		while (!queue.isEmpty()) {
			Place now = queue.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				
				int ny = now.y + dy[i];
				
				if (0 <= nx && nx < M && 0 <= ny && ny < N) {
					if (tmp[ny][nx] == 0) {
						tmp[ny][nx] = 2;
						queue.add(new Place(ny, nx));
					}
				}
			}
		}
	}
	
}
