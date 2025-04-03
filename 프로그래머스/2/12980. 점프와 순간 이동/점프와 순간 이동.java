/*
dfs로 풀면 시간초과남 -> dp로 해결해야함 (그냥 dp 돌리면 메모리 초과남, 더 효율적인 방법을 찾아야함)
*/

import java.util.*;

public class Solution {
    
    public int solution(int n) {
        
        int result = 0;
        
        while(n != 0) {
            if (n % 2 != 0) {
                result++;
            }
            
            n /= 2;
        }
        
        return result;
    }
}