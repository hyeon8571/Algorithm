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
    
    public static class Dest implements Comparable<Dest> {
        int dest;
        int cost;
        
        public Dest(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Dest o) {
            if (this.cost - o.cost > 0) {
                return 1;
            } else if (this.cost - o.cost < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    public static int N;
    public static HashMap<Integer, List<Road>> map;
    public static int[] distance;
    public static int result;
    
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
        
        dijkstra();
        
        System.out.println(distance[N]);
        
    }
    
    public static void dijkstra() {
        int start = 1;
        distance = new int[N+1];
        distance[start] = 0;
        
        PriorityQueue<Dest> pq = new PriorityQueue<>();
        
        List<Road> roadList = map.get(start);
        
        for (int i = 0; i < roadList.size(); i++) {
            distance[roadList.get(i).to] = roadList.get(i).cost; // 첫 좌표 기준 다음 이동할 값
            Dest dest = new Dest(roadList.get(i).to, roadList.get(i).cost); // 다음 갈 지점, 이때까지의 비용
            pq.add(dest);
        }
        
        while (!pq.isEmpty()) {
            Dest now = pq.poll(); // 2 => 노드, 1 => 현재 지점까지 오는 총 비용
            
            if (now.dest == N) {
                return;
            }
            
            roadList = map.get(now.dest); 
            
            for (int i = 0; i < roadList.size(); i++) { // 1 4 3
                Road road = roadList.get(i); 
                
                if (road.to == 1) {
                    continue;
                }
                
                if (distance[road.to] == 0) {
                    Dest next = new Dest(road.to, road.cost + distance[now.dest]);
                    distance[road.to] = road.cost + distance[now.dest];
                    pq.add(next);  
                } else if (distance[road.to] > road.cost + distance[now.dest]) {
                    Dest next = new Dest(road.to, road.cost + distance[now.dest]);
                    distance[road.to] = road.cost + distance[now.dest];
                    pq.add(next);
                }
            }
        } 
        
    }
}
