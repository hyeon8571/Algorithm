import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] result = new int[n];
		
		List<Integer> height = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			
			height.add(Integer.parseInt(st.nextToken()));
		}
		// stack : idx
		// height : 키
		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < n; i++) {
			
			while (!stack.isEmpty()) {
				if (height.get(stack.peek()) > height.get(i)) {
					result[i] = stack.peek() + 1;
					break;
				}
				stack.pop();
			}
			stack.add(i);
			
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.print(sb);
	}
}