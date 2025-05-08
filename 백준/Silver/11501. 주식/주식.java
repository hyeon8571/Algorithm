import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            int max = 0;
            long result = 0;
            for (int j = N-1; 0 <= j; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    result += (max - arr[j]);
                }
            }
            
            System.out.println(result);
        }
    }
}
