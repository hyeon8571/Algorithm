import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        int[] selected = new int[d+1];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int result = 0;
        
        // 쿠폰 초밥
        selected[c]++;
        
        int cnt = 1;
        for (int i = 0; i < k; i++) {
            if (selected[arr[i]] == 0) {
                cnt++;
            }
            selected[arr[i]]++;
        }
        
        result = cnt;
        
        for (int i = 1; i < N; i++) { 
            selected[arr[i-1]]--;
            if (selected[arr[i-1]] == 0) {
                cnt--;
            }
            
            selected[arr[(i+k-1) % N]]++;
            if (selected[arr[(i+k-1) % N]] == 1) {
                cnt++;
            }
            
            result = Math.max(result, cnt);
            
        }
        
        System.out.println(result);
        
    }
}
