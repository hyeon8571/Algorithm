
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static int N;
	
	static int[][] grid;
	
	static List<Place> start;
	
	static List<Place> end;
	
	static int[] arr;
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			
			start = new ArrayList<>();
			
			end = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					
					if (grid[i][j] == 1) {
						start.add(new Place(i, j));
					} else if (grid[i][j] >= 2) {
						end.add(new Place(i, j));
					}
				}
			}
		
			
			result = Integer.MAX_VALUE;
			
			arr = new int[start.size()];
			
			backtracking(0);
			
			System.out.println("#" + t + " " + (result+1));
			
		}
		
	}
	
	public static void backtracking(int depth) {
		
		if (depth == start.size()) {
			
			List<Integer> list1 = new ArrayList<>();
			
			List<Integer> list2 = new ArrayList<>();
			
			int[] time1 = new int[3];
			int[] time2 = new int[3];
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					Place human = start.get(i);
					Place stair = end.get(0);
					int distance = Math.abs(human.x - stair.x) + Math.abs(human.y - stair.y);
					list1.add(distance);
				} else {
					Place human = start.get(i);
					Place stair = end.get(1);
					int distance = Math.abs(human.x - stair.x) + Math.abs(human.y - stair.y);
					list2.add(distance);
				}
			}
			
			Collections.sort(list1);
			Collections.sort(list2);
			
			for (int i = 0; i < list1.size(); i++) {
				
				if (time1[i%3] > list1.get(i)) {
					time1[i%3] += grid[end.get(0).y][end.get(0).x];
				} else {
					time1[i%3] = list1.get(i) + grid[end.get(0).y][end.get(0).x];
				}
			}
			
			for (int i = 0; i < list2.size(); i++) {
				
				if (time2[i%3] > list2.get(i)) {
					time2[i%3] += grid[end.get(1).y][end.get(1).x];
				} else {
					time2[i%3] = list2.get(i) + grid[end.get(1).y][end.get(1).x];
				}
			}
			
			int max1 = 0;
			
			int max2 = 0;
			
			for (int i = 0; i < 3; i++) {
				if (time1[i] > max1) {
					max1 = time1[i];
				}
				
				if (time2[i] > max2) {
					max2 = time2[i];
				}
			}
			
			int max = Math.max(max1, max2);
			
			if (max < result) {
				result = max;
			}
			
			return;
		}
		
		
		for (int i = 0; i < 2; i++) {
			arr[depth] = i;
			backtracking(depth + 1);
		}
	}
	
}
