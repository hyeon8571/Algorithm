import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Character[] arr = new Character[N];
        
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }
        
        /*
        4가지 경우의 수
        1. 빨간색을 모두 왼쪽으로
        2. 빨간색을 모두 오른쪽으로
        3. 파란색을 모두 왼쪽으로
        4. 파란색을 모두 오른쪽으로
        */
        
        int result = 0;
        
        int rCnt = 0;
        int bCnt = 0;
        
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                rCnt++;
            } else {
                bCnt++;
            }
        }
        
        int cnt = 0;
        // 1.
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        
        result = rCnt - cnt;
        
        // 2
        cnt = 0;
        for (int i = N-1; 0 <= i; i--) {
            if (arr[i] == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        
        result = Math.min(result, rCnt-cnt);

        // 3.
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        
        result = Math.min(result, bCnt - cnt);
        
        // 4
        cnt = 0;
        for (int i = N-1; 0 <= i; i--) {
            if (arr[i] == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        
        result = Math.min(result, bCnt-cnt);
        
        System.out.println(result);
    }
}
