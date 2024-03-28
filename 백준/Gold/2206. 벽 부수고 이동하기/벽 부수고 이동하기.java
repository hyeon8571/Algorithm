

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Place {
		int y, x, cnt;
		
		public Place(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	
	static int[][] grid;
	
	static int[][][] distance;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		
		distance = new int[2][N][M];
		
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		if (distance[0][N-1][M-1] == 0) {
			if (distance[1][N-1][M-1] == 0) {
				System.out.println(-1);
			} else {
				System.out.println(distance[1][N-1][M-1]);
			}
		} else {
			if (distance[1][N-1][M-1] != 0 && distance[0][N-1][M-1] > distance[1][N-1][M-1]) {
				System.out.println(distance[1][N-1][M-1]);
			} else {
				System.out.println(distance[0][N-1][M-1]);
			}
		}
		
	}
	
	public static void bfs(int startY, int startX) {
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX, 0));
		distance[0][startY][startX] = 1;
		
		while (!queue.isEmpty()) {
			
			Place now = queue.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (0 <= nx && nx < M && 0 <= ny && ny < N && now.cnt <= 1) {
					if (grid[ny][nx] == 0 && distance[now.cnt][ny][nx] == 0) {
						distance[now.cnt][ny][nx] = distance[now.cnt][now.y][now.x] + 1;
						queue.add(new Place(ny, nx, now.cnt));
					} else if (grid[ny][nx] == 0 && distance[now.cnt][ny][nx] != 0) {
						if (distance[now.cnt][ny][nx] > distance[now.cnt][now.y][now.x] + 1) {
							distance[now.cnt][ny][nx] = distance[now.cnt][now.y][now.x] + 1;
							queue.add(new Place(ny, nx, now.cnt));
						}
					} else if (grid[ny][nx] == 1 && now.cnt+1 < 2 && distance[now.cnt + 1][ny][nx] == 0) {
						distance[now.cnt + 1][ny][nx] = distance[now.cnt][now.y][now.x] + 1;
						queue.add(new Place(ny, nx, now.cnt+1));
					} else if (grid[ny][nx] == 1 && now.cnt+1 < 2 && distance[now.cnt + 1][ny][nx] != 0) {
						if (distance[now.cnt + 1][ny][nx] > distance[now.cnt][now.y][now.x] + 1) {
							distance[now.cnt + 1][ny][nx] = distance[now.cnt][now.y][now.x] + 1;
							queue.add(new Place(ny, nx, now.cnt + 1));
					}
					}
				}
			}
		}
	}
	
}
