import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String numStr = String.valueOf(num);

        int[] arr = new int[10];

        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            int a = ch - '0';
            if (a == 6) {
                arr[9]++;
            } else {
                arr[a]++;
            }
        }

        int maxNum = 0;
        int gap = 0;

        for (int i = 0; i < 10; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                gap = i;
            }
        }

        if (gap == 9) {
            if (maxNum % 2 == 1) {
                maxNum = maxNum / 2 + 1;
            } else {
                maxNum = maxNum / 2;
            }
        }

        System.out.println(maxNum);
    }
}
