

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	
	public static class Place {
		int y, x;
		
		public Place(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, W, H;
	
	static int[][] grid, tmp;
	
	static int[] arr;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int cnt;
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			W = Integer.parseInt(st.nextToken());
			
			H = Integer.parseInt(st.nextToken());
			
			grid = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			arr = new int[N];
			
			cnt = 0;
			
			result = Integer.MAX_VALUE;
		
			choice(0);
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	// 중복순열 (W 중에서 N개 뽑기)
	public static void choice(int depth) {
		
		if (depth == N) {
			test(arr);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			arr[depth] = i;
			choice(depth + 1);
		}
	}
	
	public static void test(int[] order) {
		
		tmp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = grid[i][j];
			}
		}
		
		for (int k = 0; k < order.length; k++) { 
			
			for (int i = 0; i < H; i++) {
				if (tmp[i][order[k]] != 0) {
					
					boom(i, order[k]);
					
					break;
		
				}
			}
			
		}
		
		int count = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmp[i][j] != 0) {
					count++;
				}
			}
		}
		
		if (count < result) {
			result = count;
		}
	}
	
	public static void boom(int startY, int startX) {
		
		
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX));
		
		while(!queue.isEmpty()) {
			
			Place now = queue.pollFirst();
			
			int range = tmp[now.y][now.x];
			
			tmp[now.y][now.x] = 0;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < range; j++) {
					int nx = now.x + dx[i] * j;
					int ny = now.y + dy[i] * j;
					
					if (0 <= nx && nx < W && 0 <= ny && ny < H) {
						if (tmp[ny][nx] != 0) {
							queue.add(new Place(ny, nx));
						}
					}
				}
			}
		}	
		
		down();
		
	}
	
	public static void down() {
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H - 1; j++) {
				if (tmp[j][i] != 0) {
					if (tmp[j+1][i] == 0) {
						tmp[j+1][i] = tmp[j][i];
						tmp[j][i] = 0;
						down();
					}
				}
			}
		}
		
	}
	
}
