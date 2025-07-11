import java.io.*;
import java.util.*;

public class Main {
    
    public static class Place {
        int y, x;
        
        int dir;
        
        public Place(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    
    public static boolean resultFlag = false;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "";
        
        while (true) {
            str = br.readLine();
            
            if (str.equals("end")) {
                break;
            }
            
            Character[][] grid = new Character[3][3];
            
            for (int i = 1; i <= 9; i++) {
                char ch = str.charAt(i-1);
                if (i < 4) {
                    grid[0][i-1] = ch;    
                } else if (i < 7) {
                    grid[1][i-4] = ch;
                } else {
                    grid[2][i-7] = ch;
                }
            }
            
            /**
            점검
            1. 개수 -> x가 무조건 더 많아야함 + 개수 차이
            2. o가 3개 이어졌는데 x가 더 많은가
            3. 둘 다 안이어졌는데 .이 있는가
            
            */
            
            int oCnt = 0;
            int xCnt = 0;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == 'O') {
                        oCnt++;
                    } else if (grid[i][j] == 'X') {
                        xCnt++;
                    }
                }
            }
            
            if (xCnt < 3 && oCnt < 3) {
                System.out.println("invalid");
                continue;
            }
            
            if (oCnt > xCnt) {
                System.out.println("invalid");
                continue;
            }
            
            if (xCnt - oCnt > 1) {
                System.out.println("invalid");
                continue;
            }
            
            boolean checkO = check('O', grid);
            boolean checkX = check('X', grid);
            
            // System.out.println(checkO);
             //System.out.println(checkX);
            
            if (checkX) {
                if (checkO) {
                    System.out.println("invalid");
                    continue;
                }
                
                if (xCnt != oCnt+1) {
                    System.out.println("invalid");
                    continue;
                }
            }
            
            if (checkO) {
                if (xCnt != oCnt) {
                    System.out.println("invalid");
                    continue;
                }
            }
            
            if (!checkO && !checkX) {
                if (xCnt + oCnt != 9) {
                    System.out.println("invalid");
                    continue;
                }
            }
            
            System.out.println("valid");
            
        }
    
    }
    
    public static boolean check(char ch, Character[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ch) {
                    resultFlag = false;
                    dfs(i, j, grid, 1, 0);
                    if (resultFlag == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    public static void dfs(int startY, int startX, Character[][] grid, int count, int dir) {
        
        if (count == 3) {
            resultFlag = true;
        }
        
        int[] dx = new int[] {1, 1, 0, -1};
        int[] dy = new int[] {0, 1, 1, 1};
        
        for (int i = 1; i <= 4; i++) {
            int ny = startY + dy[i-1];
            int nx = startX + dx[i-1];
            
            if (0 <= ny && ny < 3 && 0 <= nx && nx < 3) {
                
                if (dir == 0 || dir == i) {
                    if (grid[ny][nx] == grid[startY][startX]) {
                        dfs(ny, nx, grid, count+1, i);
                    }
                }
            }
        }   
    }
}
