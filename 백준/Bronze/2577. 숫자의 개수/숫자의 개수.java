import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a * b * c;

        int[] arr = new int[10];
        
        /*
        * 1. Num을 String으로 변경
        * 2. 각 자리별로 '0' 뺀 값을 계산
        * */
        
        String numStr = String.valueOf(num);
        
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            int gap = ch - '0';
            arr[gap]++;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
