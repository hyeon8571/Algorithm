import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean[] visited;
    public static int[] num;
    public static List<Integer> list;
    
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        
        num = new int[N+1];
        visited = new boolean[N+1];
        
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        list = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list);
        
        System.out.println(list.size());
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
    }
    
    public static void dfs(int start, int target) {
        
        int next = num[start];
        
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        } else {
            if (target == next) {
                list.add(target);
                return;
            }
        }
    }
}
