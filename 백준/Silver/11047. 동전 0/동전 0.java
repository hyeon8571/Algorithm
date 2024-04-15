

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	
	static int[] money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		money = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			if (K / money[i] != 0) {
				result += K / money[i];
				K = K % money[i];
			}
		}
		
		System.out.println(result);
		
	}
}
