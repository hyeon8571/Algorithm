/*
bfs => 0은 벽, 1은 길
*/

import java.util.*;

class Solution {
    
    static class Place {
        int y, x, count;
        
        public Place(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        
        int[][] distance = new int[maps.length][maps[0].length];
        
        bfs(0, 0, maps, distance);
        
        if (distance[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        } else {
            return distance[maps.length-1][maps[0].length-1];
        }

    }

    public static void bfs(int startY, int startX, int[][] maps, int[][] distance) {
        
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};
        
        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(startY, startX, 1));
        distance[startY][startX] = 1;
        
        while(!queue.isEmpty()) {
            
            Place now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if (0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length) {
                    if (maps[ny][nx] == 1) {
                        
                        if (distance[ny][nx] == 0) {
                            queue.add(new Place(ny, nx, now.count+1));   
                            distance[ny][nx] = now.count+1;
                        } else if (distance[ny][nx] > now.count+1) {
                            distance[ny][nx] = now.count+1;
                            queue.add(new Place(ny, nx, now.count+1));
                        }
                    }
                }
                
            }
        }
        
    }
}