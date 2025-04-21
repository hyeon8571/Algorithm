/*
중복순열
*/

import java.util.*;

class Solution {
    
    static List<String> list;
    static String[] arr;
    
    
    public int solution(String word) {
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        dfs(0, "");
        
        int count = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                count = i;
                break;
            }
        }
    
        return count;
    }
    
    public void dfs(int depth, String word) {
        
        list.add(word);
        
        if (depth >= 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(depth+1, word+arr[i]);
        }
        
    }
}