import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(time, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            
            return a[0] - b[0];
            }
        );
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(time[0][1]);
        
        for (int i = 1; i < N; i++) {
            if (time[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(time[i][1]);
        }
        
        System.out.println(pq.size());
    }
}
