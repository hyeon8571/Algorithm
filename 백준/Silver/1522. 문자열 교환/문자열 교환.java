import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }
        
        int bCnt = 0;
        for (int i = 0; i < aCnt; i++) {
            if (str.charAt(i) == 'b') {
                bCnt++;
            }    
        }
        
        int result = bCnt;
        
        // 슬라이딩 윈도우
        for (int i = 1; i < str.length(); i++) { // 출발 위치
            if (str.charAt(i-1) == 'b') {
                bCnt--;
            }
            
            if (str.charAt((i+aCnt-1) % str.length()) == 'b') {
                bCnt++;
            }
            
            result = Math.min(result, bCnt);
        }
        
        System.out.println(result);
    }
}
