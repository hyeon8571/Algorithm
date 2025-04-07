import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        int[] answer = new int[2];
        
        // 노란색 개수 = (가로-2) * (세로-2)
        
        
        for (int i = 3; i < total; i++) { // 세로
            int y = i;
            int x = total / i;
            
            if ((x-2)*(y-2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}