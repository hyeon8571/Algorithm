import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[][] grid = new int[H][W];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            for (int j = height; 0 < j; j--) {
                grid[H-j][i] = 1;
            } 
        }
        
        // 좌표 범위내에 0중에서 양 옆이 다 채워져있으면 카운트
        
        int count = 0;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == 0) {
                    // 왼쪽 이동
                    int now = j;
                    boolean flag1 = false;
                    
                    while (true) {
                        now = now-1;
                        if (now < 0) {
                            break;
                        }
                        
                        if (grid[i][now] == 1) {
                            flag1 = true;
                        }
                    }
                    
                    // 오른쪽 이동
                    now = j;
                    boolean flag2 = false;
                    while (true) {
                        now = now+1;
                        if (now > W-1) {
                            break;
                        }
                        
                        if (grid[i][now] == 1) {
                            flag2 = true;
                        }
                    }
                    
                    if (flag1) {
                        if (flag2) {
                            count++;        
                        }
                    }
                    
                }
            }
        }
        
        System.out.println(count);
        
    }
}
