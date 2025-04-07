class Solution {
    
    static boolean[][][] grid;
    
    public int solution(String dirs) {
        
        grid = new boolean[11][11][4];
        
        int answer = play(dirs);
        return answer;
    }
    
    public int play(String dirs) {
        
        int nowY = 5;
        int nowX = 5;
        
        int count = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            Character command = dirs.charAt(i);
            
            int dir = 0;
            
            int ny = nowY;
            int nx = nowX;
            
            if (command == 'U') {
                ny = nowY-1;
                if (ny < 0 || ny > 10) {
                    continue;
                }
                dir = 0;
            }
            
            if (command == 'D') {
                ny = nowY + 1;
                if (ny < 0 || ny > 10) {
                    continue;
                }
                dir = 2;
            }
            
            if (command == 'R') {
                nx = nowX + 1;
                if (nx < 0 || nx > 10) {
                    continue;
                }
                dir = 1;
            }
            
            if (command == 'L') {
                nx = nowX - 1;
                if (nx < 0 || nx > 10) {
                    continue;
                }
                dir = 3;
            }
            
            // dir이 0이면 3도 체크, 1이면 2도 체크
            
            if (!grid[ny][nx][dir]) {
                grid[ny][nx][dir] = true; // 방향 고려
                grid[nowY][nowX][(dir+2) % 4] = true; // 반대방향에서 오는것도 체크
                count++;
            }
            
            nowX = nx;
            nowY = ny;
            
        }
        return count;
    }
}