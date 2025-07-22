import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        String before = br.readLine();
        String after = br.readLine();
        
        String[] bArr = before.split("");
        String[] aArr = after.split("");
        
        int[] beforeArr = new int[N];
        int[] pushBeforeArr = new int[N];
        int[] afterArr = new int[N];
                
        for (int i = 0; i < N; i++) {
            beforeArr[i] = Integer.parseInt(bArr[i]); // 첫번째 스위치 안누름
            pushBeforeArr[i] = Integer.parseInt(bArr[i]); // 첫번째 스위치 누름
            afterArr[i] = Integer.parseInt(aArr[i]);
        }
        
        
        
        // 첫번째 스위치 push
        if (pushBeforeArr[0] == 0) {
            pushBeforeArr[0] = 1;
        } else {
            pushBeforeArr[0] = 0;
        }
        
        if (pushBeforeArr[1] == 0) {
            pushBeforeArr[1] = 1;
        } else {
            pushBeforeArr[1] = 0;
        }
        
        int result1 = push(pushBeforeArr, afterArr, 1); // 이 경우에는 cnt + 1
        
        // 첫번째 스위치 push X
        int result2 = push(beforeArr, afterArr, 0);
        
        if (result1 == -1 && result2 == -1) {
            System.out.println(-1);
            return;
        }
        
        if (result1 == -1) {
            System.out.println(result2);
            return;
        }
        
        if (result2 == -1) {
            System.out.println(result1);
            return;
        }
        
        System.out.println(Math.min(result1, result2));
        
        
    }
    
    public static int push(int[] before, int[] after, int val) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            //int val = before[i];
            if (before[i] != after[i]) {
                
                if (i <= N-3) {
                    before[i] = (before[i] == 0) ? 1 : 0;
                    before[i+1] = (before[i+1] == 0) ? 1 : 0;                
                    before[i+2] = (before[i+2] == 0) ? 1 : 0;
                     
                } else if (i <= N-2) {
                    before[i] = (before[i] == 0) ? 1 : 0;
                    before[i+1] = (before[i+1] == 0) ? 1 : 0;
                } else if (i <= N-1) {
                    before[i-1] = (before[i-1] == 0) ? 1 : 0;
                    before[i] = (before[i] == 0) ? 1 : 0;
                }
                count++;
                
            }
        }
        
        boolean flag = false;
        
        for (int i = 0; i < N; i++) {
            if (before[i] != after[i]) {
                flag = true;
                break;
            } 
        }
        
        if (flag) {
            return -1;
        } else {
            return count + val;
        }
        
    }
}
