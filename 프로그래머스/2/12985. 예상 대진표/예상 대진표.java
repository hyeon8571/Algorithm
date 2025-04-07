import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        
        int count = 1;
        
        while (true) {
            
            // 무조건 하나 크다고 상대가 아님
            
            int test = Math.min(a, b); // a, b중 더 작은거
            
            if (a+1 == b || b+1 == a) {
                if (test % 2 == 1) {
                    break;
                }
            }
            
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = (a+1) / 2;
            }
            
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b = (b+1) / 2;
            }
            
            count++;
            
            
        }

        return count;
    }
}