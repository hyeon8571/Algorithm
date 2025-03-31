import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] info, int n, int m) {

        int[][] dp = new int[info.length+1][m];
        
        for (int i = 1; i < info.length+1; i++) {
            Arrays.fill(dp[i], n);
        }
        
        for (int i = 1; i <= info.length; i++) {
            
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a); // A가 훔칠 때
                
                if (j + b < m) { // B가 훔칠 때
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        
        int answer = n;
        
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }
        
        return (answer == n) ? -1 : answer;
        
    }
}