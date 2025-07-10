import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        
        int lResult = arr[left];
        int rResult = arr[right];
        
        int value = Math.abs(arr[left] + arr[right]);
        
        while (left < right) {
            int val = arr[left] + arr[right];
            if (Math.abs(val) < Math.abs(value)) {
                lResult = arr[left];
                rResult = arr[right];
                value = Math.abs(val);
            }
            
            if (arr[left] + arr[right] == 0) {
                lResult = arr[left];
                rResult = arr[right];
                break;
            }
            
            if (arr[left] + arr[right] > 0) {
                right--;
            }
            
            if (arr[left] + arr[right] < 0) {
                left++;
            }
        }
        
        System.out.print(lResult + " " + rResult);
    }
}
