import java.util.*;

class Solution {
    
    static class Str implements Comparable<Str> {
        int index;
        String str;
        int n;
        
        public Str(int index, String str, int n) {
            this.index = index;
            this.str = str;
            this.n = n;
        }
        
        @Override
        public int compareTo(Str o) {
            if (this.str.charAt(n) != o.str.charAt(n)) {
                return this.str.charAt(n) - o.str.charAt(n);
            } else {
                return this.str.compareTo(o.str);
            }
        }
    }
    
    public String[] solution(String[] strings, int n) {
        
        List<Str> list = new ArrayList<>();
        
        
        for (int i = 0; i < strings.length; i++) {
            Str str = new Str(i, strings[i], n);
            list.add(str);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = strings[list.get(i).index];
        }
        
        
        return answer;
    }
}