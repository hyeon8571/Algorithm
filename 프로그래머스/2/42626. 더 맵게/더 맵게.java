import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int val : scoville) {
            pq.add(val);
        }
        
        int result = 0;
        
        while (true) {
            
            int val1 = pq.poll();
            
            if (val1 >= K) {
                break;
            }
            
            if (pq.isEmpty()) {
                return -1;
            }
            
            int val2 = pq.poll();
            
            int newVal = val1 + 2*val2;
            pq.add(newVal);
            result++;
        }
        
        return result;
        
    }
}