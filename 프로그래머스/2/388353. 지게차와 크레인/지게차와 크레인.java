/*
단순 구현 문제
*/

import java.util.*;

class Solution {
    
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};
    
    static class Place {
        int y, x;
        
        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        
        String[][] grid = new String[storage.length][storage[0].length()];
        
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                grid[i][j] = storage[i].substring(j, j+1);
            }
        }
        
        for (int i = 0; i < requests.length; i++) {
            
            if (requests[i].length() == 1) { // 지게차 모드 수행
                mode1(grid, requests[i]);
            } else { // 크레인 모드 수행
                mode2(grid, requests[i].substring(0, 1));
            }
        }
        
        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!grid[i][j].equals(" ")) {
                    result++;
                }
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
        return result;
    }
    
    // 지게차 모드
    public void mode1(String[][] grid, String order) {
        
        List<Place> list = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals(order)) {
                    
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        
                        if (nx < 0 || nx >= grid[0].length || ny < 0 || ny >= grid.length) {
                            list.add(new Place(i, j));
                            continue;
                        } else if (grid[ny][nx].equals(" ")) {
                            
                            // 계속 진행했을 때 외부가 있는지 확인해야함 dfs?
                            boolean[][] visited = new boolean[grid.length][grid[0].length];
                            boolean flag = bfs(ny, nx, visited, grid);
                            
                            if (flag) {
                                list.add(new Place(i, j));   
                            }
                        }
                    }
                    
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            Place p = list.get(i);
            grid[p.y][p.x] = " ";
        }
    }
    
    // 크레인 모드
    public void mode2(String[][] grid, String order) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals(order)) {
                    grid[i][j] = " ";
                }
            }
        }
    }
    
    public boolean bfs(int startY, int startX, boolean[][] visited, String[][] grid) {
        
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(startY, startX));
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()) {
            Place now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) {
                    return true;
                } else if (grid[ny][nx].equals(" ")) {
                    if (!visited[ny][nx])
                    queue.add(new Place(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        
        return false;
        
    }
}