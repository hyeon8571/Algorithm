

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K;
	
	static int[][] grid;
	
	static boolean[][] visited;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			K = Integer.parseInt(st.nextToken());
			
			grid = new int[N][N];
			
			result = 0;
			
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					
					if (grid[i][j] > max) {
						max = grid[i][j];
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == max) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						go(i, j, false, 1);
						
					}
				}
			}
			
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	
	public static void go(int startY, int startX, boolean flag, int cnt) {
		
		if (cnt > result) {
			result = cnt;
			
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = startX + dx[i];
			int ny = startY + dy[i];
			
			if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
				if (grid[ny][nx] < grid[startY][startX]) {
					visited[ny][nx] = true;
					go(ny, nx, flag, cnt+1);
					visited[ny][nx] = false;
				} else if (grid[ny][nx] >= grid[startY][startX]){
					if (!flag && (grid[ny][nx] - grid[startY][startX]) < K) {
						visited[ny][nx] = true;
						int temp = grid[ny][nx];
						grid[ny][nx] =  grid[startY][startX] -1;
						go(ny, nx, true, cnt+1);
						grid[ny][nx] =  temp;
						visited[ny][nx] = false;
					} 
				}
			} 
			
		}
	}
	
}
