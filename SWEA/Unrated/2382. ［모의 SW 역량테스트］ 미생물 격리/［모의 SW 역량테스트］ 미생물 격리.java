

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Virus {
		int y, x, num, dir, move;
		
		public Virus(int y, int x, int num, int dir, int move) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
			this.move = move;
		}
	}
	
	static int N, M;

	static int moveCnt;
	
	static List<Virus>[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			grid = new List[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = new ArrayList<>();
				}
			}
			
			int K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				grid[y][x].add(new Virus(y, x, num, dir, 0));
				
			}
			
			moveCnt = 0;
			
			for (int i = 0; i < M; i++) {
				
				moveCnt++;
				// 실험
				test();
			}
			
			long result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j].size() != 0) {
						result += grid[i][j].get(0).num;
					}
				}
			}
			
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	public static void test() {
		
		// 이동
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j].size() != 0 && grid[i][j].get(0).move < moveCnt) {
					
					int dir = grid[i][j].get(0).dir;
					
					if (dir == 1) { // 상
						if (i-1 == 0) {
							int num = grid[i][j].get(0).num / 2;
							dir = 2;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i-1][j].add(new Virus(i-1, j, num, dir, move+1));
						} else {
							int num = grid[i][j].get(0).num;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i-1][j].add(new Virus(i-1, j, num, dir, move+1));
						}
					} else if (dir == 2) { // 하
						if (i+1 == N-1) {
							int num = grid[i][j].get(0).num / 2;
							dir = 1;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i+1][j].add(new Virus(i+1, j, num, dir, move+1));
						} else {
							int num = grid[i][j].get(0).num;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i+1][j].add(new Virus(i+1, j, num, dir, move+1));
						}
					} else if (dir == 3) { // 좌
						if (j-1 == 0) {
							int num = grid[i][j].get(0).num / 2;
							dir = 4;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i][j-1].add(new Virus(i, j-1, num, dir, move+1));
						} else {
							int num = grid[i][j].get(0).num;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i][j-1].add(new Virus(i, j-1, num, dir, move+1));
						}
					} else {
						if (j+1 == N-1) {
							int num = grid[i][j].get(0).num / 2;
							dir = 3;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i][j+1].add(new Virus(i, j+1, num, dir, move+1));
						} else {
							int num = grid[i][j].get(0).num;
							int move = grid[i][j].get(0).move;
							grid[i][j].remove(0);
							grid[i][j+1].add(new Virus(i, j+1, num, dir, move+1));
						}
					}
					
				}
			}
		}
		
		// 겹치는거 함침
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j].size() >= 2) {
					int num = 0;
					int dir = 0;
					int max = 0;
					int move = moveCnt;
					for (int k = 0; k < grid[i][j].size(); k++) {
						if (grid[i][j].get(k).num > max) {
							max = grid[i][j].get(k).num;
							dir = grid[i][j].get(k).dir;
						}
						
						num += grid[i][j].get(k).num;
						
					}
					
					int size = grid[i][j].size();

					while(--size >= 0) {
						grid[i][j].remove(size);
					}
					
					grid[i][j].add(new Virus(i, j, num, dir, move));
					
				}
			}
		}
		

		
	}
	
}

/*
 *    ① 최초 각 미생물 군집의 위치와 군집 내 미생물의 수, 이동 방향이 주어진다. 약품이 칠해진 부분에는 미생물이 배치되어 있지 않다. 이동방향은 상, 하, 좌, 우 네 방향 중 하나이다.

   ② 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동한다.

   ③ 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 
       미생물 수가 홀수인 경우 반으로 나누어 떨어지지 않으므로, 다음과 같이 정의한다.
       살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
       따라서 군집에 미생물이 한 마리 있는 경우 살아남은 미생물 수가 0이 되기 때문에, 군집이 사라지게 된다,

   ④ 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다. 
       합쳐 진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다. 
       합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.
       */