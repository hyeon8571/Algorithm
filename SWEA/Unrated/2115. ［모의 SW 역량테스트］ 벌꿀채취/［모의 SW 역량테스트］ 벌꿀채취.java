import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, C;
	
	static int[][] grid;
	
	static int[] A;
	
	static int[] B;
	
	static int result, result1, result2;
	
	static int dap;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			A = new int[M];
			B = new int[M];
			
			result = 0;
			result1 = 0;
			result2 = 0;
			
			grid = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			choiceA();
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void choiceA() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				
				for (int k = 0; k < M; k++) {
					A[k] = grid[i][j+k];
				}
				
				visited = new boolean[M];
				dap = 0;
				makePowerSet(0, A);
				result1 = dap;
				
				choiceB(i, j);
				
			}
		}
	}
	
	public static void choiceB(int Ay, int Ax) {
		
		for (int i = Ay; i < N; i++) {
			
			if (i == Ay && (Ax + M + M - 1) <= N - 1) {
				for (int j = Ax + M; j <= N - M; j++) {
					
					for (int k = 0; k < M; k++) {
						B[k] = grid[i][j+k];
					}		
					
					visited = new boolean[M];
					dap = 0;
					makePowerSet(0, B);
					result2 = dap;
					
					if (result1 + result2 > result) {
						result = result1 + result2;
					}
					
				}
			} else if (i != Ay){
				for (int j = 0; j <= N - M; j++) {
					
					for (int k = 0; k < M; k++) {
						B[k] = grid[i][j+k];
					}		
					
					visited = new boolean[M];
					dap = 0;
					makePowerSet(0, B);
					result2 = dap;
					
					if (result1 + result2 > result) {
						result = result1 + result2;
					}
					
				}
			}
			
			
		}
	}
	
	public static void makePowerSet(int depth, int[] honey) {
		
		if (depth == M) {
			
			int gap = 0;
			
			int gop = 0;
			
			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					gap += honey[i];
				}
			}
			
			if (gap <= C) {
				for (int i = 0; i < M; i++) {
					if (visited[i]) {
						gop += Math.pow(honey[i], 2);
					}
				}
			}
			
			if (gop > dap) {
				dap = gop;
			}
			
			return;
		}
		
		visited[depth] = true;
		makePowerSet(depth + 1, honey);
		visited[depth] = false;
		makePowerSet(depth + 1, honey);
	}
	
	
}
