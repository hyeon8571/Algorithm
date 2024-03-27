
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Place {
		int x, y;
		
		public Place(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N;
	
	static int[][] grid;
	
	static int me;
	
	static int[] like = new int[4];
	
	static int[][] likeTemp;
	
	static int[] dx = new int[] {0, 1, 0, -1};
	
	static int[] dy = new int[] {-1, 0, 1, 0};
	
	static int dap;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		grid = new int[N][N];
		
		likeTemp = new int[N*N + 1][4];
		
		for (int j = 0; j < N*N; j++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 5; i++) {
				if (i == 0) {
					me = Integer.parseInt(st.nextToken());
				} else {
					like[i-1] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				likeTemp[me][i] = like[i];
			}
			
			batch(me, like);
		}
		
		
		
		happyPoint();
		
		System.out.println(dap);
		
	}
	
	// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
	
	// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
	
	// 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
	
	public static void batch(int my, int[] friend) {
		
		List<Place> list = findLike(friend);
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println("y: " + list.get(i).y + " " + "x: " + list.get(i).x);
//		}
//		System.out.println();

		if (list.size() != 1) {
			List<Place> emptyList = checkEmpty(list);
		
			grid[emptyList.get(0).y][emptyList.get(0).x] = my;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(grid[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		} else {
			grid[list.get(0).y][list.get(0).x] = my;
		}
	}
	
	
	public static List<Place> findLike(int[] friend) {
		
		int max = 0;
		
		int[][] checkFriends = new int[N][N];
		
		List<Place> result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0) {
					
					int cnt = 1;
					
					for (int k = 0; k < 4; k++) {
						
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if (0 <= nx && nx < N && 0 <= ny && ny < N) {				
							
							for (int t = 0; t < 4; t++) {
								if (grid[ny][nx] == friend[t]) {
									cnt++;
								}
							}
							
							checkFriends[i][j] = cnt;
							
							if (cnt > max) {
								max = cnt;
							}
							
						}
						
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (checkFriends[i][j] == max) {
					result.add(new Place(i, j));
				}
			}
		}
	
		return result;
	}
	
	public static List<Place> checkEmpty(List<Place> list) {
		
		List<Place> result = new ArrayList<>();
		
		int[][] empty = new int[N][N];
		
		int max = 0;
		
		for (int i = 0; i < list.size(); i++) {
			
			int cnt = 0;
			
			for (int j = 0; j < 4; j++) {
				int nx = list.get(i).x + dx[j];
				
				int ny = list.get(i).y + dy[j];
				
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (grid[ny][nx] == 0) {
						cnt++;
					}
				}
			}
			
			empty[list.get(i).y][list.get(i).x] = cnt;
			
			if (cnt > max) {
				max = cnt;
			}
			
		}
	
		for (int i = 0; i < list.size(); i++) {
			if (empty[list.get(i).y][list.get(i).x] == max) {
				result.add(new Place(list.get(i).y, list.get(i).x));
			}
			
		}
		
		return result;
	}
	
	
	
	public static void happyPoint() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int na = grid[i][j];
				
				int cnt = 0;
				
				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					
					if (0 <= nx && nx < N && 0 <= ny && ny < N) {
						for (int m = 0; m < 4; m++) {
							if (grid[ny][nx] == likeTemp[na][m]) {
								cnt++;
							}
						}
					}
				}
				
				if (cnt == 1) {
					dap += 1;
				} else if (cnt == 2) {
					dap += 10;
				} else if (cnt == 3) {
					dap += 100;
				} else if (cnt == 4) {
					dap += 1000;
				}
				
			}
		}
	}
}
