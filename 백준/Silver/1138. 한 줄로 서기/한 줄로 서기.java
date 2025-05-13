import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] selected;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        permutation(0);
    }
    
    public static void permutation(int depth) {
        if (depth == N) {
            boolean flag = true;
            for (int i = N-1; i >= 0; i--) {
                
                int count = 0;
                
                for (int j = 0; j <= i-1; j++) {
                    if (selected[i] < selected[j]) {
                        count++;
                    }
                }
                
                if (count != arr[selected[i]-1]) {
                    flag = false;
                }
            }
            
            if (flag) {
                for (int i = 0; i < N; i++) {
                    System.out.print(selected[i] + " ");    
                }
                System.exit(0);
            }
            
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            
            selected[depth] = i;
            visited[i] = true;
            permutation(depth+1);
            visited[i] = false;
        }
    }
}
