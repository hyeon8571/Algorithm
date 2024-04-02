import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	
	static class Place {
		int y, x, time;
		
		public Place(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static int N;
	
	static int[][] grid;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int[][] visited;
	
	static int totalTime;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			
			visited = new int[N][N];
			
			StringTokenizer st = null;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			
			int startY = Integer.parseInt(st.nextToken());
			
			int startX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int endY = Integer.parseInt(st.nextToken());
			
			int endX = Integer.parseInt(st.nextToken());
			
			bfs(startY, startX);
			
			if (visited[endY][endX] == 0) {
				System.out.println(("#" + t + " " + "-1"));
				continue;
			}
			
			
			
			System.out.println("#" + t + " " + visited[endY][endX]);
			
			
		}
	}
	
	public static void bfs(int startY, int startX) {
		ArrayDeque<Place> queue = new ArrayDeque<>();
		
		queue.add(new Place(startY, startX, 0));
		
		while (!queue.isEmpty()) {
			Place now = queue.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (grid[ny][nx] != 1) {
						
						if (grid[ny][nx] == 2 && visited[ny][nx] == 0) {
							
							if((now.time) % 3 == 2) { // todo
								visited[ny][nx] = now.time+1;
								queue.add(new Place(ny, nx, now.time+1));
								
							} else {
								visited[ny][nx] = now.time + 1 + (2 - now.time % 3);
								queue.add(new Place(ny, nx, now.time + 1 + (2 - now.time % 3)));
								//queue.add(new Place(now.y, now.x, now.time + 1));
							}
							
						} else if (grid[ny][nx] == 2 && visited[ny][nx] != 0) {
							if(now.time % 3 == 2) {
								
								if (visited[ny][nx] > now.time + 1) {
									
									visited[ny][nx] = now.time + 1;
									queue.add(new Place(ny, nx, now.time+1));
									
								}
								
							} else {
								if (visited[ny][nx] >  now.time + 1 + (2 - now.time % 3)) {
									
									visited[ny][nx] =  now.time + 1 + (2 - now.time % 3);
									queue.add(new Place(ny, nx, now.time + 1 + (2 - now.time % 3)));
									
								}
							}
						} else if (grid[ny][nx] == 0 && visited[ny][nx] == 0) {
							
							visited[ny][nx] = now.time + 1;
							queue.add(new Place(ny, nx, now.time + 1));
							
						} else if (grid[ny][nx] == 0 && visited[ny][nx] != 0) {
							
							if (visited[ny][nx] > now.time + 1) {
								visited[ny][nx] = now.time + 1;
								queue.add(new Place(ny, nx, now.time + 1));
							}
							
						}
						
					}
					
				}
			}
		}
	}
}
