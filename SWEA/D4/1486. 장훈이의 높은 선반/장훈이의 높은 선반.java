

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, B;
	
	static int[] tall;
	
	static boolean[] visited;
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			B = Integer.parseInt(st.nextToken());
			
			tall = new int[N];
			
			visited = new boolean[N];
			
			result = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tall[i] = Integer.parseInt(st.nextToken());
			}
			
			makePowerset(0);
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	public static void makePowerset(int depth) {
		if (depth == N) {
			int height = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					height += tall[i];
				}
			}
			
			if (height >= B) {
				if ((height - B) < result) {
					result = (height - B);
				}
			}
			
			return;
		}
		
		visited[depth] = true;
		makePowerset(depth + 1);
		visited[depth] = false;
		makePowerset(depth + 1);
	}
}
