import java.io.*;
import java.util.*;

public class Main {
    
    public static class Road {
        int from;
        int to;
        int cost;
        
        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static int N;
    public static HashMap<Integer, List<Road>> map;
    public static int[] distance;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new HashMap<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());
            
            Road road1 = new Road(from, to, cow);
            Road road2 = new Road(to, from, cow);
            
            List<Road> roadList1 = map.getOrDefault(from, new ArrayList<Road>());
            List<Road> roadList2 = map.getOrDefault(to, new ArrayList<Road>());
            
            roadList1.add(road1);
            map.put(from, roadList1);
            roadList2.add(road2);
            map.put(to, roadList2);
        }
        
        bfs();
        
        System.out.println(distance[N]);
        
    }
    
    public static void bfs() {
        int start = 1;
        distance = new int[N+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll(); // from
            
            List<Road> list = map.get(now);
            for (int i = 0; i < list.size(); i++) {
                int next = list.get(i).to; // to
                
                if (distance[next] == 0) {
                    distance[next] = distance[now] + list.get(i).cost;
                    queue.add(next);
                } else if (distance[next] > distance[now] + list.get(i).cost) {
                    distance[next] = distance[now] + list.get(i).cost;
                    queue.add(next);
                }
            }
        }
        
    }
}
