import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        //Arrays.sort(times);
       //long maxTime = n * times[times.length-1] / times.length;
        
        long start = 0;
        long end = n * maxTime / times.length;
        long answer = Long.MAX_VALUE;
        
        while (start < end) {
            long mid = (start + end) / 2;
            
            long people = 0;
            for (int time : times) {
                people += (mid / time);
            }
            
            if (people >= n) {
                end = mid;
                answer = Math.min(answer, mid);
            } else {
                if (start == mid) {
                    break;
                }
                start = mid;
                
            } 
            
        }
        
        return answer;
    }
}