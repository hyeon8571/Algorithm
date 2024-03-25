

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class  Main {

	static int N, M;
	
	static int[][] grid;
	
	static boolean[] visited;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		int V = Integer.parseInt(st.nextToken());
		
		grid = new int[N + 1][N + 1];
		
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			
			int to = Integer.parseInt(st.nextToken());
			
			grid[from][to] = 1;
			grid[to][from] = 1; 
		}
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);
		sb = new StringBuilder();
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		visited[start] = true;
		
		sb.append(start + " ");
		queue.add(start);
		
		while (!queue.isEmpty()) {
			
			int now = queue.pollFirst();
			
			for (int i = 1; i <= N; i++) {
				if (grid[now][i] == 1 && !visited[i]) {
					visited[i] = true;
					sb.append(i + " ");
					queue.add(i);
				}
			}
		}
	}
	
	static void dfs(int start) {
		
		visited[start] = true;
		sb.append(start + " ");
		
		for (int i = 1; i <= N; i++) {
			if (grid[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
