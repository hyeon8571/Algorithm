

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Place {
		int y, x;
		
		public Place(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N;
	
	static int[][] grid;
	
	static boolean[][] visited;
	
	static int[] dx = new int[] {1, 1, -1, -1};
	
	static int[] dy = new int[] {-1, 1, 1, -1};
	
	static List<Integer> desert;
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					visited[i][j] = true;
					desert = new ArrayList<>();
					desert.add(grid[i][j]);
					dfs(i, j, 0);
				}
			}
			
			if (result != 0) {
				System.out.println("#" + t + " " + result);
			} else {
				System.out.println("#" + t + " " + "-1");
			}
			
			
		}
	}

	
	
	public static void dfs(int startY, int startX, int d) {
		
		if (d >= 4) return;
		
		int nx = startX + dx[d];
		int ny = startY + dy[d];
		
		if (0 <= nx && nx < N && 0 <= ny && ny < N) {
			if (!visited[ny][nx]) {
				boolean flag = false;
				
				for (int i = 0; i < desert.size(); i++) {
					if (desert.get(i) == grid[ny][nx]) {
						flag = true;
					}
				}
				
				if (!flag) {
					visited[ny][nx] = true;
					desert.add(grid[ny][nx]);
					dfs(ny, nx, d);
					dfs(ny, nx, d + 1);
					visited[ny][nx] = false;
					desert.remove(desert.size() - 1);
				}
			} else {
				if (grid[ny][nx] == desert.get(0) && desert.get(desert.size() - 2) != grid[ny][nx]) {
					if (desert.size() > result) {
						result = desert.size();
					}
				}
			}
		}
	}
}
