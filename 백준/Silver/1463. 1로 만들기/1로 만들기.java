import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int dp[] = new int[X+1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
        }

        System.out.println(dp[X]);
    }
}
