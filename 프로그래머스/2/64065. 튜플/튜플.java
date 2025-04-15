import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        
        String str = s.substring(2, s.length() - 2);
        String[] strArr = str.split("\\},\\{");
        
        for (int i = 0; i < strArr.length; i++) {
            String[] arr = strArr[i].split(",");
            for (int j = 0; j < arr.length; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);   
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (s1, s2) -> map.get(s2) - map.get(s1));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}