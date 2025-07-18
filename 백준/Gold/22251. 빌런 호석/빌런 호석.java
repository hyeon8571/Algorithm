import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int K, P, X;
    static int result;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 최대 층
        K = Integer.parseInt(st.nextToken()); // 자리수
        P = Integer.parseInt(st.nextToken()); // 반전시킬 최대수
        X = Integer.parseInt(st.nextToken()); // 현재 층
        
        // 현재 멈춰있는 층에서 바꿔야함
        
        arr = new int[10][10];
        
        arr = new int[10][10];
		arr[0] = new int[] {0, 4, 3, 3, 4, 3, 2, 3, 1, 2};
		arr[1] = new int[] {4, 0, 5, 3, 2, 5, 6, 1, 5, 4};
		arr[2] = new int[] {3, 5, 0, 2, 5, 4, 3, 4, 2, 3};
		arr[3] = new int[] {3, 3, 2, 0, 3, 2, 3, 2, 2, 1};
		arr[4] = new int[] {4, 2, 5, 3, 0, 3, 4, 3, 3, 2};
		arr[5] = new int[] {3, 5, 4, 2, 3, 0, 1, 4, 2, 1};
		arr[6] = new int[] {2, 6, 3, 3, 4, 1, 0, 5, 1, 2};
		arr[7] = new int[] {3, 1, 4, 2, 3, 4, 5, 0, 4, 3};
		arr[8] = new int[] {1, 5, 2, 2, 3, 2, 1, 4, 0, 1};
		arr[9] = new int[] {2, 4, 3, 1, 2, 1, 2, 3, 1, 0};
        
        go();
        
        System.out.println(result);
        
    }
    
    public static void go() {
        
        for (int i = 1; i <= N; i++) {
            // X와 i를 비교
            
            if (X == i) {
                continue;
            }
            
            int count = 0;
            int iCopy = i;
            int xCopy = X;
            
            for (int j = K-1; j >= 0; j--) {
                
                int temp = (int)Math.pow(10, j);
                 
                int iTemp = iCopy/ temp; // to
                int xTemp = xCopy / temp; // from
                
                count += arr[xTemp][iTemp];
                
                iCopy %= temp;
                xCopy %= temp;
                
            }
            
            if (count <= P) {
                result++;
            }
        }
        
    }
}
