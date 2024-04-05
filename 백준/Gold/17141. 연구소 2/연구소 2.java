

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
	
	static int N, M;
	
	static int[][] grid, tmp, distance, tmp2;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int result;
	
	static ArrayDeque<Place> queue;
	
	static List<Place> canVirus;
	
	static Place[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][N];
		
		result = Integer.MAX_VALUE;
		
		queue = new ArrayDeque<>();
		
		canVirus = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) {
					canVirus.add(new Place(i, j));
					grid[i][j] = 0;
				}
			}
		}
		
		backtracking(0, 0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
	}
	
	
	
	public static void backtracking(int depth, int startIdx) {
		if (depth == M) {
			
			distance = new int[N][N];
			
			tmp = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp[i][j] = grid[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == 3) {
						queue.add(new Place(i, j));
					}
				}
			}
			bfs();
						
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (tmp[i][j] == 0) {
						return;
					}
					if (distance[i][j] > max) {
						max = distance[i][j];
					}
				}
			}
			
			if (max < result) {
				result = max;
			}
			
			return;
		}
		
		for (int i = startIdx; i < canVirus.size(); i++) {
			int x = canVirus.get(i).x;
			int y = canVirus.get(i).y;
			
			grid[y][x] = 3;
			backtracking(depth + 1, i + 1);
			grid[y][x] = 0;
		}
		
	}
	
	public static void bfs() {
				
		
		while(!queue.isEmpty()) {
			Place now = queue.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				
				int ny = now.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (tmp[ny][nx] == 0 || tmp[ny][nx] == 2) {
						tmp[ny][nx] = 3;
						distance[ny][nx] = distance[now.y][now.x] + 1;
						queue.add(new Place(ny, nx));
					} else if (tmp[ny][nx] == 3) {
						if (distance[ny][nx] > distance[now.y][now.x] + 1) {
							distance[ny][nx] = distance[now.y][now.x] + 1;
							queue.add(new Place(ny, nx));
						}
					}
				}
			}
		}
	}
	
}
