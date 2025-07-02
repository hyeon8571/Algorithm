import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            
            Map<Character, List<Integer>> alpha = new HashMap<>();
            
            for(int i=0; i<s.length(); i++) {
                List<Integer> list = alpha.getOrDefault(s.charAt(i), new ArrayList<>());
                list.add(i);
                alpha.put(s.charAt(i), list);
            }
            
            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;
            
            for(char key: alpha.keySet()) {
                List<Integer> list = alpha.get(key);
                if(list.size() < k) continue;
                
                for(int i=0; i<=list.size()-k; i++) {
                    int start = list.get(i);
                    int end = list.get(i+k-1);
                    int len = end - start + 1;
                    
                    minLen = Math.min(len, minLen);
                    maxLen = Math.max(len, maxLen);
                }
            }
            
            if(minLen==Integer.MAX_VALUE || maxLen==Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    
    }
}


