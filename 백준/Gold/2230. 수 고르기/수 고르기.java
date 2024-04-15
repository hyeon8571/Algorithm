
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int i = 0, j = 0;
		
		int result = Integer.MAX_VALUE;
		
		while(j < N && i <= j) {
			int rst = arr[j] - arr[i]; // 두 포인터가 가리키는 값의 차
			// 두 값의 차이가 M 이상이면
			// s++, 그 차이의 최소값 구하기
			if(rst >= M) {
				i++;
				result = Math.min(result, rst);
			} 
			// 두 값의 차이가 M보다 작으면 e++
			else {
				j++;
			}
		}
		System.out.println(result);
		
	}
}
