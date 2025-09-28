import java.util.*;

class Solution {
    
    static PriorityQueue<String[]> pq;
    static int N;
    
    public String[] solution(String[][] tickets) {
        
        pq = new PriorityQueue<>((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        N = tickets.length; // 3
        boolean[] visited = new boolean[N]; // 배열 방문 여부
        String[] places = new String[N+1]; // 방문한 지역 
        dfs("ICN", places, 0, tickets, visited);
        return pq.poll();
    }
    
    public static void dfs(String start, String[] places, int depth, String[][] tickets, boolean[] visited) {
        
        places[depth] = start;
        
        // 길이가 다 차면 return
        if (depth == N) {
            pq.add(Arrays.copyOf(places, places.length));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], places, depth+1, tickets, visited);
                visited[i] = false;
            }
        }
        
    }
}