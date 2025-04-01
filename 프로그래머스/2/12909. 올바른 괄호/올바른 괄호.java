import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Queue<Character> queue = new ArrayDeque<>();    
        
        for (int i = 0; i < s.length(); i++) {
            
            if (queue.isEmpty()) {
                queue.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (queue.peek() == '(') {
                        queue.poll();
                    } else {
                        queue.add(s.charAt(i));
                    }
                } else {
                    queue.add(s.charAt(i));   
                }
            }
            
        }
        
        if (queue.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}