package boj.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        long result = A * B * C;

        String resultStr = String.valueOf(result);

        int[] arr = new int[10];

        for (int i = 0; i < resultStr.length(); i++) {
            char ch = resultStr.charAt(i);
            int n = ch - '0';
            arr[n]++;
        }

       for (int i = 0; i < 10; i++) {
           System.out.println(arr[i]);
       }
    }
}
