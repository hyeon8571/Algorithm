import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        int result = 0;
        
        for (int i = 1; i <= order.length; i++) {
            stack.add(i);
            
            while(!stack.isEmpty()) {
                if (stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                    result++;
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}