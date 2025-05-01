import java.io.*;
import java.util.*;

public class Main {
    
    public static class Kcpc implements Comparable<Kcpc> {
        int teamId;
        int totalScore;
        int count; // 풀이를 제출한 횟수
        int lastIdx;
        
        public Kcpc(int teamId, int totalScore, int count, int lastIdx) {
            this.teamId = teamId;
            this.totalScore = totalScore;
            this.count = count;
            this.lastIdx = lastIdx;
        }
        
        @Override
        public int compareTo(Kcpc o) {
            if (this.totalScore != o.totalScore) {
                return o.totalScore - this.totalScore;
            } else {
                if (this.count != o.count) {
                    return this.count - o.count;
                } else {
                    return this.lastIdx - o.lastIdx;
                }
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 로그 수
            
            Kcpc[] arr = new Kcpc[n];
            int[][] visited = new int[n+1][k+1];
            
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                if (arr[teamId-1] == null) {
                    arr[teamId-1] = new Kcpc(teamId, s, 1, j);
                    visited[teamId][num] = s;
                } else {
                    if (visited[teamId][num] < s) {
                        int totalScore = arr[teamId-1].totalScore - visited[teamId][num] + s;
                        visited[teamId][num] = s;
                        arr[teamId-1] = new Kcpc(teamId, totalScore, arr[teamId-1].count+1, j);
                    } else {
                        arr[teamId-1] = new Kcpc(teamId, arr[teamId-1].totalScore, arr[teamId-1].count+1, j);
                    }
                }
            }
            
            Arrays.sort(arr);
            
            
            int result = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].teamId == id) {
                    result = j+1;
                }
            }
            
            System.out.println(result);
            
        }
    }
}
