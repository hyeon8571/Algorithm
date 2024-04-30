import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int N;
	
	static int[][] grid;
	
	static boolean[][] visited;
	
	static List<Place> list;
	
	static int max;
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			
			visited = new boolean[N][N];
			
			list = new ArrayList<>();
			
			max = 0;
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					
					if (grid[i][j] == 1 && 1 <= i && i < N-1 && 1 <= j && j < N-1) {
						list.add(new Place(i, j));
					}
				}
			}
			
			backtracking(0, 0, 0);
			
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	public static void backtracking(int depth, int cnt, int length) {
		
		if (depth == list.size()) {
		
			if (cnt > max) {
				max = cnt;
				result = length;
				
			} else if (cnt == max) {
				if(length < result) {
					result = length;
				}
			}
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int dis = 0;
			if (can(i, list.get(depth))) {
				dis = connect(i, list.get(depth));
				backtracking(depth + 1, cnt + 1, length + dis);
				unConnect(i, list.get(depth));
				continue;
			}
			
			backtracking(depth + 1, cnt, length);
			
		}
		
	}
	
	public static boolean can(int dir, Place now) {
		
		boolean flag = true;
		
		int nx = now.x + dx[dir];
		
		int ny = now.y + dy[dir];
		
		while(0 <= nx && nx < N && 0 <= ny && ny < N) {
			if (grid[ny][nx] == 1 || visited[ny][nx]) {
				flag = false;
				break;
			}
			ny += dy[dir];
			nx += dx[dir];
		}
		
		return flag;
	}
	
	public static int connect(int dir, Place now) {

		int nx = now.x + dx[dir];
		int ny = now.y + dy[dir];
		
		int length = 0;
		
		while(0 <= nx && nx < N && 0 <= ny && ny < N) {
			visited[ny][nx] = true;
			length++;
			ny += dy[dir];
			nx += dx[dir];
		}
		
		return length;
	}
	
	public static void unConnect(int dir, Place now) {

		int nx = now.x + dx[dir];
		int ny = now.y + dy[dir];
		
		while(0 <= nx && nx < N && 0 <= ny && ny < N) {
			visited[ny][nx] = false;
			ny += dy[dir];
			nx += dx[dir];
		}
	}
}
