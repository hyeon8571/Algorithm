/*
BFS로 해결 가능할듯?
*/

import java.util.*;

class Solution {
    
    static int[] grid;
    static boolean[] visited;
    
    public int solution(int x, int y, int n) {
        
        grid = new int[y+1];
        visited = new boolean[y+1];
        
        if (x == y) {
            return 0;
        }
        
        bfs(x, n, y);
        int answer = grid[y];
        if (answer == 0) {
            return -1;
        }
        return answer;
    }
    
    public void bfs(int startX, int n, int y) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startX);
        grid[startX] = 0;
        visited[startX] = true;
        
        
        while(!queue.isEmpty()) {
        
            int now = queue.poll();
            
            int nx = now;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = now + n;
                } else if (i == 1) {
                    nx = now*2;
                } else {
                    nx = now*3;
                }
                
                if (nx <= y) {
                    if (!visited[nx]) {
                        queue.add(nx);
                        grid[nx] = grid[now] + 1;
                        visited[nx] = true;
                    }
                }
            }
        }
        
    }
}