import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Arrays.sort(tangerine);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        int prev = 0;
        
        
        for (int i = 0; i < tangerine.length; i++) {
        
            set.add(tangerine[i]);
            
            if (tangerine[i] != prev) {
                map.put(tangerine[i], 1);
                prev = tangerine[i];
            } else {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }
        }
        
        int[] countArr = new int[set.size()];
        
        // for (int i = 0; i < set.size(); i++) {
        //     countArr[i] = map.get(set.get(i));
        // }
        
        Iterator<Integer> iter = set.iterator();
        
        
        int i = 0;
        while (iter.hasNext()) {
            countArr[i] = map.get(iter.next());
            i++;
        }
        
        Arrays.sort(countArr);
        
        int gyul = k; // 남은 귤 수
        
        int result = 0;
        
        for (int j = countArr.length-1; j >= 0; j--) {
            if (gyul - countArr[j] > 0) {
                gyul -= countArr[j];
                result++;
            } else {
                result++;
                break;
            }
        }
        
        return result;
    }
}