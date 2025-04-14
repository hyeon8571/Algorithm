/*
던전의 최대 개수는 8이하 -> 완탐 가능 (순열)
*/
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[] selected;
    static int N;
    static int result = 0;
        
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        selected = new int[N];
        
        dfs(k, 0, dungeons);
        
        return result;
    }
    
    public void dfs(int k, int depth, int[][] dungeons) {
        
        if (depth == N) {
            
            int p = k;
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
                int n = selected[i];
                
                if (p >= dungeons[n][0]) {
                    p -= dungeons[n][1];
                    cnt++;
                } else {
                    break;
                }
            }
            
            if (cnt > result) {
                result = cnt;
            }
            
            return;
        } 
       
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            selected[depth] = i;
            dfs(k, depth+1, dungeons);
            visited[i] = false;
            
        }
    }
}