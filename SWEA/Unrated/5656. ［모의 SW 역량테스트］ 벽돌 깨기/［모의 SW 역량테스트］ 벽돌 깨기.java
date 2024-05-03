import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	
	static class Place {
		int y, x;
		
		public Place(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, W, H;
	
	static int[][] grid;
	
	static int[] arr;
	
	static int[][] temp;

	static int result;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			result = Integer.MAX_VALUE;
			
			arr = new int[N];
			
			grid = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dupPermutation(0);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	// 중복순열로 폭탄 위치 설정
	public static void dupPermutation(int depth) {
		
		if (depth == N) {

			bomb(arr);
			
			return;
		}
		
		for (int i = 0; i < W; i++) {
			arr[depth] = i;
			dupPermutation(depth + 1);
		}
	}
	
	public static void bomb(int[] arr) {
		temp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < H; j++) {
				
				if (temp[j][arr[i]] != 0) {
					pung(j, arr[i]);
					break;
				}
			}
		}
		
		
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j] != 0) {
					cnt++;
				}
			}
		}
		
		if (result > cnt) {
			result = cnt;
		}
		
		
	}
	
	public static void pung(int startY, int startX) {
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX));
		
		while (!queue.isEmpty()) {
			Place now = queue.pollFirst();
			
			int range = temp[now.y][now.x];
			
			temp[now.y][now.x] = 0;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < range; j++) {
					int ny = now.y + dy[i] * j;
					int nx = now.x + dx[i] * j;
					
					if (0 <= ny && ny < H && 0 <= nx && nx < W) {
						if (temp[ny][nx] != 0) {
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
				if (temp[j][i] != 0) {
					if (temp[j + 1][i] == 0) {
						temp[j+1][i] = temp[j][i];
						temp[j][i] = 0;
						down();
					}
				}
			}
		}
	}
	
}
