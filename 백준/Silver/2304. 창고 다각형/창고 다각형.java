import java.io.*;
import java.util.*;

public class Main {
    
    public static class Place implements Comparable<Place> {
        int x, y;
        
        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Place o) {
            return this.x - o.x;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int minX = 1001;
        int maxX = 0;
        int maxY = 0;
        
        
        List<Place> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list.add(new Place(x, y));
            
            if (x > maxX) {
                maxX = x;
            }
            
            if (x < minX) {
                minX = x;
            }
            
            if (y > maxY) {
                maxY = y;
            }
        }
        
        Collections.sort(list);
        int total = (maxX - minX + 1) * maxY;
        
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (list.get(i).y == maxY) {
                maxIndex = i;
                break;
            }
        }
        
        
        maxX = list.get(0).x;
        maxY = list.get(0).y;
        int val = 0;
        // 가장 높은 기둥 이전
        for (int i = 1; i <= maxIndex; i++) {
            if (list.get(i).y > maxY) {
                int x = list.get(i).x - maxX;
                int y = list.get(maxIndex).y - maxY;
                val += (x * y);
                maxX = list.get(i).x;
                maxY = list.get(i).y;
            }
        }
        
        if (val == 0) {
            int x = list.get(maxIndex).x - maxX;
            int y = list.get(maxIndex).y - maxY;
            total -= (x*y);
        } else {
            total -= val;
        }
        
        if (maxIndex == N-1) {
            System.out.println(total);
            return;
        }
        
        maxX = list.get(N-1).x;
        maxY = list.get(N-1).y;
        val = 0;
        // 가장 높은 기둥 이후 (가장 마지막에서 접근)
        for (int i = N-2; maxIndex <= i; i--) {
            if (list.get(i).y > maxY) {
                int x = maxX - list.get(i).x;
                int y = list.get(maxIndex).y - maxY;
                val += (x * y);
                maxX = list.get(i).x;
                maxY = list.get(i).y;
            }
        }
    
        if (val == 0) {
            int x = maxX - list.get(maxIndex).x;
            int y = list.get(maxIndex).y - maxY;
            total -= (x*y);
        } else {
            total -= val;
        }
        
        System.out.println(total);
        
    }
}
