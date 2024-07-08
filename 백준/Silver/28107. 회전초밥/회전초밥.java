import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_SIZE = 200_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer>[] q = new Queue[MAX_SIZE+1];
        for(int i = 0 ; i <= MAX_SIZE ; i++){
            q[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < cnt ; j++){
                int num = Integer.parseInt(st.nextToken());
                q[num].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] cnt = new int[n];
        for(int i = 0 ; i < m ; i++){
            int sushi = Integer.parseInt(st.nextToken());
            if(!q[sushi].isEmpty()){
                cnt[q[sushi].poll()]++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print(cnt[i]+" ");
        }
    }
}