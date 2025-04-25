import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int result = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            Queue<Character> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[skill.length()];
            String str = skill_trees[i];
            for (int j = 0; j < str.length(); j++) {
                queue.add(str.charAt(j));
            }
            
            boolean flag = true;
            while(!queue.isEmpty()) {
                char ch = queue.poll();
                for (int k = 0; k < skill.length(); k++) {
                    if (ch == skill.charAt(k) && k == 0) {
                        visited[k] = true;
                        continue;
                    }
                    
                    if (ch == skill.charAt(k)) {
                        if (visited[k-1]) {
                            visited[k] = true;
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    
                }
            }
            if (flag) {
                result++;
            }
        }
        
        
        return result;
    }
}